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
public class EducationQualifications {

@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String certificateUrl;
    @Column(nullable = false, length = 100)
    private String institution;
    @Column(nullable = false, length = 100)
    private String faculty;
    @Column(nullable = false, length = 100)
    private String department;
    @Column(nullable = false, length = 100)
    private String course;
    @Column(nullable = false, length = 100)
    private String qualification;
    @Column(nullable = false, length = 100)
    private String grade;
    @Column(nullable = false, length = 50)
    private String startDate;
    @Column(nullable = false, length = 50)
    private String completionDate;
    @Column(nullable = false, length = 100)
    private String countryOfStudy;

}
