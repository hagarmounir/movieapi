package com.movieApp.service;

import com.movieApp.dto.usersDto;

public interface authServiceInterface {

    public String registerUser(usersDto userDto);
    public String loginUser(usersDto userDto);
}
