package com.excelr.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "logins")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role_id; // Many-to-One relationship with Role

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    // Add the token field
    @Column(length = 500)
    private String token;

    // Getters and setters
    public Role getRole() {
        return role_id;
    }

    public void setRole(Role role) {
        this.role_id = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

