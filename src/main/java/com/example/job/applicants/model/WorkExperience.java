package com.example.job.applicants.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table
public class WorkExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String organisation;
    @Column(nullable = false, length = 100)
    private String jobTitle;
    @Column(nullable = false, length = 100)
    private String employmentType;
    @Column(nullable = false, length = 100)
    private String workLocation;
    @Column(nullable = false, length = 100)
    private String startDate;
    @Column(nullable = false, length = 100)
    private String endDate;
    @Column(nullable = false, length = 1000)
    private String responsibilities;
    @Column(nullable = false, length = 1000)
    private String achievements;
    @Column(nullable = false, length = 500)
    private String reasonForLeaving;
    @Column(nullable = false, length = 100)
    private String employerName;
    @Column(nullable = false, length = 50)
    private String employerJobTitle;
    @Column(nullable = false, unique = true, length = 50)
    private String employerEmail;
    @Column(nullable = false, unique = true, length = 50)
    private String employerPhoneNumber;
}
