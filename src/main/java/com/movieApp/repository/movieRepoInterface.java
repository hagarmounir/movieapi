package com.movieApp.repository;

import com.movieApp.entity.movieEntity;
import jakarta.validation.constraints.NotBlank;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

public interface movieRepoInterface extends JpaRepository<movieEntity, String> {

    Optional<movieEntity> findByOmdbID(String omdbID);
    Page<movieEntity> findAll(Pageable pageable);  // Pagination support

    Page<movieEntity> findAllByTitleContainsIgnoreCase(String title, Pageable pageable);
}
