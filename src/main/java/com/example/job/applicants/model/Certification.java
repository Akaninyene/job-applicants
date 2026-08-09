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

//this model holds applicant's professional qualifications
public class Certification {

    //this section defines the model's fields and properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private String certificateName;
    @Column(nullable = false, length = 200)
    private String issuingOrganization;
    @Column(length = 50)
    private String certificateNumber;
    @Column(nullable = false, length = 15)
    private String issueDate;
    @Column(length = 15)
    private String expiryDate;

}
