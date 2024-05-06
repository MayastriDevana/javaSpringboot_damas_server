package com.damas.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.model.User;
import com.damas.payload.RegisterUserRequest;
import com.damas.payload.UserResponse;
import com.damas.repository.UserRepository;
import com.damas.security.BCrypt;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;


@Service //untuk menandakan bahwa ini adalah sebuah service
public class UserService {

    @Autowired // untuk menambahkan dependency injection
    private UserRepository userRepository;

    @Autowired
    private Validator validator;

    @Transactional
   public UserResponse register(RegisterUserRequest request) {
    Set<ConstraintViolation<RegisterUserRequest>> constraintViolation = validator.validate(request);

    // if(request.getRole() != "admin") {
    //     throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "request not allowed");
    // }

    if (constraintViolation.size() != 0) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "invalid username, password or name");
    }

    //cek user is already register
    if  (userRepository.existsById(request.getUsername())){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already register");
    }
    // create new user
    User user = new User();
    user.setUsername(request.getUsername());
    user.setRole(request.getRole());
    user.setName(request.getName());
    user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));

    userRepository.save(user);

    UserResponse response = new UserResponse(user.getUsername(), user.getName(), user.getRole());
    return response;

   }
}
