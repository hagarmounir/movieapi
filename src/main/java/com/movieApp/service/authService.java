package com.movieApp.service;

import com.movieApp.Enum.Role;
import com.movieApp.dto.usersDto;
import com.movieApp.entity.usersEntity;
import com.movieApp.repository.usersRepoInterface;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class authService implements authServiceInterface{


        private final usersRepoInterface usersRepo;
        private final PasswordEncoder passwordEncoder;

        public authService(usersRepoInterface usersRepo, PasswordEncoder passwordEncoder) {
            this.usersRepo = usersRepo;
            this.passwordEncoder = passwordEncoder;
        }

        //Signup
        public String registerUser(usersDto userDto) {
            if(usersRepo.findByUsername(userDto.getUsername()).isPresent()) {
                return "Username already taken!";
            }

            usersEntity newUser = new usersEntity();
            newUser.setUsername(userDto.getUsername());
            newUser.setPassword(passwordEncoder.encode(userDto.getPassword()));

            // Default new users to USER role unless specified as ADMIN
            if(userDto.getRole().toString().equals("ADMIN")) {
                newUser.setRole(Role.ADMIN);
            } else {
                newUser.setRole(Role.USER);
            }

            usersRepo.save(newUser);
            return "User registered successfully!";
        }
    // login
    public String loginUser(usersDto userDto) {
        Optional<usersEntity> user = usersRepo.findByUsername(userDto.getUsername());

        if(user.isPresent() && passwordEncoder.matches(userDto.getPassword(), user.get().getPassword())) {
            return "Login successful! Welcome, " + user.get().getUsername() + " (" + user.get().getRole() + ")";
        }
        return "Invalid username or password!";
    }

}
