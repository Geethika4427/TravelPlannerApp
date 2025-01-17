package com.excelr.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.model.HolidayPackage;
import com.excelr.service.HolidayPackageService;

@RestController
@RequestMapping("/api/holiday-packages")
public class HolidayPackageController {

    @Autowired
    private HolidayPackageService holidayPackageService;

 // Get all holiday packages
    @GetMapping("/")
    public List<HolidayPackage> getAllHolidayPackages() {
        return holidayPackageService.getAllHolidayPackages();
    }

    // Get holiday package by ID
    @GetMapping("/{id}")
    public ResponseEntity<HolidayPackage> getHolidayPackageById(@PathVariable Long id) {
        Optional<HolidayPackage> holidayPackage = holidayPackageService.getHolidayPackageById(id);
        return holidayPackage.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new holiday package
    @PostMapping("/create")
    public ResponseEntity<HolidayPackage> createHolidayPackage(@RequestBody HolidayPackage holidayPackage) {
        HolidayPackage createdHolidayPackage = holidayPackageService.createHolidayPackage(holidayPackage);
        return ResponseEntity.status(201).body(createdHolidayPackage);
    }

    // Update an existing holiday package
    @PutMapping("/update/{id}")
    public ResponseEntity<HolidayPackage> updateHolidayPackage(
            @PathVariable Long id, @RequestBody HolidayPackage holidayPackage) {
        HolidayPackage updatedHolidayPackage = holidayPackageService.updateHolidayPackage(id, holidayPackage);
        return updatedHolidayPackage != null ? ResponseEntity.ok(updatedHolidayPackage)
                : ResponseEntity.notFound().build();
    }

    // Delete a holiday package by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteHolidayPackage(@PathVariable Long id) {
        return holidayPackageService.deleteHolidayPackage(id) ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}          
