package com.damas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.damas.model.User;
import com.damas.payload.RegisterUserRequest;
import com.damas.payload.UserResponse;
import com.damas.repository.UserRepository;
import com.damas.security.BCrypt;


@Service //untuk menandakan bahwa ini adalah sebuah service
public class UserService {

    @Autowired // untuk menambahkan dependency injection
    private UserRepository userRepository;

    // @Autowired
    // private Validator validator;

   public UserResponse register(RegisterUserRequest request) {
    //cek user is already register
    if  (userRepository.existsById(request.getUsername())){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already register");
    }
    // create new user
    User user = new User();
    user.setUsername(request.getUsername());
    user.setName(request.getName());
    user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));

    userRepository.save(user);

    UserResponse response = new UserResponse (user.getUsername(), user.getName());
    return response;

   }
}
