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

//this model stores applicant's uploaded documents
public class Document {

    //this section defines the model's fields and properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String documentOwner;
    @Column(nullable = false, length = 255)
    private String documentName;
    @Column(nullable = false, length = 100)
    private String documentType; //cv certificate passport etc
    @Column(nullable = false, length = 100)
    private String fileType; //pdf, jpeg, etc
    @Column(nullable = false)
    private String fileSize;
    @Column(nullable = false, length = 500)
    private String fileUrl;
    @Column(length = 1000)
    private String documentDescription;
}
