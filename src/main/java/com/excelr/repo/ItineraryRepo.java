package com.excelr.repo;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.excelr.model.Itinerary;

public interface ItineraryRepo extends JpaRepository<Itinerary, Long> {

	@Query("SELECT i FROM Itinerary i WHERE i.startDate > :currentDate ORDER BY i.startDate ASC")
    Itinerary findNextItinerary(LocalDate currentDate);
	
}
