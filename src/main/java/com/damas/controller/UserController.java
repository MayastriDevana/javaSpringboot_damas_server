package com.damas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.damas.payload.RegisterUserRequest;
import com.damas.payload.UserResponse;
import com.damas.payload.WebResponse;
import com.damas.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    
    @PostMapping(
        path = "/api/users",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> register(@RequestBody RegisterUserRequest request){
        UserResponse userResponse = userService.register(request);
        
        WebResponse<UserResponse> response = new WebResponse<>();
        response.setData(userResponse);
        response.setErrors(null);
        return response;
    }
    
}
