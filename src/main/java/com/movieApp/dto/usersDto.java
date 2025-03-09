package com.movieApp.dto;

import com.movieApp.Enum.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class usersDto {

    @NotBlank(message = "Please provide username!")
    private String username;

    @NotBlank(message = "Please provide password!")
    private String password;


    private Role role;
}
