// Defines the package where the repository class is located
package com.example.job.applicants.repository;

// Imports the Applicant class, JpaRepository for database operations, and Repository to mark this class as a repository
import com.example.job.applicants.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Defines a repository for managing Profile data in the database
@Repository
// Defines a repository interface for performing database operations on Applicant entities
public interface ApplicantRepository extends JpaRepository<Applicant,Long> {

}
