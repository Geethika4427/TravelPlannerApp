package com.excelr.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.excelr.model.Itinerary;
import com.excelr.repo.ItineraryRepo;

@Service
public class ItineraryService {

    @Autowired
    private ItineraryRepo repository;

    public Itinerary getNextItinerary() {
        return repository.findNextItinerary(LocalDate.now());
    }
    
    public Itinerary saveItinerary(Itinerary itinerary) {
        return repository.save(itinerary);
    }
}