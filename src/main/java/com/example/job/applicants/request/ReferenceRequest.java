package com.example.job.applicants.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ReferenceRequest {
    private String refereeFullName;
    private String jobTitle;
    private String organisation;
    private String relationship;
    private String email;
    private String phoneNumber;
    private String contactTime;
}
