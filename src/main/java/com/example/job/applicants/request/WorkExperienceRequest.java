package com.example.job.applicants.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceRequest {

    private String organisation;
    private String jobTitle;
    private String employmentType;
    private String workLocation;
    private String startDate;
    private String endDate;
    private String responsibilities;
    private String achievements;
    private String reasonForLeaving;
    private String employerName;
    private String employerJobTitle;
    private String employerEmail;
    private String employerPhoneNumber;
}

