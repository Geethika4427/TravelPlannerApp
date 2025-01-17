//package com.excelr.service;
//
//import com.excelr.model.SearchTour;
//import com.excelr.repo.SearchTourRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.List;
//
//@Service
//public class SearchTourService {
//
//    @Autowired
//    private SearchTourRepo searchTourRepo;
//
//    public List<SearchTour> searchTours(String fromLocation, String toLocation, Date startDate, Date endDate) {
//        // Call the correct method from the repository
//        return searchTourRepo.findByFromLocationContainingAndToLocationContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual(
//                fromLocation, toLocation, startDate, endDate);
//    }
//}