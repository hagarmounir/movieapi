package com.movieApp.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class movieDto {

    @NotBlank(message = "Please provide movieID!")
    private String omdbID;

    @NotBlank(message = "Please provide title!")
    private String title;

    @NotBlank(message = "Please provide release year!")
    private String year;

    @NotBlank(message = "Please provide type!")
    private String type;

    @NotBlank(message = "Please provide poster!")
    private String poster;
}
