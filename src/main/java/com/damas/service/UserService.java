package com.damas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.damas.repository.UserRepository;

import jakarta.validation.Validator;

@Service //untuk menandakan bahwa ini adalah sebuah service
public class UserService {

    @Autowired // untuk menambahkan dependency injection
    private UserRepository userRepository;

    @Autowired
    private Validator validator;

   
}
