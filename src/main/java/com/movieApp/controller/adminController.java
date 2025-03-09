package com.movieApp.controller;

import com.movieApp.dto.movieDto;
import com.movieApp.service.adminService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class adminController {


    private final adminService adminService;

    public adminController(adminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/search")
    public String getMovies(@RequestParam String query) {
        return adminService.fetchMovies(query);
    }

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody movieDto MovieDto){
        adminService.addMovie(MovieDto);
        return ResponseEntity.ok("Movie added successfully!");
    }

    @PostMapping("/add-batch")
    public ResponseEntity<String> addMovies(@RequestBody List<movieDto> movieDtos) {
        adminService.addMovies(movieDtos);
        return ResponseEntity.ok("Movies added successfully!");
    }

    // Get a movie by OMDB ID
    @GetMapping("/get/{omdbId}")
    public ResponseEntity<movieDto> getMovie(@PathVariable String omdbId) {
        movieDto movie = adminService.getMovie(omdbId);
        return movie != null ? ResponseEntity.ok(movie) : ResponseEntity.notFound().build();
    }

    // Get all movies
    @GetMapping("/dashboard")
    public ResponseEntity<List<movieDto>> getAllMovies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        List<movieDto> movies = adminService.getAllMovies(pageable);
        return ResponseEntity.ok(movies);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable String id) {
        adminService.deleteMovie(id);
        return ResponseEntity.ok("Movie deleted successfully!");
    }

    @DeleteMapping("/delete-batch")
    public ResponseEntity<String> deleteMovies(@RequestBody List<String> ids) {
        adminService.deleteMovies(ids);
        return ResponseEntity.ok("Movies deleted successfully!");
    }

}
