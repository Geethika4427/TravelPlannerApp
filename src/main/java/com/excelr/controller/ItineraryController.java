package com.excelr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excelr.model.Itinerary;
import com.excelr.service.ItineraryService;

@RestController
@RequestMapping("/api/itineraries")
public class ItineraryController {

	 @Autowired
	    private ItineraryService service;

	    @GetMapping("/next")
	    public ResponseEntity<?> getNextItinerary() {
	        Itinerary nextItinerary = service.getNextItinerary();
	        if (nextItinerary != null) {
	            return ResponseEntity.ok(nextItinerary);
	        } else {
	            return ResponseEntity.status(404).body("No upcoming trips found.");
	        }
	    }
	    
	    @PostMapping
	    public ResponseEntity<?> scheduleTrip(@RequestBody Itinerary itinerary) {
	        // Save the new itinerary to the database
	        Itinerary savedItinerary = service.saveItinerary(itinerary);
	        return ResponseEntity.status(HttpStatus.CREATED).body(savedItinerary);
	    }
	
}
