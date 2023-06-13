package com.bank.authentication.controller;


import com.bank.authentication.user.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JwtController {

    @PostMapping("/validate-token")
    public User validateToken(@AuthenticationPrincipal User user) {
        return user;
    }
}
