package com.example.job.applicants.controller;

import com.example.job.applicants.model.EducationQualifications;
import com.example.job.applicants.request.EducationQualificationsRequest;
import com.example.job.applicants.request.EducationQualificationsUpdateRequest;
import com.example.job.applicants.service.EducationQualificationsService;
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
@Tag(name = "Education Qualifications management", description = "Apis for managing all education qualifications")
public class EducationQualificationsController {

    //logging information
    private static final Logger logger = LoggerFactory.getLogger(EducationQualificationsController.class);

    //call the education qualifications service
    private final EducationQualificationsService educationQualificationsService;

    //constructor injection
    public EducationQualificationsController(EducationQualificationsService eduQualificationsService) {
        this.educationQualificationsService = eduQualificationsService;
    }

    /**
     * @param educationQualificationsRequest details
     * @return AppApiResponse containing the educationQualifications if found
     */

    @PostMapping("/create-educationQualifications")
    @Operation(
            summary = "Create and save education qualifications",
            description = "create education qualifications"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Education qualifications created successfully",
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

    public ResponseEntity<ApiDataResponse<?>> createEducationQualifications(@RequestBody EducationQualificationsRequest educationQualificationsRequest) {
        logger.info("Create education qualifications request");

        EducationQualifications educationQualifications = educationQualificationsService.saveEducationQualifications(educationQualificationsRequest);

        logger.info("Create education qualifications successfully");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Education Qualifications successfully created",
                        educationQualifications
                )
        );
    }

    /**
     * @return AppApiResponse containing the find-all-educationQualifications if found
     */
    @GetMapping("/find-all-educationQualifications")
    @Operation(
            summary = "find all educationQualifications",
            description = "find educationQualifications"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Education Qualification found successfully",
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

    public ResponseEntity<ApiDataResponse<?>> findAllEducationQualifications() {
        logger.info("find all educationQualifications");

        List<EducationQualifications> educationQualifications = educationQualificationsService.findAllEducationQualifications();

        logger.info("find all educationQualifications successfully");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Education Qualifications found successfully",
                        educationQualifications
                )
        );
    }

    /**
     * @return AppApiResponse containing the find-educationQualifications-by-id if found
     */

    @GetMapping("/find-educationQualifications-by-id/{id}")
    @Operation(
            summary = "find education qualification by id",
            description = "find education qualifications by its id"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Education qualifications id found successfully",
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

    public ResponseEntity<ApiDataResponse<?>> findEducationQualificationsById(@PathVariable Long id){
        logger.info("find education qualifications by id successfully");

        Optional<EducationQualifications> educationQualifications = educationQualificationsService.findEducationQualificationsById(id);

        if(educationQualifications.isEmpty()){
            logger.info("Education qualifications not found");

            return ResponseEntity.ok(
                    new ApiDataResponse<>(
                            false,
                            "Education qualifications not found",
                            null
                    )
            );
        }

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Education qualifications found successfully",
                        educationQualifications
                )
        );
    }

    /**
     * @param educationQualificationsUpdateRequest details
     * @return AppApiResponse containing the updated educationQualifications if found
     */
    @PutMapping("/update-educationQualifications")
    @Operation(
            summary = "Update and save education qualifications",
            description = "Update education qualifications"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Education Qualifications updated successfully",
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

    public ResponseEntity<ApiDataResponse<?>> updateEducationQualifications(@RequestBody EducationQualificationsUpdateRequest educationQualificationsUpdateRequest){
        logger.info("Update education qualifications");

        EducationQualifications educationQualifications = educationQualificationsService.updateEducationQualifications(educationQualificationsUpdateRequest);

        logger.info("Update education qualifications successfully");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Education qualifications updated successfully",
                        educationQualifications
                )
        );
    }

    /**
     * @return AppApiResponse containing the deleted educationQualifications if found
     */

    @DeleteMapping("/delete-educationQualifications-by-id/{id}")
    @Operation(
            summary = "Delete educationQualifications",
            description = "Delete educationQualifications by id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "educationQualifications deleted successfully",
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

    public ResponseEntity<ApiDataResponse<?>> deleteEducationQualificationsById(@PathVariable Long id){
        Optional<EducationQualifications> educationQualifications = educationQualificationsService.findEducationQualificationsById(id);

        logger.info("Delete educationQualifications by id successfully");

        if (educationQualifications.isEmpty()){
            logger.info("Education qualifications not found");
            return ResponseEntity.ok(
                    new ApiDataResponse<>(
                            false,
                            "Education qualifications not found",
                            educationQualifications
                    )
            );
        }

        educationQualificationsService.deleteEducationQualificationsById(id);
        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Education qualifications deleted successfully",
                        educationQualifications
                )
        );
    }
}
