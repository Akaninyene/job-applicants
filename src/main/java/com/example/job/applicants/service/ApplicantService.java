package com.example.job.applicants.service;

import com.example.job.applicants.model.Applicant;
import com.example.job.applicants.model.Users;
import com.example.job.applicants.repository.UserRepository;
import com.example.job.applicants.repository.ApplicantRepository;
import com.example.job.applicants.request.ApplicantRequest;
import com.example.job.applicants.request.ApplicantUpdateRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {

    //call the repositories and passwordEncoder method
    private final ApplicantRepository applicantRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    //constructor injection
    public ApplicantService(ApplicantRepository applicantRepository, PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.applicantRepository = applicantRepository;
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    //method to save a new applicant
    public Applicant saveApplicant(ApplicantRequest applicantRequest) {

        Users users = new Users();
        users.setUsername(applicantRequest.getEmail());
        users.setPassword(passwordEncoder.encode("password"));
        userRepository.save(users);

        //get id of the saved user
        Long userId = users.getId();

        //profile management
        Applicant applicant = new Applicant();
        applicant.setFirstName(applicantRequest.getFirstName());
        applicant.setMiddleName(applicantRequest.getMiddleName());
        applicant.setLastName(applicantRequest.getLastName());
        applicant.setPhoneNumber(applicantRequest.getPhoneNumber());
        applicant.setEmail(applicantRequest.getEmail());
        applicant.setDateOfBirth(applicantRequest.getDateOfBirth());
        applicant.setGender(applicantRequest.getGender());
        applicant.setMaritalStatus(applicantRequest.getMaritalStatus());
        applicant.setNationality(applicantRequest.getNationality());
        applicant.setState(applicantRequest.getState());
        applicant.setLocalGovernment(applicantRequest.getLocalGovernment());
        applicant.setVillage(applicantRequest.getVillage());
        applicant.setAddress(applicantRequest.getAddress());
        applicant.setNok_fullName(applicantRequest.getNok_fullName());
        applicant.setNok_phoneNumber(applicantRequest.getNok_phoneNumber());
        applicant.setNok_address(applicantRequest.getNok_address());
        applicant.setNok_relationship(applicantRequest.getNok_relationship());
        applicant.setUserid(userId);

        return applicantRepository.save(applicant);

    }

    //method to find all applicants
    public List<Applicant> findAllApplicants() {
        return applicantRepository.findAll();
}

    //method to find applicant by id
    public Optional<Applicant> findApplicantById(Long id) {
        return applicantRepository.findById(id);
    }

    //method to delete applicant by id
    public void deleteApplicantById(Long id) {
        applicantRepository.deleteById(id);
    }

    //method to update applicant's information
    public Applicant updateApplicant(ApplicantUpdateRequest applicantUpdateRequest) {

        Applicant applicants = applicantRepository.findById(applicantUpdateRequest.getId()).orElse(null);
        applicants.setFirstName(applicantUpdateRequest.getFirstName());
        applicants.setMiddleName(applicantUpdateRequest.getMiddleName());
        applicants.setLastName(applicantUpdateRequest.getLastName());
        applicants.setPhoneNumber(applicantUpdateRequest.getPhoneNumber());
        applicants.setEmail(applicantUpdateRequest.getEmail());
        applicants.setDateOfBirth(applicantUpdateRequest.getDateOfBirth());
        applicants.setGender(applicantUpdateRequest.getGender());
        applicants.setMaritalStatus(applicantUpdateRequest.getMaritalStatus());
        applicants.setNationality(applicantUpdateRequest.getNationality());
        applicants.setState(applicantUpdateRequest.getState());
        applicants.setLocalGovernment(applicantUpdateRequest.getLocalGovernment());
        applicants.setVillage(applicantUpdateRequest.getVillage());
        applicants.setAddress(applicantUpdateRequest.getAddress());
        applicants.setNok_fullName(applicantUpdateRequest.getNok_fullName());
        applicants.setNok_phoneNumber(applicantUpdateRequest.getNok_phoneNumber());
        applicants.setNok_address(applicantUpdateRequest.getNok_address());
        applicants.setNok_relationship(applicantUpdateRequest.getNok_relationship());
        applicants.setUserid(applicantUpdateRequest.getUserid());

        return applicantRepository.save(applicants);
    }
}


