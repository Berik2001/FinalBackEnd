package com.example.finaldiploma.service;

import com.example.finaldiploma.model.User;
import com.example.finaldiploma.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    boolean existsByEmailAndPassword(String email, String password) {
        return userRepository.existsByEmailAndPassword(email, password);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public Optional<User> findByPhone(String phone){
        return userRepository.findByPhone(phone);
    }

    public Optional<User> findById(Long id){
        return  userRepository.findById(id);
    }

    public Optional<User> findByUsername(String username){
        return userRepository.findByUsername(username);
    }
    public Optional<User> getAllByUsername(String username){
        return userRepository.getAllByUsername(username);
    }

    //Get All

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }







}