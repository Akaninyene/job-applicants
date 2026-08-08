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
//this model stores the applicant's profile
public class Profile {

    //this section defines the model's fields and properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String user; //the application is expected to automatically call the user information, so the user does not need to re-type those information they supplied while creating the account
    @Column(nullable = false, length = 15)
    private String dateOfBirth;
    @Column(nullable = false, length = 10)
    private String gender;
    @Column(nullable = false, length = 10)
    private String nationality;
    @Column(nullable = false, length = 15)
    private String state;
    @Column(nullable = false, length = 25)
    private String localGovernment;
    @Column(nullable = false, length = 100)
    private String village;
    @Column(length = 100)
    private String address;
    @Column(name = "profile_photo_url", length = 500) //the application is expected not to store the actual image inside the User table. the image will be stored in file/object storage and save its URL or path in the database.
    private String profilePhotoUrl; //the length = 500 does not mean the image itself must be 500 KB or 500 pixels. It means the String stored in that column (e.g. URL/path = https://myapp.com/uploads/profile-photos/john.jpg) can contain up to 500 characters.
    @Column(length = 1000)
    private String professionalSummary;



}