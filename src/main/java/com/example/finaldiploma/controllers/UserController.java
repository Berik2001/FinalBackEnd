package com.example.finaldiploma.controllers;



import com.example.finaldiploma.model.User;
import com.example.finaldiploma.repository.UserRepository;
import com.example.finaldiploma.service.UserService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("")
    private List<User> getAllCategories() {
        return userService.getAllUsers();
    }

    @GetMapping("/phone")
    public Optional<User> currentEmail(Principal principal) {
        return userService.getAllByUsername(principal.getName());
    }
}