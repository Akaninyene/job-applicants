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
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String profilePhotoUrl;
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(length = 50)
    private String middleName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, length = 50)
    private String dateOfBirth;
    @Column(nullable = false, length = 50)
    private String gender;
    @Column(nullable = false, length = 50)
    private String maritalStatus;
    @Column(nullable = false, unique = true, length = 150)
    private String email;
    @Column(nullable = false, unique = true, length = 20)
    private String phoneNumber;
    @Column(unique = true, length = 50)
    private String alternativePhoneNumber;
    @Column(nullable = false, length = 250)
    private String address;
    @Column(nullable = false, length = 250)
    private String village;
    @Column(nullable = false, length = 250)
    private String localGovernment;
    @Column(nullable = false, length = 250)
    private String state;
    @Column(nullable = false, length = 250)
    private String nationality;
    @Column(length = 50)
    private String postCode;
    @Column(nullable = false, length = 20)
    private String nokFullName;
    @Column(nullable = false, length = 20)
    private String nokPhoneNumber;
    @Column(nullable = false, length = 250)
    private String nokRelationship;

}




