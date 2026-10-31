package com.example.job.applicants.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EducationQualificationsRequest {

    private String certificateUrl;
    private String institution;
    private String faculty;
    private String department;
    private String course;
    private String qualification;
    private String grade;
    private String startDate;
    private String completionDate;
    private String countryOfStudy;
}

