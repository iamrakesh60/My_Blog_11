package com.myblog.myblog11.controller;

import com.myblog.myblog11.entity.User;
import com.myblog.myblog11.service.EmailService;
import com.myblog.myblog11.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
// http://localhost:8080/api/registration
public class RegistrationController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;

    @PostMapping("/registration")
    public Map<String,String> registerUser(@RequestBody User user){

        // Register user without email verification
        User registeredUser = userService.registerUser(user);

        // Send OTP email for email verification
        emailService.sendOtpEmail(user.getEmail());

        return null;
    }
}
