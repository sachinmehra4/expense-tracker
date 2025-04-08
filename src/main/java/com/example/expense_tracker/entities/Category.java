package com.example.expense_tracker.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("categoryName")
    private String categoryName;
    
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
	public void setCategoryName(String categoryName2) {
		// TODO Auto-generated method stub
		this.categoryName=categoryName2;
	}
	public void setUser(User user2) {
		// TODO Auto-generated method stub
		this.user=user2;
		
	}
}

