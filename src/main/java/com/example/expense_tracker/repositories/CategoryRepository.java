package com.example.expense_tracker.repositories;

import com.example.expense_tracker.entities.Category;
import com.example.expense_tracker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    boolean existsByCategoryNameAndUser(String categoryName, User user);
}
