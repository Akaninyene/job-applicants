package com.example.job.applicants.controller;

import com.example.job.applicants.model.Reference;
import com.example.job.applicants.model.SkillsQualities;
import com.example.job.applicants.request.SkillsQualitiesRequest;
import com.example.job.applicants.request.SkillsQualitiesUpdateRequest;
import com.example.job.applicants.service.SkillsQualitiesService;
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
@Tag(name = "Skills and Qualities management", description = "Apis for managing all Skills and Qualities")
public class SkillsQualitiesController {

    //logging information
    private static final Logger logger = LoggerFactory.getLogger(SkillsQualitiesController.class);

    //call the reference service
    private final SkillsQualitiesService skillsQualitiesService;

    //constructor injection
    public SkillsQualitiesController(SkillsQualitiesService skillsQualitiesService) {
        this.skillsQualitiesService = skillsQualitiesService;
    }

    /**
     * @param skillsQualitiesRequest details
     * @return AppApiResponse containing the skillsQualities if found
     */

    @PostMapping("/create-skillsQualities")
    @Operation(
            summary = "Create and save skillsQualities",
            description = "create skillsQualities"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "SkillsQualities created successfully",
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

    public ResponseEntity<ApiDataResponse<?>> createSkillsQualities(@RequestBody SkillsQualitiesRequest skillsQualitiesRequest) {
        logger.info("createSkillsQualities");

        SkillsQualities skillsQualities = skillsQualitiesService.saveSkillsQualities(skillsQualitiesRequest);

        logger.info("createSkillsQualities");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Skills Qualities created successfully",
                        skillsQualities
                )
        );
    }

    /**
     * @return AppApiResponse containing the find-all-skillsQualities if found
     */
    @GetMapping("/find-all-skillsQualities")
    @Operation(
            summary = "find all skillsQualities",
            description = "find skillsQualities"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "skillsQualities found successfully",
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

    public ResponseEntity<ApiDataResponse<?>> findAllSkillsQualities() {
        logger.info("find all SkillsQualities");

        List<SkillsQualities> skillsQualities = skillsQualitiesService.findAllSkillsQualities();

        logger.info("find all SkillsQualities");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Skills Qualities found successfully",
                        skillsQualities
                )
        );
    }

    /**
     * @return AppApiResponse containing the find-skillsQualities-by-id if found
     */

    @GetMapping("/find-skillsQualities-by-id/{id}")
    @Operation(
            summary = "find skillsQualities by id",
            description = "find a skillsQualities by its id"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "SkillsQualities id found successfully",
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

    public ResponseEntity<ApiDataResponse<?>> findSkillsQualitiesById(@PathVariable Long id) {
        logger.info("Find skills qualities by id");

        Optional<SkillsQualities> skillsQualities = skillsQualitiesService.findSkillsQualitiesById(id);

        if(skillsQualities.isEmpty()) {
            logger.info("SkillsQualities not found");

            return ResponseEntity.ok(
                    new ApiDataResponse<>(
                            false,
                            "SkillsQualities not found",
                            skillsQualities
                    )
            );
        }

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "SkillsQualities found successfully",
                        skillsQualities

                )
        );
    }

    /**
     * @param skillsQualitiesUpdateRequest details
     * @return AppApiResponse containing the updated skillsQualities if found
     */
    @PutMapping("/update-skillsQualities")
    @Operation(
            summary = "Update and save SkillsQualities",
            description = "Update SkillsQualities"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "SkillsQualities updated successfully",
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

    public ResponseEntity<ApiDataResponse<?>> updateSkillsQualities(@RequestBody SkillsQualitiesUpdateRequest skillsQualitiesUpdateRequest) {
        logger.info("Update SkillsQualities");

        SkillsQualities skillsQualities = skillsQualitiesService.updateSkillsQualities(skillsQualitiesUpdateRequest);

        logger.info("Update SkillsQualities successfully");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "SkillsQualities updated successfully",
                        skillsQualities
                )
        );
    }

    /**
     * @return AppApiResponse containing the deleted SkillsQualities if found
     */

    @DeleteMapping("/delete-skillsQualities-by-id/{id}")
    @Operation(
            summary = "Delete skillsQualities",
            description = "Delete skillsQualities by id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "SkillsQualities deleted successfully",
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

    public ResponseEntity<ApiDataResponse<?>> deleteSkillsQualitiesById(@PathVariable Long id) {
        Optional<SkillsQualities>  skillsQualities = skillsQualitiesService.findSkillsQualitiesById(id);

        logger.info("Delete skillsQualities by id");

        if(skillsQualities.isEmpty()) {
            logger.info("SkillsQualities not found");

            return ResponseEntity.ok(
                    new ApiDataResponse<>(
                            false,
                            "SkillsQualities not found",
                            skillsQualities
                    )
            );
        }

        skillsQualitiesService.deleteSkillsQualitiesById(id);

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "SkillsQualities deleted successfully",
                        skillsQualities
                )
        );
    }
}
