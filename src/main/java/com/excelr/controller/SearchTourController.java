//package com.excelr.controller;
//
//import com.excelr.model.SearchTour;
//import com.excelr.service.SearchTourService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.format.annotation.DateTimeFormat;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Date;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/tours")
//public class SearchTourController {
//
//    @Autowired
//    private SearchTourService searchTourService;
//
////    @GetMapping("/search")
////    public List<SearchTour> searchTours(
////            @RequestParam String fromLocation,
////            @RequestParam String toLocation,
////            @RequestParam Date startDate,
////            @RequestParam Date endDate) {
////        return searchTourService.searchTours(fromLocation, toLocation, startDate, endDate);
////    }
//    
//    @GetMapping("/search")
//    public List<SearchTour> searchTours(
//        @RequestParam(required = false) String fromLocation,
//        @RequestParam(required = false) String toLocation,
//        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
//        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate
//    ) {
//        return searchTourService.searchTours(fromLocation, toLocation, startDate, endDate);
//    }
//}
