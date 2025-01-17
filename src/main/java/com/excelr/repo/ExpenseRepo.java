package com.excelr.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelr.model.Expense;

public interface ExpenseRepo extends JpaRepository<Expense, Long> {

    List<Expense> findByUserId(Long userId); // To fetch expenses for a particular user

	
}
