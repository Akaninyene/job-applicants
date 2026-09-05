package com.example.job.applicants.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ApplicantUpdateRequest {
    private long id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String dateOfBirth;
    private String gender;
    private String maritalStatus;
    private String nationality;
    private String state;
    private String localGovernment;
    private String village;
    private String address;
    private String nok_fullName;
    private String nok_phoneNumber;
    private String nok_address;
    private String nok_relationship;
    private Long userid;
}
