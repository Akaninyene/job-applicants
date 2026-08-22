// Defines the package where the repository class is located
package com.example.job.applicants.repository;

// Import the Certification model and Spring Data JPA classes needed for the repository
import com.example.job.applicants.model.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Defines a repository for managing Certification data in the database
@Repository
// Defines a repository interface for performing database operations on Certification entities
public interface CertificationRepository extends JpaRepository<Certification, Long> {
}
