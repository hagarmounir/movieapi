package com.movieApp.service;

import com.movieApp.dto.movieDto;
import com.movieApp.entity.movieEntity;
import com.movieApp.repository.movieRepoInterface;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class adminService implements adminServiceInterface{

    private final movieRepoInterface movieRepoInterface;
    private String omdbApiUrl;
    private String apiKey;
    private final RestTemplate restTemplate;


    public adminService(Environment env, RestTemplate restTemplate, movieRepoInterface movieRepoInterface) {
        this.omdbApiUrl = env.getProperty("omdb.api.url");
        this.apiKey = env.getProperty("omdb.api.key");
        this.restTemplate = restTemplate;
        this.movieRepoInterface = movieRepoInterface;
    }
    public String fetchMovies(String searchQuery) {
        String url = omdbApiUrl + "?s=" + searchQuery + "&apikey=" + apiKey;
        return restTemplate.getForObject(url, String.class);
    }

    public void addMovie(movieDto MovieDto) {
        if(movieRepoInterface.findByOmdbID(MovieDto.getOmdbID()).isEmpty()){
            movieEntity movie = new movieEntity();
            movie.setOmdbID(MovieDto.getOmdbID());
            movie.setTitle(MovieDto.getTitle());
            movie.setYear(MovieDto.getYear());
            movie.setType(MovieDto.getType());
            movie.setPoster(MovieDto.getPoster());
            movieRepoInterface.save(movie);
        }


    }

    @Override
    public void addMovies(List<movieDto> movieDtos) {
    List<movieEntity> movies = movieDtos.stream()
            .filter(dto -> movieRepoInterface.findByOmdbID(dto.getOmdbID()).isEmpty())
            .map(dto -> {
                movieEntity movie = new movieEntity();
                movie.setOmdbID(dto.getOmdbID());
                movie.setTitle(dto.getTitle());
                movie.setYear(dto.getYear());
                movie.setType(dto.getType());
                movie.setPoster(dto.getPoster());
                return movie;
            }).toList();
        if (!movies.isEmpty()) {
            movieRepoInterface.saveAll(movies);
        }
    }

    public movieDto getMovie(String omdbId) {
        Optional<movieEntity> movie = movieRepoInterface.findByOmdbID(omdbId);
        return movie.map(this::convertToDto).orElse(null);
    }

    public List<movieDto> getAllMovies(Pageable pageable) {
        Page<movieEntity> movies = movieRepoInterface.findAll(pageable);
        return movies.getContent().stream().map(this::convertToDto).collect(Collectors.toList());
    }

    public void deleteMovie(String omdbId) {
        movieRepoInterface.deleteById(omdbId);
    }

    public void deleteMovies(List<String> omdbIds) {
        movieRepoInterface.deleteAllById(omdbIds);
    }

    private movieDto convertToDto(movieEntity movie) {
        return new movieDto(movie.getOmdbID(), movie.getTitle(), movie.getYear(), movie.getType(), movie.getPoster());
    }



}
