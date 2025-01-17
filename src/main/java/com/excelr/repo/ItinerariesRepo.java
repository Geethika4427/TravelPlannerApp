package com.excelr.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excelr.model.Itineraries;

public interface ItinerariesRepo extends JpaRepository<Itineraries, Long> {

}
