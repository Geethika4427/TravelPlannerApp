package com.excelr.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelr.model.Register;

public interface RegisterRepo extends JpaRepository<Register, Long> {
	
    Register findByEmail(String email);
	
    boolean existsByEmail(String email); 
    
    Register findByResetToken(String resetToken);
	
	
}
