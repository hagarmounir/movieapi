package com.movieApp.service;

import com.movieApp.dto.movieDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface userServiceInterface {
    public List<movieDto> getAllMovies(Pageable pageable);
    public List<movieDto> fetchMovies(String searchQuery, Pageable pageable);
}
