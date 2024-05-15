package com.damas.service;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.model.User;
import com.damas.payload.LoginResponse;
import com.damas.payload.LoginUserRequest;
import com.damas.payload.RegisterUserRequest;
import com.damas.payload.UserResponse;
import com.damas.repository.UserRepository;
import com.damas.security.BCrypt;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    @Autowired
    private Environment env;

    // ###################################################################################
    @Transactional
    public UserResponse register(RegisterUserRequest request, String token) {
        validationService.validateRequest(request);

        User allAdmin = userRepository.findFirstByRole(env.getProperty("ROLE_GET_SUPER_ADMIN")).orElse(null);

        if (allAdmin == null && !request.getRole().equals(env.getProperty("ROLE_GET_SUPER_ADMIN"))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "no admin found");
        }

        if (allAdmin != null) {
            User admin = userRepository.findFirstByToken(token)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "request not allowed"));
            if (!admin.getRole().equals(env.getProperty("ROLE_GET_SUPER_ADMIN"))) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "request not allowed");
            }
        }

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already registered");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setRole(request.getRole());
        user.setName(request.getName());
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setStatus(request.getStatus());
        // user.lastLogin(Instant.now());

        userRepository.save(user);

        UserResponse response = new UserResponse(user.getUsername(), user.getName(), user.getRole(), user.getStatus());

        return response;
    }

    // ###################################################################################
    @Transactional
    public LoginResponse login(LoginUserRequest request) {
        validationService.validateRequest(request);

        User user = userRepository.findFirstByUsername(request.getUsername())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.FORBIDDEN, "Username or password invalid"));

        if (BCrypt.checkpw(request.getPassword(), user.getPassword())) {
            if (!user.getStatus().equals(env.getProperty("STATUS_GET_ACTIVE"))) {
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This account is inActive");
            }

            user.setToken(UUID.randomUUID().toString());
            user.setTokenExpiredAt(nextExpired());

            userRepository.save(user);

            return LoginResponse.builder().username(user.getUsername()).name(user.getName()).token(user.getToken())
                    .role(user.getRole()).build();
        } else {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Username or password invalid");
        }
    }

    private Long nextExpired() {
        Instant now = Instant.now();
        Instant next = now.plusSeconds(2 * 60 * 60);
        return next.toEpochMilli();
    }

    // ###################################################################################
    @Transactional
    public void logout(String token) {
        if (token == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "invalid request");
        }

        User user = userRepository.findFirstByToken(token)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User has not login"));

        if (user.getTokenExpiredAt() < Instant.now().toEpochMilli()) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User has logout by system");
        }

        user.setToken(null);
        user.setTokenExpiredAt(null);

        userRepository.save(user);
    }
}
