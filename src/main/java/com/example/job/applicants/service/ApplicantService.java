package com.example.job.applicants.service;

import com.example.job.applicants.model.Applicant;
import com.example.job.applicants.request.ApplicantRequest;
import com.example.job.applicants.request.ApplicantUpdateRequest;
import com.example.job.applicants.repository.ApplicantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {

    private final ApplicantRepository applicantRepository;


    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

//method to save a new applicant
    public Applicant saveApplicant(ApplicantRequest applicantRequest) {

        //applicant management
        Applicant applicants = new Applicant();
        applicants.setProfilePhotoUrl(applicantRequest.getProfilePhotoUrl());
        applicants.setFirstName(applicantRequest.getFirstName());
        applicants.setMiddleName(applicantRequest.getMiddleName());
        applicants.setLastName(applicantRequest.getLastName());
        applicants.setDateOfBirth(applicantRequest.getDateOfBirth());
        applicants.setGender(applicantRequest.getGender());
        applicants.setMaritalStatus(applicantRequest.getMaritalStatus());
        applicants.setEmail(applicantRequest.getEmail());
        applicants.setPhoneNumber(applicantRequest.getPhoneNumber());
        applicants.setAlternativePhoneNumber(applicantRequest.getAlternativePhoneNumber());
        applicants.setAddress(applicantRequest.getAddress());
        applicants.setVillage(applicantRequest.getVillage());
        applicants.setLocalGovernment(applicantRequest.getLocalGovernment());
        applicants.setState(applicantRequest.getState());
        applicants.setNationality(applicantRequest.getNationality());
        applicants.setPostCode(applicantRequest.getPostCode());
        applicants.setNokFullName(applicantRequest.getNokFullName());
        applicants.setNokPhoneNumber(applicantRequest.getNokPhoneNumber());
        applicants.setNokRelationship(applicantRequest.getNokRelationship());

        return applicantRepository.save(applicants);
    }

//method to find all staff
    public List<Applicant> findAllApplicants() {
        return applicantRepository.findAll();
    }

}
