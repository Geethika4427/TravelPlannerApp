package com.excelr.controller;

import org.springframework.web.bind.annotation.*;

import com.excelr.model.Itineraries;
import com.excelr.service.ItinerariesService;

import java.util.List;

@RestController
@RequestMapping("/api/itinerary")
@CrossOrigin(origins = "http://localhost:5175") 
public class ItinerariesController {
    private final ItinerariesService service;

    public ItinerariesController(ItinerariesService service) {
        this.service = service;
    }

    @GetMapping
    public List<Itineraries> getAllItineraries() {
        return service.getAllItineraries();
    }

    @GetMapping("/{id}")
    public Itineraries getItineraryById(@PathVariable Long id) {
        return service.getItineraryById(id);
    }

    @PostMapping
    public Itineraries createItinerary(@RequestBody Itineraries itinerary) {
        return service.createItinerary(itinerary);
    }

    @PutMapping("/{id}")
    public Itineraries updateItinerary(@PathVariable Long id, @RequestBody Itineraries itinerary) {
        return service.updateItinerary(id, itinerary);
    }

    @DeleteMapping("/{id}")
    public void deleteItinerary(@PathVariable Long id) {
        service.deleteItinerary(id);
    }
}
