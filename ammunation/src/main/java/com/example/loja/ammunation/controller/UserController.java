package com.example.loja.ammunation.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loja.ammunation.entity.User;
import com.example.loja.ammunation.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    
    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }
    
    @GetMapping("/{id}")
    public User getUserById(@PathVariable UUID id) {
        return userRepository.findById(id).orElse(null);
    }
    
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    
    @PutMapping("/{id}")
    public User updateUser(@PathVariable UUID id, @RequestBody User newUser) {
        return userRepository.findById(id)
            .map(user -> {
                user.setName(newUser.getName());
                user.setEmail(newUser.getEmail());
                user.setPassword(newUser.getPassword());
                user.setAuthority(newUser.getAuthority());
                return userRepository.save(user);
            })
            .orElse(null);
    }
    
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userRepository.deleteById(id);
    }
}