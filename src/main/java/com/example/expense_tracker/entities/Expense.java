package com.example.expense_tracker.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("amount")
    private Double amount;
    @JsonProperty("description")
    private String description;
    
    private LocalDate date;

    @JsonProperty("category")
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @JsonProperty("user")
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

 

    public void setUser(User user) {
        this.user = user;
    }


    public void setCategory(Category category) {
        this.category = category;
    }
}

