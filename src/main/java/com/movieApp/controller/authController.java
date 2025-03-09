package com.movieApp.controller;

import com.movieApp.dto.usersDto;
import com.movieApp.service.authService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class authController {

    private final authService authService;

    public authController(authService authService) {
        this.authService = authService;
    }

    //User Signup
    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@RequestBody usersDto userDto) {
        String response = authService.registerUser(userDto);
        return ResponseEntity.ok(response);
    }

    //User Login
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody usersDto userDto) {
        String response = authService.loginUser(userDto);
        return ResponseEntity.ok(response);
    }
}
