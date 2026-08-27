// Specifies the package where the model classes are stored.
package com.example.job.applicants.model;

// Import JPA annotations for database mapping and Lombok annotations for generating boilerplate code
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok annotations that generate getters, setters, and constructors automatically
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//Marks the class as a database entity and maps it to a database table
@Entity
@Table

// Defines the Profile class, which is used to store information about a user's profile.
public class Applicant {

    // Defines the profile fields and their database column constraints
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
    @Column(nullable = false, length = 50)
    private String nok_fullName;
    @Column(nullable = false, length = 20)
    private String nok_phoneNumber;
    @Column(nullable = false, length = 150)
    private String nok_address;
    @Column(nullable = false, length = 15)
    private String nok_relationship;
    @Column(nullable = false, length = 45)
    private Long userid;

}