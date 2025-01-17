package com.excelr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.model.HolidayPackage;
import com.excelr.repo.HolidayPackageRepo;

@Service
public class HolidayPackageService {

    @Autowired
    private HolidayPackageRepo holidayPackageRepository;

    // Get all holiday packages
    public List<HolidayPackage> getAllHolidayPackages() {
        return holidayPackageRepository.findAll();
    }

    // Get a holiday package by ID
    public Optional<HolidayPackage> getHolidayPackageById(Long id) {
        return holidayPackageRepository.findById(id);
    }

    // Create a new holiday package
    public HolidayPackage createHolidayPackage(HolidayPackage holidayPackage) {
        return holidayPackageRepository.save(holidayPackage);
    }

    // Update an existing holiday package
    public HolidayPackage updateHolidayPackage(Long id, HolidayPackage holidayPackage) {
        if (holidayPackageRepository.existsById(id)) {
            holidayPackage.setId(id);
            return holidayPackageRepository.save(holidayPackage);
        }
        return null;
    }

    // Delete a holiday package by ID
    public boolean deleteHolidayPackage(Long id) {
        if (holidayPackageRepository.existsById(id)) {
            holidayPackageRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
