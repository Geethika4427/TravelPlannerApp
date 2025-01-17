package com.excelr.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelr.model.Login;

public interface LoginRepo extends JpaRepository<Login, Long> {

	 Login findByEmail(String email);
	
}
