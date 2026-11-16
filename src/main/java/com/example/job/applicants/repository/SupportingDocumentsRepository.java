package com.example.job.applicants.repository;

import com.example.job.applicants.model.SupportingDocuments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportingDocumentsRepository extends JpaRepository<SupportingDocuments, Long> {
}
