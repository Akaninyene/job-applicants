package com.example.job.applicants.repository;

import com.example.job.applicants.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {

        Optional<Users> findByUserName(String userName);
}
