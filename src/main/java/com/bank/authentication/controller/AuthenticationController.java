package com.bank.authentication.controller;

import com.bank.authentication.auth.AuthenticationRequest;
import com.bank.authentication.auth.AuthenticationResponse;
import com.bank.authentication.auth.AuthenticationService;
import com.bank.authentication.auth.RegisterRequest;
import com.bank.authentication.user.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        HttpHeaders headers = new HttpHeaders();
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            headers.add("Location", "/login");
            return ResponseEntity.ok().headers(headers).build();
        } else {
            AuthenticationResponse registered = service.register(request);
            headers.add("bearer", registered.getAccessToken());
            return ResponseEntity.created(URI.create("/login")).headers(headers).build();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }


}
