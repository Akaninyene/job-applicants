package com.example.job.applicants.controller;

import com.example.job.applicants.model.WorkExperience;
import com.example.job.applicants.request.WorkExperienceRequest;
import com.example.job.applicants.request.WorkExperienceUpdateRequest;
import com.example.job.applicants.service.WorkExperienceService;
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
@Tag(name = "Work experience management", description = "Apis for managing all Work experience")
public class WorkExperienceController {

    //logging information
    private static final Logger logger = LoggerFactory.getLogger(WorkExperienceController.class);

    //call the reference service
    private final WorkExperienceService workExperienceService;

    //constructor injection
    public WorkExperienceController(WorkExperienceService workExperienceService) {
        this.workExperienceService = workExperienceService;
    }

    /**
     * @param workExperienceRequest details
     * @return AppApiResponse containing the workExperience if found
     */

    @PostMapping("/create-workExperience")
    @Operation(
            summary = "Create and save work experience",
            description = "create work experience"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Work experience created successfully",
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

    public ResponseEntity<ApiDataResponse<?>> createWorkExperience(@RequestBody WorkExperienceRequest workExperienceRequest) {
        logger.info("Create work experience request");

        WorkExperience workExperiences = workExperienceService.saveWorkExperience(workExperienceRequest);

        logger.info("Create work experience successfully");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Work experience created successfully",
                        workExperiences
                )
        );
    }

    /**
     * @return AppApiResponse containing the find-all-workExperience if found
     */
    @GetMapping("/find-all-workExperience")
    @Operation(
            summary = "find all work experience",
            description = "find work experience"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "work experience found successfully",
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

    public ResponseEntity<ApiDataResponse<?>> findAllWorkExperiences() {
        logger.info("find all work experience successfully");

        List<WorkExperience> workExperiences = workExperienceService.findAllWorkExperiences();

        logger.info("find all work experience successfully");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Work experience found successfully",
                        workExperiences
                )
        );
    }

    /**
     * @return AppApiResponse containing the find-Work-experience-by-id if found
     */

    @GetMapping("/find-workExperience-by-id/{id}")
    @Operation(
            summary = "find work experience by id",
            description = "find a work experience by its id"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Work experience id found successfully",
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

    public ResponseEntity<ApiDataResponse<?>> findWorkExperienceById(@PathVariable Long id) {
        logger.info("find work experience by id");

        Optional<WorkExperience> workExperiences = workExperienceService.findWorkExperienceById(id);

        if(workExperiences.isEmpty()) {
            logger.info("Work experience not found");

            return ResponseEntity.ok(
                    new ApiDataResponse<>(
                            false,
                            "Work experience not found",
                            workExperiences
                    )
            );
        }

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Work experience found successfully",
                        workExperiences
                )
        );
    }

    /**
     * @param workExperienceUpdateRequest details
     * @return AppApiResponse containing the updated workExperience if found
     */
    @PutMapping("/update-workExperience")
    @Operation(
            summary = "Update and save work experience",
            description = "Update work experience"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Work experience updated successfully",
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

    public ResponseEntity<ApiDataResponse<?>> updateWorkExperience(@RequestBody WorkExperienceUpdateRequest workExperienceUpdateRequest) {
        logger.info("Update work experience request");

        WorkExperience workExperiences = workExperienceService.updateWorkExperience(workExperienceUpdateRequest);

        logger.info("Update work experience successfully");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Work experience updated successfully",
                        workExperiences
                )
        );
    }

    /**
     * @return AppApiResponse containing the deleted work experience if found
     */

    @DeleteMapping("/delete-workExperience-by-id/{id}")
    @Operation(
            summary = "Delete work experience",
            description = "Delete work experience by id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Work experience deleted successfully",
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

    public ResponseEntity<ApiDataResponse<?>> deleteWorkExperienceById(@PathVariable Long id) {
        Optional<WorkExperience> workExperiences = workExperienceService.findWorkExperienceById(id);

        logger.info("Delete work experience by id");

        if(workExperiences.isEmpty()) {
            logger.info("Work experience not found");

            return ResponseEntity.ok(
                    new ApiDataResponse<>(
                            false,
                            "Work experience not found",
                            workExperiences
                    )
            );
        }

        workExperienceService.deleteWorkExperienceById(id);

        logger.info("Delete work experience successfully");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Work experience deleted successfully",
                        workExperiences
                )
        );
    }
}
