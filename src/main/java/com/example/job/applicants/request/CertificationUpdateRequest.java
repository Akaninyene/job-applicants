package com.example.job.applicants.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CertificationUpdateRequest {
   private Long id;
    private String certificateName;
    private String issuingOrganization;
    private String certificateNumber;
    private String issueDate;
    private String expiryDate;
}
