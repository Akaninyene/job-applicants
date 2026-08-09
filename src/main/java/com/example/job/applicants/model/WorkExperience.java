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

//this model handles applicant's employment history
public class WorkExperience {

    //this section defines the model's fields and properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 150)
    private String companyName;
    @Column(length = 100)
    private String jobTitle;
    @Column(length = 10)
    private String employmentType;
    @Column(length = 15)
    private String responsibilities;
    @Column(length = 15)
    private String startDate;
    @Column(length = 15)
    private String endDate;
    @Column(length = 1000)
    private String yearsOfExperience;
    @Column(length = 15)
    private String currentlyWorking;

}
