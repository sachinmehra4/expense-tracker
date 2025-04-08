package com.example.expense_tracker.repositories;

import com.example.expense_tracker.entities.Expense;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
	
	List<Expense> findByUserId(Long userId);
}

