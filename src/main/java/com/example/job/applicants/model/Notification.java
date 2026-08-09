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

//this model handles applicant's notifications
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String applicantName;
    @Column(nullable = false, length = 50)
    private String notificationTitle; //congratulations Akani
    @Column(length = 250)
    private String notificationDescription; //your application was successfully submitted on 09-08-2026 at 07:03
    @Column(nullable = false, length = 15)
    private String date;
    @Column(nullable = false, length = 15)
    private String time;

}
