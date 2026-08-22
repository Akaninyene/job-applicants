// Defines the package where the CertificationRequest class is located
package com.example.job.applicants.request;

// Import Lombok annotations for generating boilerplate code
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok annotations that generate getters, setters, and constructors automatically
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

// Defines a request class used to receive certification details from the client
public class CertificationRequest {

    // Defines the fields used to store the certification details
    private String certificateName;
    private String issuingOrganization;
    private String certificateNumber;
    private String issueDate;
    private String expiryDate;

}
