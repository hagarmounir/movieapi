package com.movieApp.service;

import com.movieApp.dto.movieDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface adminServiceInterface {

    public String fetchMovies(String searchQuery);
    public void addMovie(movieDto MovieDto);
    public void addMovies(List<movieDto> movieDtos);
    movieDto getMovie(String omdbId);
    public List<movieDto> getAllMovies(Pageable pageable);
    public void deleteMovie(String omdbId);
    public void deleteMovies(List<String> omdbIds);

}

