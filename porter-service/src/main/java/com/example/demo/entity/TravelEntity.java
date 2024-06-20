package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "travel")
public class TravelEntity {

	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "from_location")
	    private String from;

	    @Column(name = "to_location")
	    private String to;

	    @Column(name = "city")
	    private String city;

	    @Column(name = "date_time")
	    private LocalDateTime dateTime;

	    @Column(name = "weight")
	    private Double weight;

	    @Column(name = "expected_cost")
	    private Double expectedCost;

	    @Column(name = "voluntary")
	    private Boolean voluntary;

	    @Column(name = "created_date")
	    private LocalDateTime createdDate;

	    @Column(name = "created_by")
	    private String createdBy;

	    @Column(name = "updated_date")
	    private LocalDateTime updatedDate;

	    @Column(name = "updated_by")
	    private String updatedBy;

	    @Column(name = "status")
	    private String status;

	    // Getters and Setters
	    // Constructor(s)
	    // toString()
	}