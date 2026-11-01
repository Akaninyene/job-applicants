package com.example.job.applicants.service;

import com.example.job.applicants.model.EducationQualifications;
import com.example.job.applicants.repository.EducationQualificationsRepository;
import com.example.job.applicants.request.EducationQualificationsRequest;
import com.example.job.applicants.request.EducationQualificationsUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducationQualificationsService {

    private final EducationQualificationsRepository educationQualificationsRepository;

    public EducationQualificationsService(EducationQualificationsRepository educationQualificationsRepository) {
        this.educationQualificationsRepository = educationQualificationsRepository;
    }

    //method to create and save new education qualifications
    public EducationQualifications saveEducationQualifications(EducationQualificationsRequest educationQualificationsRequest) {

    //education qualifications management
      EducationQualifications educationQualifications = new EducationQualifications();
      educationQualifications.setCertificateUrl(educationQualificationsRequest.getCertificateUrl());
      educationQualifications.setInstitution(educationQualificationsRequest.getInstitution());
      educationQualifications.setFaculty(educationQualificationsRequest.getFaculty());
      educationQualifications.setDepartment(educationQualificationsRequest.getDepartment());
      educationQualifications.setCourse(educationQualificationsRequest.getCourse());
      educationQualifications.setQualification(educationQualificationsRequest.getQualification());
      educationQualifications.setGrade(educationQualificationsRequest.getGrade());
      educationQualifications.setStartDate(educationQualificationsRequest.getStartDate());
      educationQualifications.setCompletionDate(educationQualificationsRequest.getCompletionDate());
      educationQualifications.setCountryOfStudy(educationQualificationsRequest.getCountryOfStudy());

      return educationQualificationsRepository.save(educationQualifications);

    }

    //method to find all education qualifications
    public List<EducationQualifications> findAllEducationQualifications() {
        return educationQualificationsRepository.findAll();
    }

    //method to find all education qualifications by id
    public Optional<EducationQualifications> findEducationQualificationsById(Long id) {
        return educationQualificationsRepository.findById(id);
    }

    //method to update education qualifications
    public EducationQualifications updateEducationQualifications(EducationQualificationsUpdateRequest educationQualificationsUpdateRequest) {

        EducationQualifications educationQualifications = educationQualificationsRepository.findById(educationQualificationsUpdateRequest.getId()).orElse(null);
        educationQualifications.setCertificateUrl(educationQualificationsUpdateRequest.getCertificateUrl());
        educationQualifications.setInstitution(educationQualificationsUpdateRequest.getInstitution());
        educationQualifications.setFaculty(educationQualificationsUpdateRequest.getFaculty());
        educationQualifications.setDepartment(educationQualificationsUpdateRequest.getDepartment());
        educationQualifications.setCourse(educationQualificationsUpdateRequest.getCourse());
        educationQualifications.setQualification(educationQualificationsUpdateRequest.getQualification());
        educationQualifications.setGrade(educationQualificationsUpdateRequest.getGrade());
        educationQualifications.setStartDate(educationQualificationsUpdateRequest.getStartDate());
        educationQualifications.setCompletionDate(educationQualificationsUpdateRequest.getCompletionDate());
        educationQualifications.setCountryOfStudy(educationQualificationsUpdateRequest.getCountryOfStudy());

        return educationQualificationsRepository.save(educationQualifications);
    }

    //method to delete education qualifications by id
    public void deleteEducationQualificationsById(Long id) {
        educationQualificationsRepository.deleteById(id);
    }
}
