//package com.excelr.service;
//
//
//import org.springframework.stereotype.Service;
//
//import com.excelr.model.Itineraries;
//import com.excelr.repo.ItinerariesRepo;
//
//import java.util.List;
//
//@Service
//public class ItinerariesService {
//    private final ItinerariesRepo repository;
//
//    public ItinerariesService(ItinerariesRepo repository) {
//        this.repository = repository;
//    }
//
//    public List<Itineraries> getAllItineraries() {
//        return repository.findAll();
//    }
//
//    public Itineraries getItineraryById(Long id) {
//        return repository.findById(id).orElseThrow(() -> new RuntimeException("Itinerary not found"));
//    }
//
//    public Itineraries createItinerary(Itineraries itinerary) {
//        return repository.save(itinerary);
//    }
//
//    public Itineraries updateItinerary(Long id, Itineraries itineraryDetails) {
//        Itineraries itinerary = repository.findById(id).orElseThrow(() -> new RuntimeException("Itinerary not found"));
//        itinerary.setName(itineraryDetails.getName());
//        itinerary.setDestination(itineraryDetails.getDestination());
//        itinerary.setStartDate(itineraryDetails.getStartDate());
//        itinerary.setEndDate(itineraryDetails.getEndDate());
//        itinerary.setNotes(itineraryDetails.getNotes());
//        return repository.save(itinerary);
//    }
//
//    public void deleteItinerary(Long id) {
//        repository.deleteById(id);
//    }
//}


package com.excelr.service;

import com.excelr.model.Itineraries;
import com.excelr.repo.ItinerariesRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItinerariesService {
    private final ItinerariesRepo repository;

    public ItinerariesService(ItinerariesRepo repository) {
        this.repository = repository;
    }

    public List<Itineraries> getAllItineraries() {
        return repository.findAll();
    }

    public Itineraries getItineraryById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Itinerary not found"));
    }

    public Itineraries createItinerary(Itineraries itinerary) {
        return repository.save(itinerary);
    }

    public Itineraries updateItinerary(Long id, Itineraries updatedItinerary) {
        Itineraries existingItinerary = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Itinerary not found"));
        
        existingItinerary.setName(updatedItinerary.getName());
        existingItinerary.setDestination(updatedItinerary.getDestination());
        existingItinerary.setStartDate(updatedItinerary.getStartDate());
        existingItinerary.setEndDate(updatedItinerary.getEndDate());
        existingItinerary.setNotes(updatedItinerary.getNotes());
        existingItinerary.setActivities(updatedItinerary.getActivities()); // Update activities
        existingItinerary.setBudget(updatedItinerary.getBudget()); // Update budget
        
        return repository.save(existingItinerary);
    }

    public void deleteItinerary(Long id) {
        repository.deleteById(id);
    }
}
