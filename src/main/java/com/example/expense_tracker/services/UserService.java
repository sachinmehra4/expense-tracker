package com.example.expense_tracker.services;

import com.example.expense_tracker.entities.User;
import com.example.expense_tracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create a new user
    public User createUser(User user) {
    	System.out.println("Received user: " + user);
        User savedUser = userRepository.save(user);
        System.out.println("Saved user: " + savedUser);
        return savedUser;
    }

    // Fetch user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }
}

