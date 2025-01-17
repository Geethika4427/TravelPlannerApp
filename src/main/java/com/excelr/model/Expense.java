package com.excelr.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;

    private double estimated;

    private double actual;

    private String description;

    private LocalDate date;

    private String paymentMethod;
    
    // Many-to-One relationship with Login
    @ManyToOne(fetch = FetchType.LAZY) // Use LAZY loading for performance optimization
    @JoinColumn(name = "user_id", nullable = false) // The foreign key column in the expenses table
    private Login user; // The associated Login (user)

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getEstimated() {
        return estimated;
    }

    public void setEstimated(double estimated) {
        this.estimated = estimated;
    }

    public double getActual() {
        return actual;
    }

    public void setActual(double actual) {
        this.actual = actual;
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

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    public Login getUser() {
        return user;
    }

    public void setUser(Login user) {
        this.user = user;
    }
}
