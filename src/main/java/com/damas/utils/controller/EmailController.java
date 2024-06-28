package com.damas.utils.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.damas.utils.payload.EmailRequest;
import com.damas.utils.service.EmailService;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/api/schedulesend-email")
    public String scheduleEmail(@RequestBody EmailRequest request) {
        emailService.scheduleEmail(request);
        return "Email sent successfully!";
    }
}
