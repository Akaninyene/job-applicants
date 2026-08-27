// Defines the package where the Request classes are stored
package com.example.job.applicants.request;

// Import Lombok annotations for generating boilerplate code
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Lombok annotations that generate getters, setters, and constructors automatically
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// Defines a request class used to receive profile details from the client
public class ApplicantRequest {

    // Defines the fields used to store the profile details
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
    private String profilePhotoUrl; //the length = 500 does not mean the image itself must be 500 KB or 500 pixels. It means the String stored in that column (e.g. URL/path = https://myapp.com/uploads/profile-photos/john.jpg) can contain up to 500 characters.
    private String nok_fullName;
    private String nok_phoneNumber;
    private String nok_address;
    private String nok_relationship;
}
