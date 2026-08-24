// Defines the package where the CertificationService class is located
package com.example.job.applicants.service;

// Import the classes and annotations needed to build the service
import com.example.job.applicants.model.Certification;
import com.example.job.applicants.repository.CertificationRepository;
import com.example.job.applicants.request.CertificationRequest;
import org.springframework.stereotype.Service;

import java.util.List;

// Marks the class as a service that contains the business logic for certifications
@Service
// Defines the service class responsible for handling certification-related operations
public class CertificationService {

    //call the CertificationRepository and provide a refence variable to the CertificationRepository object
    private final CertificationRepository certificationRepository;

    //constructor injection: inject the CertificationRepository into the CertificationService through the constructor
    public CertificationService(CertificationRepository certificationRepository) {
        this.certificationRepository = certificationRepository;
    }

    //Method to save a new certification
    public Certification saveCertification(CertificationRequest certificationRequest) {

        //Create a new instance of the Certification class
        Certification certification = new Certification();

        // Set the certification details using the values from the certification request
        certification.setCertificateName(certificationRequest.getCertificateName());
        certification.setIssuingOrganization(certificationRequest.getIssuingOrganization());
        certification.setCertificateNumber(certificationRequest.getCertificateNumber());
        certification.setIssueDate(certificationRequest.getIssueDate());
        certification.setExpiryDate(certificationRequest.getExpiryDate());

        // Save the certification details to the database and return the saved certification
        return certificationRepository.save(certification);
    }

    //method to find all certifications
    public List<Certification> findAllCertifications() {
        return certificationRepository.findAll();
    }
}
