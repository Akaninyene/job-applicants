package com.example.job.applicants.service;

import com.example.job.applicants.model.Reference;
import com.example.job.applicants.repository.ReferenceRepository;
import com.example.job.applicants.request.ReferenceRequest;
import com.example.job.applicants.request.ReferenceUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReferenceService {

    //call the repository interface and provide reference ....
    private  final ReferenceRepository referenceRepository;

    //constructor injection
    public ReferenceService(ReferenceRepository referenceRepository) {
        this.referenceRepository = referenceRepository;
    }

    //method to create and save a new reference
    public Reference saveReference(ReferenceRequest referenceRequest) {

        //reference management
        Reference references = new Reference();
        references.setRefereeFullName(referenceRequest.getRefereeFullName());
        references.setJobTitle(referenceRequest.getJobTitle());
        references.setOrganisation(referenceRequest.getOrganisation());
        references.setRelationship(referenceRequest.getRelationship());
        references.setEmail(referenceRequest.getEmail());
        references.setPhoneNumber(referenceRequest.getPhoneNumber());
        references.setContactTime(referenceRequest.getContactTime());

        return referenceRepository.save(references);
    }

    //method to find all references
    public List<Reference> findAllReferences() { return referenceRepository.findAll();
    }

    //method to find reference by id
    public Optional<Reference> findReferenceById(Long id) {
        return referenceRepository.findById(id);
    }

    //method to update reference
    public Reference updateReference(ReferenceUpdateRequest referenceUpdateRequest) {

        Reference references = referenceRepository.findById(referenceUpdateRequest.getId()).orElse(null);
        references.setRefereeFullName(referenceUpdateRequest.getRefereeFullName());
        references.setJobTitle(referenceUpdateRequest.getJobTitle());
        references.setOrganisation(referenceUpdateRequest.getOrganisation());
        references.setRelationship(referenceUpdateRequest.getRelationship());
        references.setEmail(referenceUpdateRequest.getEmail());
        references.setPhoneNumber(referenceUpdateRequest.getPhoneNumber());
        references.setContactTime(referenceUpdateRequest.getContactTime());

        return referenceRepository.save(references);
    }

    //method to delete reference by id
    public void deleteReferenceById(Long id) {
        referenceRepository.deleteById(id);
    }
}
