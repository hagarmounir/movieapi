package com.movieApp.repository;

import com.movieApp.entity.usersEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface usersRepoInterface extends JpaRepository<usersEntity, String> {
    Optional<usersEntity> findByUsername(String username);
}
