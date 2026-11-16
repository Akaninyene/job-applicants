package com.example.job.applicants.controller;

import com.example.job.applicants.model.Reference;
import com.example.job.applicants.request.ReferenceRequest;
import com.example.job.applicants.request.ReferenceUpdateRequest;
import com.example.job.applicants.service.ReferenceService;
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
@Tag(name = "Reference management", description = "Apis for managing all references")
public class ReferenceController {

    //logging information
    private static final Logger logger = LoggerFactory.getLogger(ReferenceController.class);

    //call the reference service
    private final ReferenceService referenceService;

    //constructor injection
    public ReferenceController(ReferenceService referenceService) {
        this.referenceService = referenceService;
    }

    /**
     * @param referenceRequest details
     * @return AppApiResponse containing the reference if found
     */

    @PostMapping("/create-reference")
    @Operation(
            summary = "Create and save reference",
            description = "create reference"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Reference created successfully",
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

    public ResponseEntity<ApiDataResponse<?>> createReference(@RequestBody ReferenceRequest referenceRequest) {
        logger.info("Create reference request");

        Reference references = referenceService.saveReference(referenceRequest);

        logger.info("Create reference successfully");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Reference created successfully",
                        references
                )
        );
    }

    /**
     * @return AppApiResponse containing the find-all-references if found
     */
    @GetMapping("/find-all-references")
    @Operation(
            summary = "find all references",
            description = "find references"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "References found successfully",
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

    public ResponseEntity<ApiDataResponse<?>> findAllReferences() {
        logger.info("Find all references");

        List<Reference> references = referenceService.findAllReferences();

        logger.info("Find all references successfully");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "References found successfully",
                        references
                )
        );
    }

    /**
     * @return AppApiResponse containing the find-reference-by-id if found
     */

    @GetMapping("/find-reference-by-id/{id}")
    @Operation(
            summary = "find reference by id",
            description = "find a reference by its id"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Reference id found successfully",
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

    public ResponseEntity<ApiDataResponse<?>> findReferenceById(@PathVariable Long id) {
        logger.info("Find reference by id");

        Optional<Reference> reference = referenceService.findReferenceById(id);

        if(reference.isEmpty()) {
            logger.info("Reference not found");

            return ResponseEntity.ok(
                    new ApiDataResponse<>(
                            false,
                            "Reference not found",
                            reference
                    )
            );
        }

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Reference found successfully",
                        reference
                )
        );
    }

    /**
     * @param referenceUpdateRequest details
     * @return AppApiResponse containing the updated reference if found
     */
    @PutMapping("/update-reference")
    @Operation(
            summary = "Update and save reference",
            description = "Update reference"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Reference updated successfully",
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

    public ResponseEntity<ApiDataResponse<?>> updateReference(@RequestBody ReferenceUpdateRequest referenceUpdateRequest) {
        logger.info("Update reference request");

        Reference references = referenceService.updateReference(referenceUpdateRequest);

        logger.info("Update reference successfully");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Reference updated successfully",
                        references
                )
        );
    }

    /**
     * @return AppApiResponse containing the deleted reference if found
     */

    @DeleteMapping("/delete-reference-by-id/{id}")
    @Operation(
            summary = "Delete reference",
            description = "Delete reference by id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Reference deleted successfully",
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

    public ResponseEntity<ApiDataResponse<?>> deleteReferenceById(@PathVariable Long id) {
        Optional<Reference> references = referenceService.findReferenceById(id);

        logger.info("Delete reference by id");

        if(references.isEmpty()) {
            logger.info("Reference not found");

            return ResponseEntity.ok(
                    new ApiDataResponse<>(
                            false,
                            "Reference not found",
                            references
                    )
            );
        }

        referenceService.deleteReferenceById(id);

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Reference deleted successfully",
                        references
                )
        );
    }

}
