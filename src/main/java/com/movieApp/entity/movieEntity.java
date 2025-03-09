package com.movieApp.entity;

import com.movieApp.config.MovieGeneratedId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "movies")
public class movieEntity {

    @Id
    @MovieGeneratedId
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "omdbID" , nullable = false)
    @NotBlank(message = "Please provide movieID!")
    private String omdbID;

    @Column(name = "title")
    @NotBlank(message = "Please provide title!")
    private String title;

    @Column(name = "year")
    @NotBlank(message = "Please provide release year!")
    private String year;

    @Column(name = "type")
    @NotBlank(message = "Please provide type!")
    private String type;

    @Column(name = "poster")
    @NotBlank(message = "Please provide poster!")
    private String poster;



}
