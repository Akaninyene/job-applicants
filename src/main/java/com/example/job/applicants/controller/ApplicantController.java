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
import java.util.Optional;

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

    /**
     * @return AppApiResponse containing the find-applicant-by-id if found
     */

    @GetMapping("/find-applicant-by-id/{id}")
    @Operation(
            summary = "find applicant by id",
            description = "find an applicant by its id"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Applicant id found successfully",
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

    public ResponseEntity<ApiDataResponse<?>> findApplicantById(@PathVariable Long id) {
        logger.info("Find applicant by id");

        Optional<Applicant> applicant = applicantService.findApplicantById(id);

        if (applicant.isEmpty()) {
            logger.info("Applicant not found");

            return ResponseEntity.ok(
                    new ApiDataResponse<>(
                            false,
                            "Applicant not found",
                            applicant

                    )
            );
        }

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Applicant found successfully",
                        applicant
                )
        );

    }


    /**
     * @param applicantUpdateRequest details
     * @return AppApiResponse containing the updated applicant if found
     */
    @PutMapping("/update-applicant")
    @Operation(
            summary = "Update and save applicant",
            description = "Update applicant"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Applicant updated successfully",
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

    public ResponseEntity<ApiDataResponse<?>> updateApplicant(@RequestBody ApplicantUpdateRequest applicantUpdateRequest) {
        logger.info("Update applicant request");

        Applicant applicant = applicantService.updateApplicant(applicantUpdateRequest);

        logger.info("Update applicant successfully");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Applicant updated successfully",
                        applicant
                )
        );
    }

    /**
     * @return AppApiResponse containing the deleted applicant if found
     */

    @DeleteMapping("/delete-applicant-by-id/{id}")
    @Operation(
            summary = "Delete applicant",
            description = "Delete applicant by id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Applicant deleted successfully",
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

    public ResponseEntity<ApiDataResponse<?>> deleteApplicantById(@PathVariable Long id) {
        Optional<Applicant> applicant = applicantService.findApplicantById(id);

        logger.info("Delete applicant by id successfully");

        if (applicant.isEmpty()) {
            logger.info("Applicant not found");
            return ResponseEntity.ok(
                    new ApiDataResponse<>(
                            false,
                            "Applicant not found",
                            applicant
                    )
            );
        }

        applicantService.deleteApplicantById(id);

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Applicant deleted successfully",
                        applicant
                )
        );
    }
}
