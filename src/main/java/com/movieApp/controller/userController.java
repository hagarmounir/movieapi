package com.movieApp.controller;

import com.movieApp.dto.movieDto;
import com.movieApp.service.userService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {
    private userService userService;

    public userController(userService userService) {
        this.userService = userService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<movieDto>> fetchMovies(
            @RequestParam String query,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<movieDto> movies = userService.fetchMovies(query, pageable);
        return ResponseEntity.ok(movies);
    }

    // Get all movies
    @GetMapping("/dashboard")
    public ResponseEntity<List<movieDto>> getAllMovies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<movieDto> movies = userService.getAllMovies(pageable);
        return ResponseEntity.ok(movies);
    }
}

