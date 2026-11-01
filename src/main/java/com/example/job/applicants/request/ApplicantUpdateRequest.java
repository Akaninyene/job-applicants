package com.example.job.applicants.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantUpdateRequest {

    private Long id;
    private String profilePhotoUrl;
    private String firstName;
    private String middleName;
    private String lastName;
    private String dateOfBirth;
    private String gender;
    private String maritalStatus;
    private String email;
    private String phoneNumber;
    private String alternativePhoneNumber;
    private String address;
    private String village;
    private String localGovernment;
    private String state;
    private String nationality;
    private String postCode;
    private String nokFullName;
    private String nokPhoneNumber;
    private String nokRelationship;

}



