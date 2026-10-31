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
public class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String refereeFullName;
    @Column(nullable = false, length = 50)
    private String jobTitle;
    @Column(nullable = false, length = 100)
    private String organisation;
    @Column(nullable = false, length = 50)
    private String relationship;
    @Column(nullable = false, length = 100)
    private String email;
    @Column(nullable = false, length = 100)
    private String phoneNumber;
    @Column(length = 50)
    private String contactTime;
}

