package com.excelr.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelr.model.HolidayPackage;

public interface HolidayPackageRepo extends JpaRepository<HolidayPackage, Long> {

}
