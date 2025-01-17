package com.excelr.service;

import com.excelr.model.Expense;
import com.excelr.model.Login;
import com.excelr.repo.ExpenseRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {

    private final ExpenseRepo expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepo expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    // Create Expense
    public Expense createExpense(Expense expense, Login user) {
        expense.setUser(user); // Set the user for the expense
        return expenseRepository.save(expense);
    }

    // Get all Expenses
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    // Get Expense by ID
    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }

    // Update Expense
    public Expense updateExpense(Long id, Expense expenseDetails) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if (optionalExpense.isPresent()) {
            Expense expense = optionalExpense.get();
            expense.setCategory(expenseDetails.getCategory());
            expense.setEstimated(expenseDetails.getEstimated());
            expense.setActual(expenseDetails.getActual());
            expense.setDescription(expenseDetails.getDescription());
            expense.setDate(expenseDetails.getDate());
            expense.setPaymentMethod(expenseDetails.getPaymentMethod());
            return expenseRepository.save(expense);
        }
        return null; // Handle case where Expense not found
    }

    // Delete Expense
    public boolean deleteExpense(Long id) {
        if (expenseRepository.existsById(id)) {
            expenseRepository.deleteById(id);
            return true;
        }
        return false; // Handle case where Expense not found
    }
    
    // Get Expenses by User
    public List<Expense> getExpensesByUserId(Long userId) {
        return expenseRepository.findByUserId(userId);
    }
}
