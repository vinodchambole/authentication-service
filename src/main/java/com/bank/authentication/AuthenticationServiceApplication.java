package com.bank.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EntityScan(basePackages = {"com.bank.authentication"})
@RestController
public class AuthenticationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceApplication.class, args);
	}

	@GetMapping("/api/v1/manager")
	@PreAuthorize("hasAuthority('MANAGER')")
	public String getName1(){
		return "Hello";
	}

	@GetMapping("/api/v1/admin")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String getName(){
		return "Hello";
	}
}
