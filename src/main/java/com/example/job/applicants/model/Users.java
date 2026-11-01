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
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 45)
    private String userName;
    @Column(nullable = false, length = 225)
    private String password;
    @Column(nullable = false, length = 45, columnDefinition = "VARCHAR(45) DEFAULT '0'")
    private String isPasswordUpdate = "0";
}

