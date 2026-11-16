package com.example.job.applicants.service;

import com.example.job.applicants.model.WorkExperience;
import com.example.job.applicants.request.WorkExperienceRequest;
import com.example.job.applicants.request.WorkExperienceUpdateRequest;
import com.example.job.applicants.repository.WorkExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkExperienceService {

    //call the repository interface
    private final WorkExperienceRepository workExperienceRepository;

    //constructor injection
    public WorkExperienceService(WorkExperienceRepository workExperienceRepository) {
        this.workExperienceRepository = workExperienceRepository;
    }

    //method to create and save a new work experience
    public WorkExperience saveWorkExperience(WorkExperienceRequest workExperienceRequest) {

    //work experience management
    WorkExperience workExperience = new WorkExperience();
    workExperience.setOrganisation(workExperienceRequest.getOrganisation());
    workExperience.setJobTitle(workExperienceRequest.getJobTitle());
    workExperience.setEmploymentType(workExperienceRequest.getEmploymentType());
    workExperience.setWorkLocation(workExperienceRequest.getWorkLocation());
    workExperience.setStartDate(workExperienceRequest.getStartDate());
    workExperience.setEndDate(workExperienceRequest.getEndDate());
    workExperience.setResponsibilities(workExperienceRequest.getResponsibilities());
    workExperience.setAchievements(workExperienceRequest.getAchievements());
    workExperience.setReasonForLeaving(workExperienceRequest.getReasonForLeaving());
    workExperience.setEmployerName(workExperienceRequest.getEmployerName());
    workExperience.setEmployerJobTitle(workExperienceRequest.getEmployerJobTitle());
    workExperience.setEmployerEmail(workExperienceRequest.getEmployerEmail());
    workExperience.setEmployerPhoneNumber(workExperienceRequest.getEmployerPhoneNumber());

    return workExperienceRepository.save(workExperience);
 }

 //method to find all work experiences
    public List<WorkExperience> findAllWorkExperiences() {
        return workExperienceRepository.findAll();
 }

 //method to find work experience by id
    public Optional<WorkExperience> findWorkExperienceById(Long id) {
        return workExperienceRepository.findById(id);
 }

 //method to update work experience
    public WorkExperience updateWorkExperience(WorkExperienceUpdateRequest workExperienceUpdateRequest) {

        WorkExperience workExperience = workExperienceRepository.findById(workExperienceUpdateRequest.getId()).orElse(null);
        workExperience.setOrganisation(workExperienceUpdateRequest.getOrganisation());
        workExperience.setJobTitle(workExperienceUpdateRequest.getJobTitle());
        workExperience.setEmploymentType(workExperienceUpdateRequest.getEmploymentType());
        workExperience.setWorkLocation(workExperienceUpdateRequest.getWorkLocation());
        workExperience.setStartDate(workExperienceUpdateRequest.getStartDate());
        workExperience.setEndDate(workExperienceUpdateRequest.getEndDate());
        workExperience.setResponsibilities(workExperienceUpdateRequest.getResponsibilities());
        workExperience.setAchievements(workExperienceUpdateRequest.getAchievements());
        workExperience.setReasonForLeaving(workExperienceUpdateRequest.getReasonForLeaving());
        workExperience.setEmployerName(workExperienceUpdateRequest.getEmployerName());
        workExperience.setEmployerJobTitle(workExperienceUpdateRequest.getEmployerJobTitle());
        workExperience.setEmployerEmail(workExperienceUpdateRequest.getEmployerEmail());
        workExperience.setEmployerPhoneNumber(workExperienceUpdateRequest.getEmployerPhoneNumber());

        return workExperienceRepository.save(workExperience);
    }

    //method to delete work experience by id
    public void deleteWorkExperienceById(Long id) {
        workExperienceRepository.deleteById(id);
    }
}
