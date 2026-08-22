package com.example.job.applicants.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table
public class ProfessionalBody {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String professionalBodyName;
    @Column(nullable = false, length = 30)
    private String membershipType;
    @Column(nullable = false, length = 50)
    private String registrationNumber;
    @Column(nullable = false, length = 15)
    private String registrationDate;
    @Column(nullable = false, length = 15)
    private String expiryDate;
    @Column(nullable = false, length = 100)
    private String issuingCountry;
    @Column(length = 1000)
    private String professionalSummary;
}
