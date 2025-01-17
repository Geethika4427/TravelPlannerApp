//package com.excelr.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.Temporal;
//import jakarta.persistence.TemporalType;
//
//import java.util.Date;
//
//@Entity
//public class SearchTour {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String name;
//    private String fromLocation;
//    private String toLocation;
//
//    @Temporal(TemporalType.DATE)
//    private Date startDate;
//
//    @Temporal(TemporalType.DATE)
//    private Date endDate;
//
//    private Double price;
//
//    // Getters and Setters
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getFromLocation() {
//        return fromLocation;
//    }
//
//    public void setFromLocation(String fromLocation) {
//        this.fromLocation = fromLocation;
//    }
//
//    public String getToLocation() {
//        return toLocation;
//    }
//
//    public void setToLocation(String toLocation) {
//        this.toLocation = toLocation;
//    }
//
//    public Date getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(Date startDate) {
//        this.startDate = startDate;
//    }
//
//    public Date getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(Date endDate) {
//        this.endDate = endDate;
//    }
//
//    public Double getPrice() {
//        return price;
//    }
//
//    public void setPrice(Double price) {
//        this.price = price;
//    }
//}
