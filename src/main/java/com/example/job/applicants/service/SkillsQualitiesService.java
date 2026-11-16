package com.example.job.applicants.service;

import com.example.job.applicants.model.SkillsQualities;
import com.example.job.applicants.repository.SkillsQualitiesRepository;
import com.example.job.applicants.request.SkillsQualitiesRequest;
import com.example.job.applicants.request.SkillsQualitiesUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillsQualitiesService {

    //call the repository interface
    private final SkillsQualitiesRepository skillsQualitiesRepository;

    //constructor injection
    public SkillsQualitiesService(SkillsQualitiesRepository skillsQualitiesRepository) {
        this.skillsQualitiesRepository = skillsQualitiesRepository;
    }

    //method to create and save a new SkillsQualities
    public SkillsQualities saveSkillsQualities(SkillsQualitiesRequest skillsQualitiesRequest) {

        //skills qualities management
        SkillsQualities skillsQualities = new SkillsQualities();
        skillsQualities.setSkills(skillsQualitiesRequest.getSkills());
        skillsQualities.setQualities(skillsQualitiesRequest.getQualities());

        return skillsQualitiesRepository.save(skillsQualities);
    }

    //method to find all skillsQualities
    public List<SkillsQualities> findAllSkillsQualities() {
        return skillsQualitiesRepository.findAll();
    }

    //method to find skillsQualities by id
    public Optional<SkillsQualities> findSkillsQualitiesById(Long id) {
        return skillsQualitiesRepository.findById(id);
    }

    //method to update skillsQualities
    public SkillsQualities updateSkillsQualities(SkillsQualitiesUpdateRequest skillsQualitiesUpdateRequest) {

        SkillsQualities skillsQualities = skillsQualitiesRepository.findById(skillsQualitiesUpdateRequest.getId()).orElse(null);
        skillsQualities.setSkills(skillsQualitiesUpdateRequest.getSkills());
        skillsQualities.setQualities(skillsQualitiesUpdateRequest.getQualities());

        return skillsQualitiesRepository.save(skillsQualities);
    }

    //method to delete skills qualities by id
    public void deleteSkillsQualitiesById(Long id) {
        skillsQualitiesRepository.deleteById(id);
    }
}
