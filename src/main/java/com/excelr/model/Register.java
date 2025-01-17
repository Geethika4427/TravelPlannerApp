package com.excelr.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "registrations")
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;
    
    @Column(nullable = false)
    private LocalDate dob; 

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String contactNo;

//    @Column(nullable = false)
//    private String street;
//
//    @Column(nullable = false)
//    private String city;

    @Column(nullable = false)
    private String address;
    
    @Column(nullable = false)
    private String pincode;
    
 // Add the reset token field
    @Column(name = "reset_token", unique = true)
    private String resetToken;
}

