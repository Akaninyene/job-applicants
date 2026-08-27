package com.example.job.applicants.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserUpdateRequest {
    private Long id;
    private String oldPassword;
    private String newPassword;
    private String confirmNewPassword;
}
