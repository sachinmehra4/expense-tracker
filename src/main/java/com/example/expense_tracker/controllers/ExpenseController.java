package com.example.expense_tracker.controllers;

import com.example.expense_tracker.entities.Expense;
import com.example.expense_tracker.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.expense_tracker.dtos.ExpenseDTO;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // Fetch all expenses
    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    // Add a new expense
    @PostMapping
    public Expense createExpense(@RequestBody ExpenseDTO expenseDTO) {
        return expenseService.addExpense(expenseDTO);
    }
    
    @GetMapping("/user/{id}")
    public ResponseEntity<List<Expense>> getExpensesByUserId(@PathVariable("id") Long userId) {
        List<Expense> expenses = expenseService.getExpensesByUserId(userId);
        return ResponseEntity.ok(expenses);
    }

    // Fetch a single expense by ID
    @GetMapping("/{id}")
    public ResponseEntity<Expense> getExpenseById(@PathVariable Long id) {
        Optional<Expense> expense = expenseService.getExpenseById(id);
        return expense.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an existing expense
    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id, @RequestBody Expense updatedExpense) {
        Expense expense = expenseService.updateExpense(id, updatedExpense);
        return expense != null ? ResponseEntity.ok(expense) : ResponseEntity.notFound().build();
    }

    // Delete an expense
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpense(@PathVariable Long id) {
        boolean deleted = expenseService.deleteExpense(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}


