package com.excelr.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelr.model.ERole;
import com.excelr.model.Role;

public interface RoleRepo extends JpaRepository<Role, Long> {
	
	 Role findByName(ERole name);  

}
