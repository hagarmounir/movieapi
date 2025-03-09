package com.movieApp.service;

import com.movieApp.dto.movieDto;
import com.movieApp.entity.movieEntity;
import com.movieApp.repository.movieRepoInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class userService implements userServiceInterface{

    private final movieRepoInterface movieRepoInterface;

    public userService(movieRepoInterface movieRepoInterface) {
        this.movieRepoInterface = movieRepoInterface;
    }

    public List<movieDto> getAllMovies(Pageable pageable) {
        Page<movieEntity> movies = movieRepoInterface.findAll(pageable);
        return movies.getContent().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public List<movieDto> fetchMovies(String searchQuery, Pageable pageable) {
        Page<movieEntity> movies = movieRepoInterface.findAllByTitleContainsIgnoreCase(searchQuery, pageable);
        return movies.getContent().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private movieDto convertToDto(movieEntity movie) {
        return new movieDto(movie.getOmdbID(), movie.getTitle(), movie.getYear(), movie.getType(), movie.getPoster());
    }
}
