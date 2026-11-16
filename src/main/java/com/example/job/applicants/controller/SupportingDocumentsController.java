package com.example.job.applicants.controller;

import com.example.job.applicants.model.SupportingDocuments;
import com.example.job.applicants.request.SupportingDocumentsRequest;
import com.example.job.applicants.request.SupportingDocumentsUpdateRequest;
import com.example.job.applicants.service.SupportingDocumentsService;
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
@Tag(name = "SupportingDocuments management", description = "Apis for managing all supportingDocuments")
public class SupportingDocumentsController {

//logging information
    private static final Logger logger = LoggerFactory.getLogger(SupportingDocumentsController.class);

    //call the reference service
    private final SupportingDocumentsService supportingDocumentsService;

    //constructor injection
    public SupportingDocumentsController(SupportingDocumentsService supportingDocumentsService) {
        this.supportingDocumentsService = supportingDocumentsService;
    }

    /**
     * @param supportingDocumentsRequest details
     * @return AppApiResponse containing the supportingDocuments if found
     */

    @PostMapping("/create-supportingDocuments")
    @Operation(
            summary = "Create and save supportingDocuments",
            description = "create supportingDocuments"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "SupportingDocuments created successfully",
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

    public ResponseEntity<ApiDataResponse<?>> createSupportingDocuments(@RequestBody SupportingDocumentsRequest supportingDocumentsRequest) {
       logger.info("Create supportingDocuments request");

       SupportingDocuments supportingDocument = supportingDocumentsService.saveSupportingDocuments(supportingDocumentsRequest);

       logger.info("Create supportingDocuments successfully");

       return ResponseEntity.ok(
               new ApiDataResponse<>(
                       true,
                       "Supporting Documents created successfully",
                       supportingDocument
               )
       );
    }

    /**
     * @return AppApiResponse containing the find-all-SupportingDocuments if found
     */
    @GetMapping("/find-all-supportingDocuments")
    @Operation(
            summary = "find all supportingDocuments",
            description = "find supportingDocuments"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Supporting Documents found successfully",
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

    public ResponseEntity<ApiDataResponse<?>> findAllSupportingDocuments() {
        logger.info("Find all supportingDocuments request");

        List<SupportingDocuments> supportingDocument = supportingDocumentsService.findAllSupportingDocuments();

        logger.info("Find all supportingDocuments successfully");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Supporting documents foumd successfully",
                        supportingDocument
                )
        );
    }

    /**
     * @return AppApiResponse containing the find-SupportingDocuments-by-id if found
     */

    @GetMapping("/find-supportingDocuments-by-id/{id}")
    @Operation(
            summary = "find supportingDocuments by id",
            description = "find a supportingDocuments by its id"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Supporting Documents id found successfully",
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

    public ResponseEntity<ApiDataResponse<?>> findSupportingDocumentsById(@PathVariable Long id) {
        logger.info("Find supportingDocuments by id");

        Optional<SupportingDocuments> supportingDocument = supportingDocumentsService.findSupportingDocumentById(id);

        if (supportingDocument.isEmpty()) {

            logger.info("Find supportingDocuments by id not found");

            return ResponseEntity.ok(
                    new ApiDataResponse<>(
                            false,
                            "Supporting documents not found",
                            supportingDocument
                    )
            );
        }

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Supporting documents found successfully",
                        supportingDocument
                )
        );
    }

    /**
     * @param supportingDocumentsUpdateRequest details
     * @return AppApiResponse containing the updated supportingDocuments if found
     */
    @PutMapping("/update-supportingDocuments")
    @Operation(
            summary = "Update and save supportingDocuments",
            description = "Update supportingDocuments"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "supportingDocuments updated successfully",
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

    public ResponseEntity<ApiDataResponse<?>> updateSupportingDocuments(@RequestBody SupportingDocumentsUpdateRequest supportingDocumentsUpdateRequest) {
        logger.info("Update supportingDocuments request");

        SupportingDocuments supportingDocument = supportingDocumentsService.updateSupportingDocuments(supportingDocumentsUpdateRequest);

        logger.info("Update supportingDocuments successfully");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Supporting documents updated successfully",
                        supportingDocument
                )
        );
    }

    /**
     * @return AppApiResponse containing the deleted supporting documents if found
     */

    @DeleteMapping("/delete-supportingDocuments-by-id/{id}")
    @Operation(
            summary = "Delete supporting documents",
            description = "Delete supporting documents by id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "supporting documents deleted successfully",
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

    public ResponseEntity<ApiDataResponse<?>> deleteSupportingDocumentsById(@PathVariable Long id) {
        Optional<SupportingDocuments> supportingDocument = supportingDocumentsService.findSupportingDocumentById(id);

        logger.info("Delete supporting documents by id");

        if(supportingDocument.isEmpty()) {
            logger.info("Supporting documents by id not found");

            return ResponseEntity.ok(
                    new ApiDataResponse<>(
                            false,
                            "Supporting documents not found",
                            supportingDocument
                    )
            );
        }

        supportingDocumentsService.deleteSupportingDocumentById(id);
        logger.info("Delete supporting documents successfully");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "Supporting documents deleted successfully",
                        supportingDocument
                )
        );
    }

}
