//package com.excelr.repo;
//
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.excelr.model.SearchTour;
//
//public interface SearchTourRepo extends JpaRepository<SearchTour, Long> {
//	 List<SearchTour> findByFromLocationContainingAndToLocationContainingAndStartDateGreaterThanEqualAndEndDateLessThanEqual(
//	            String fromLocation, String toLocation, Date startDate, Date endDate);
//}
