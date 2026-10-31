package com.example.job.applicants.controller;

import com.example.job.applicants.model.Applicant;
import com.example.job.applicants.request.ApplicantRequest;
import com.example.job.applicants.request.ApplicantUpdateRequest;
import com.example.job.applicants.service.ApplicantService;
import com.example.job.applicants.response.ApiDataResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Applicant management", description = "Apis for managing all applicants")
public class ApplicantController {

    //logging information
    private static final Logger logger = LoggerFactory.getLogger(ApplicantController.class);

    //call the applicant service
    private final ApplicantService applicantService;

    //construction injection
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    /**
     * @param applicantRequest details
     * @return AppApiResponse containing the applicants if found
     */

    @PostMapping("/create-applicant")
    @Operation(
            summary = "Create and save applicant",
            description = "create applicant"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Applicant created successfully",
                    content = @Content(schema = @Schema(implementation = ApiDataResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Resource not found"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad request"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error"
            )
    })

    public ResponseEntity<ApiDataResponse<?>> createApplicant(@RequestBody ApplicantRequest applicantRequest) {
        logger.info("Create applicant request");

        Applicant applicants = applicantService.saveApplicant(applicantRequest);

        logger.info("Create applicant successfully");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Applicant created successfully",
                        applicants
                )
        );
    }

    /**
     * @return AppApiResponse containing the find-all-applicants if found
     */
    @GetMapping("/find-all-applicants")
    @Operation(
            summary = "find all applicants",
            description = "find applicants"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Staff found successfully",
                    content = @Content(schema = @Schema(implementation = ApiDataResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Resource not found"
            ),


            @ApiResponse(
                    responseCode = "500",
                    description = "Internal server error"
            )
    })

    public ResponseEntity<ApiDataResponse<?>> findAllApplicants() {
        logger.info("Find all applicants");

        List<Applicant> applicants = applicantService.findAllApplicants();

        logger.info("Find all applicants successfully");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Applicants found successfully",
                        applicants
                )
        );
    }


}
