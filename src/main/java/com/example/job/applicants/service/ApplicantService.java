package com.example.job.applicants.service;

import com.example.job.applicants.model.Applicant;
import com.example.job.applicants.request.ApplicantRequest;
import com.example.job.applicants.request.ApplicantUpdateRequest;
import com.example.job.applicants.repository.ApplicantRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {

    //call the repository interface
    private final ApplicantRepository applicantRepository;

    //constructor injection
    public ApplicantService(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    //method to create and save a new applicant
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

    //method to find all applicants
    public List<Applicant> findAllApplicants() {
        return applicantRepository.findAll();
    }


    //method to find applicant by id
    public Optional<Applicant> findApplicantById(Long id) {
        return applicantRepository.findById(id);
    }

    //method to update applicant
    public Applicant updateApplicant(ApplicantUpdateRequest applicantUpdateRequest) {

        Applicant applicants = applicantRepository.findById(applicantUpdateRequest.getId()).orElse(null);
        applicants.setProfilePhotoUrl(applicantUpdateRequest.getProfilePhotoUrl());
        applicants.setFirstName(applicantUpdateRequest.getFirstName());
        applicants.setMiddleName(applicantUpdateRequest.getMiddleName());
        applicants.setLastName(applicantUpdateRequest.getLastName());
        applicants.setDateOfBirth(applicantUpdateRequest.getDateOfBirth());
        applicants.setGender(applicantUpdateRequest.getGender());
        applicants.setMaritalStatus(applicantUpdateRequest.getMaritalStatus());
        applicants.setEmail(applicantUpdateRequest.getEmail());
        applicants.setPhoneNumber(applicantUpdateRequest.getPhoneNumber());
        applicants.setAlternativePhoneNumber(applicantUpdateRequest.getAlternativePhoneNumber());
        applicants.setAddress(applicantUpdateRequest.getAddress());
        applicants.setVillage(applicantUpdateRequest.getVillage());
        applicants.setLocalGovernment(applicantUpdateRequest.getLocalGovernment());
        applicants.setState(applicantUpdateRequest.getState());
        applicants.setNationality(applicantUpdateRequest.getNationality());
        applicants.setPostCode(applicantUpdateRequest.getPostCode());
        applicants.setNokFullName(applicantUpdateRequest.getNokFullName());
        applicants.setNokPhoneNumber(applicantUpdateRequest.getNokPhoneNumber());
        applicants.setNokRelationship(applicantUpdateRequest.getNokRelationship());

        return applicantRepository.save(applicants);

    }

    //method to delete applicant by id
    public void deleteApplicantById(Long id) {
        applicantRepository.deleteById(id);
    }
}







