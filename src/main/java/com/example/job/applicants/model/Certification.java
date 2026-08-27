// Defines the package where the Certification class is located
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

// Defines the Certification class, which is used to store certification information.
public class Certification {

    // Defines the certification fields and their database column constraints
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private String certificateName;
    @Column(nullable = false, length = 200)
    private String issuingOrganization;
    @Column(length = 50)
    private String certificateNumber;
    @Column(nullable = false, length = 15)
    private String issueDate;
    @Column(length = 15)
    private String expiryDate;

}
