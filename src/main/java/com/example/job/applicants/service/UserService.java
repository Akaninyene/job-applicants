package com.example.job.applicants.service;

import com.example.job.applicants.model.Users;
import com.example.job.applicants.repository.UserRepository;
import com.example.job.applicants.request.UserUpdateRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    //find all users
    public List<Users> findAllUsers() {
        return userRepository.findAll();
    }

    //update password
    public Users updateUserPassword(UserUpdateRequest userUpdateRequest) {
        String newPassword = userUpdateRequest.getNewPassword();
        String confirmNewPassword = userUpdateRequest.getConfirmNewPassword();

        //validate passwords
        if (newPassword == null || newPassword.isBlank()) {
            throw new IllegalArgumentException("New password is required");
        }

        if (confirmNewPassword == null || confirmNewPassword.isEmpty()) {
            throw new IllegalArgumentException("Confirm new password is required");
        }

        //Compare new password and confirm password
        if (!newPassword.equals(confirmNewPassword)) {
            throw new IllegalArgumentException("New password and confirm new passwords do not match");
        }

        //Get the user
        Users users = userRepository.findById(userUpdateRequest.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        //Encode password before saving
        users.setPassword(passwordEncoder.encode(newPassword));

        //Save and return updated user
        return userRepository.save(users);
    }
}