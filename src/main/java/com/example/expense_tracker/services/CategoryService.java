package com.example.expense_tracker.services;

import com.example.expense_tracker.dtos.CategoryDTO;
import com.example.expense_tracker.entities.Category;
import com.example.expense_tracker.entities.User;
import com.example.expense_tracker.repositories.CategoryRepository;
import com.example.expense_tracker.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;

    public CategoryService(CategoryRepository categoryRepository, UserRepository userRepository) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
    }

    // Create a new category
    public Category createCategory(CategoryDTO categoryDTO) {
        Optional<User> userOptional = userRepository.findById(categoryDTO.getUserId());

        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found with ID: " + categoryDTO.getUserId());
        }
        else {
        	System.out.println("User found with ID: "+ categoryDTO.getUserId());
        }
        
        

        // Prevent duplicate category names for the same user
        boolean exists = categoryRepository.existsByCategoryNameAndUser(categoryDTO.getCategoryName(), userOptional.get());
        if (exists) {
            throw new RuntimeException("Category already exists for this user.");
        }
        
        User user = userOptional.get();
        Category category = new Category();
        category.setCategoryName(categoryDTO.getCategoryName());
        category.setUser(user);

        return categoryRepository.save(category);
    }

    // Get all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
}
