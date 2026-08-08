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
//this model handles authentication and authorization of users
public class User {

    //this section defines the model's fields and properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, unique = true, length = 20)
    private String phoneNumber;
    @Column(nullable = false, unique = true, length = 100)
    private String email;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false, length = 100)
    private String confirmPassword;
    @Column(nullable = false, length = 100)
    private String role;
    @Column(nullable = false, length = 100)
    private String isActive;
    @Column(nullable = false)
    private String createdAt;
    @Column(nullable = false)
    private String lastModified;

}
