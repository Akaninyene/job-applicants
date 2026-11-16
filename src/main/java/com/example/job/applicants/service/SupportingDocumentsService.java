package com.example.job.applicants.service;

import com.example.job.applicants.model.SupportingDocuments;
import com.example.job.applicants.repository.SkillsQualitiesRepository;
import com.example.job.applicants.repository.SupportingDocumentsRepository;
import com.example.job.applicants.request.SupportingDocumentsRequest;
import com.example.job.applicants.request.SupportingDocumentsUpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupportingDocumentsService {

    //call the repository interface
    private final SupportingDocumentsRepository supportingDocumentsRepository;

    //constructor injection
    public SupportingDocumentsService(SupportingDocumentsRepository supportingDocumentsRepository) {
        this.supportingDocumentsRepository = supportingDocumentsRepository;
    }

    //method to create and save a new SupportingDocuments
    public SupportingDocuments saveSupportingDocuments(SupportingDocumentsRequest supportingDocumentsRequest) {

        //SupportingDocuments management
        SupportingDocuments supportingDocument = new SupportingDocuments();
        supportingDocument.setDocumentUrl(supportingDocumentsRequest.getDocumentUrl());
        supportingDocument.setDocumentName(supportingDocumentsRequest.getDocumentName());
        supportingDocument.setDocumentType(supportingDocumentsRequest.getDocumentType());

        return supportingDocumentsRepository.save(supportingDocument);

    }

    //method to find all SupportingDocuments
    public List<SupportingDocuments> findAllSupportingDocuments() {
        return supportingDocumentsRepository.findAll();
    }

    //method to find supporting documents by id
    public Optional<SupportingDocuments> findSupportingDocumentById(Long id) {
        return supportingDocumentsRepository.findById(id);
    }

    //method to update supporting documents
    public SupportingDocuments updateSupportingDocuments(SupportingDocumentsUpdateRequest supportingDocumentsUpdateRequest) {

        SupportingDocuments supportingDocument = supportingDocumentsRepository.findById(supportingDocumentsUpdateRequest.getId()).orElse(null);
        supportingDocument.setDocumentUrl(supportingDocumentsUpdateRequest.getDocumentUrl());
        supportingDocument.setDocumentName(supportingDocumentsUpdateRequest.getDocumentName());
        supportingDocument.setDocumentType(supportingDocumentsUpdateRequest.getDocumentType());

        return supportingDocumentsRepository.save(supportingDocument);
    }

    //method to delete supporting document by id
    public void deleteSupportingDocumentById(Long id) {
        supportingDocumentsRepository.deleteById(id);
    }
}
