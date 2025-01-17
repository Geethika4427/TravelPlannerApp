package com.excelr.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Itineraries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String destination;
    private String startDate;
    private String endDate;
    private String notes;

    @ElementCollection
    private List<String> activities; // For storing a list of activities

    private Double budget; // For storing the budget
}
