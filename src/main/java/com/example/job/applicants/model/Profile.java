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

    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(length = 50)
    private String middleName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, unique = true, length = 20)
    private String phoneNumber;
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    @Column(nullable = false, length = 15)
    private String dateOfBirth;
    @Column(nullable = false, length = 10)
    private String gender;
    @Column(nullable = false, length = 10)
    private String maritalStatus;
    @Column(nullable = false, length = 10)
    private String nationality;
    @Column(nullable = false, length = 15)
    private String state;
    @Column(nullable = false, length = 25)
    private String localGovernment;
    @Column(nullable = false, length = 200)
    private String village;
    @Column(length = 200)
    private String address;
    @Column(name = "profile_photo_url", length = 500) //the application is expected not to store the actual image inside the User table. the image will be stored in file/object storage and save its URL or path in the database.
    private String profilePhotoUrl; //the length = 500 does not mean the image itself must be 500 KB or 500 pixels. It means the String stored in that column (e.g. URL/path = https://myapp.com/uploads/profile-photos/john.jpg) can contain up to 500 characters.




}