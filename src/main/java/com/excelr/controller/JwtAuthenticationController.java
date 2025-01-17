package com.excelr.controller;

import com.excelr.model.ERole;
import com.excelr.model.JwtRequest;
import com.excelr.model.JwtResponse;
import com.excelr.model.Login;
import com.excelr.model.Register;
import com.excelr.model.Role;
import com.excelr.repo.LoginRepo;
import com.excelr.repo.RegisterRepo;
import com.excelr.repo.RoleRepo;
import com.excelr.security.JwtTokenUtil;


import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@RestController
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private LoginRepo loginRepo;

    @Autowired
    private RoleRepo roleRepo;  
    
    @Autowired
    private RegisterRepo registerRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private JavaMailSender mailSender; // Ensure mail configuration is set in `application.properties`

//    @PostMapping("/login")
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
//        try {
//            // Use email for authentication
//            authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
//        } catch (Exception e) {
//            // Log the error for debugging purposes
//            System.out.println("Authentication failed: " + e.getMessage());
//            throw e;
//        }
//
//        // Load user details using email
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
//
//        // Generate JWT token
//        final String token = jwtTokenUtil.generateToken(userDetails);
//
//        return ResponseEntity.ok(new JwtResponse(token));
//    }
   
    
    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        try {
            authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());
        } catch (Exception e) {
            System.out.println("Authentication failed: " + e.getMessage());
            throw e;
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        final String token = jwtTokenUtil.generateToken(userDetails);

        // Check if the user already exists in the login table
        Login login = loginRepo.findByEmail(authenticationRequest.getEmail());
        if (login == null) {
            // Create a new Login entity
            login = new Login();
            login.setEmail(authenticationRequest.getEmail());
            login.setPassword(authenticationRequest.getPassword()); // Save or retrieve an encoded password

            // Fetch a default role (e.g., ROLE_USER) from the Role table
            Role defaultRole = roleRepo.findByName(ERole.ROLE_USER); // Use ERole enum
            if (defaultRole == null) {
                throw new Exception("Default role not found in the database");
            }

            login.setRole(defaultRole); // Set the role
        }

        // Set the token
        login.setToken(token);
        loginRepo.save(login);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Register register) {
        // Check if the email already exists in the database
        if (registerRepo.existsByEmail(register.getEmail())) {
            return ResponseEntity.badRequest().body("Email already registered");
        }

        // Encode the password before saving
        register.setPassword(passwordEncoder.encode(register.getPassword()));

        // Save the user registration to the database
        registerRepo.save(register);

        return ResponseEntity.ok("User registered successfully");
    }
    
    @PostMapping("/forgot-password")
    public ResponseEntity<?> processForgotPassword(@RequestBody Map<String, String> request) {
        String email = request.get("email");
        Register user = registerRepo.findByEmail(email);

        if (user == null) {
            return ResponseEntity.badRequest().body("User not found");
        }

        // Generate a reset token
        String resetToken = UUID.randomUUID().toString();
        user.setResetToken(resetToken);
        registerRepo.save(user);

        // Send email
        String resetLink = "http://localhost:9000/auth/reset-password?token=" + resetToken;
        sendResetEmail(email, resetLink);

        return ResponseEntity.ok("Password reset link has been sent to your email");
    }

//    private void sendResetEmail(String email, String resetLink) {
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setTo(email);
//        message.setSubject("Password Reset Request");
//        message.setText("Click the link below to reset your password:\n" + resetLink);
//        mailSender.send(message);
//    }
    
    
    private void sendResetEmail(String email, String resetLink) {
        Register user = registerRepo.findByEmail(email);

        if (user == null) {
            throw new RuntimeException("User not found with email: " + email);
        }

        // Generate the reset link pointing to the frontend
        String frontendResetLink = "http://localhost:5173/reset-password/" + user.getResetToken();

        // Create the email message
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Password Reset Request");
        message.setText("Click the link below to reset your password:\n" + frontendResetLink);

        // Send the email
        mailSender.send(message);
    }


    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody Map<String, String> request) {
        String token = request.get("token");
        String newPassword = request.get("newPassword");

        Register user = registerRepo.findByResetToken(token);

        if (user == null) {
            return ResponseEntity.badRequest().body("Invalid or expired token");
        }

        // Update password
        user.setPassword(passwordEncoder.encode(newPassword));
        user.setResetToken(null); // Clear the reset token
        registerRepo.save(user);

        return ResponseEntity.ok("Password has been reset successfully");
    }

    
    private void authenticate(String email, String password) throws Exception {
        // Load user details from the database using email
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        // Verify if the password matches the encoded password
        if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            throw new BadCredentialsException("INVALID_CREDENTIALS");
        }

        // Perform authentication with Spring Security
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
    }
   
}
