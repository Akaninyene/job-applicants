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

//this model stores applicant's academic history
public class Education {

    //this section defines the model's fields and properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200)
    private String institution;
    @Column(nullable = false, length = 150)
    private String fieldOfStudy;
    @Column(nullable = false, length = 15)
    private String startDate;
    @Column(nullable = false, length = 15)
    private String endDate;
    @Column(nullable = false, length = 100)
    private String qualification;
    @Column(nullable = false, length = 100)
    private String grade;

}
