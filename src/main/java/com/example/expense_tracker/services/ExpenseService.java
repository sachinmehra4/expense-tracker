package com.example.expense_tracker.services;

import com.example.expense_tracker.dtos.ExpenseDTO;
import com.example.expense_tracker.entities.Category;
import com.example.expense_tracker.entities.Expense;
import com.example.expense_tracker.entities.User;
import com.example.expense_tracker.repositories.CategoryRepository;
import com.example.expense_tracker.repositories.ExpenseRepository;
import com.example.expense_tracker.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

	private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public ExpenseService(ExpenseRepository expenseRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    public Expense addExpense(ExpenseDTO expenseDTO) {
        User user = userRepository.findById(expenseDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + expenseDTO.getUserId()));

        Category category = categoryRepository.findById(expenseDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found with ID: " + expenseDTO.getCategoryId()));

        Expense expense = new Expense();
        expense.setAmount(expenseDTO.getAmount());
        expense.setDescription(expenseDTO.getDescription());
        expense.setDate(expenseDTO.getDate());
        expense.setUser(user);
        expense.setCategory(category);

        return expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }
    
    public List<Expense> getExpensesByUserId(Long userId) {
        return expenseRepository.findByUserId(userId);
    }

    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    public Expense updateExpense(Long id, Expense updatedExpense) {
        return expenseRepository.findById(id).map(expense -> {
            expense.setAmount(updatedExpense.getAmount());
            expense.setDescription(updatedExpense.getDescription());
            expense.setDate(updatedExpense.getDate());
            return expenseRepository.save(expense);
        }).orElse(null);
    }

    public boolean deleteExpense(Long id) {
        return expenseRepository.findById(id).map(expense -> {
            expenseRepository.delete(expense);
            return true;
        }).orElse(false);
    }
}


