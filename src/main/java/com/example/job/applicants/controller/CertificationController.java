// Defines the package where the CertificationController class is located
package com.example.job.applicants.controller;

// Import the classes, annotations, and other types needed to build the controller.
import com.example.job.applicants.model.Certification;
import com.example.job.applicants.request.CertificationRequest;
import com.example.job.applicants.request.CertificationUpdateRequest;
import com.example.job.applicants.service.CertificationService;
import com.example.job.applicants.response.ApiDataResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/")
@Tag(name = "Certificate Management", description = "Apis for managing all certificates")
public class CertificationController {

    //logging information
    private static final Logger logger = LoggerFactory.getLogger(CertificationController.class);

    //call the CertificationService and provide a reference variable to the CertificationService object
    private final CertificationService certificationService;

    //constructor injection: Inject the CertificationService into the CertificationController through the constructor
    public CertificationController(CertificationService certificationService) {
        this.certificationService = certificationService;
    }

    /**
     * @param certificationRequest details
     * @return AppApiResponse containing the certification if found
     */

    @PostMapping("/create-certification")
    @Operation(
            summary = "Create and save certification",
            description = "create certification"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Certification created successfully",
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

    public ResponseEntity<ApiDataResponse<?>> createCertification(CertificationRequest certificationRequest) {
        logger.info("Create certification request");

        Certification certification = certificationService.saveCertification(certificationRequest);

        logger.info("Certification created successfully");

                return ResponseEntity.ok(
                        new ApiDataResponse<>(
                                true,
                                "certification created successfully",
                                certification
                        )
               );
        }

    /**
     * @return AppApiResponse containing the find-all-certification if found
     */
    @GetMapping("/find-all-certifications")
    @Operation(
            summary = "find all certifications",
            description = "find certification"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Certification found successfully",
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

    public ResponseEntity<ApiDataResponse<?>> findAllCertification() {
        logger.info("find all certification request");

        List<Certification> certifications = certificationService.findAllCertifications();

        logger.info("Certifications found successfully");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "certifications found successfully",
                        certifications
                )
        );
    }

    /**
     * @return AppApiResponse containing the find-certification-by-id if found
     */

    @GetMapping("/find-certification-by-id/{id}")
    @Operation(
            summary = "find certificate by id",
            description = "find a certificate by its id"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Certification id found successfully",
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

    public ResponseEntity<ApiDataResponse<?>> findCertificationById(@PathVariable Long id){
        logger.info("find certificate by id");

        Optional<Certification> certifications = certificationService.findCertificationById(id);

        if(certifications.isEmpty()){
            logger.info("certification not found");

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiDataResponse<>(
                            false,
                            "certificate not found",
                            null
                            )
                    );
        }

        logger.info("Certificate successfully found");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "certificate found successfully",
                        certifications
                )
        );
    }

    /**
     * @return AppApiResponse containing the deleted certification if found
     */

    @DeleteMapping("/delete-certificate-by-id/{id}")
    @Operation(
            summary = "Delete certificate",
            description = "Delete certificate by id"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Certificate deleted successfully",
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

    public ResponseEntity<ApiDataResponse<?>> deleteCertificationById(@PathVariable Long id){
        Optional<Certification> certification = certificationService.findCertificationById(id);

        logger.info("Delete certificate by id");

        if(certification.isEmpty()){
            logger.info("certificate not found");

            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiDataResponse<>(
                            false,
                            "certificate not found",
                            null
                    )
            );
        }

        logger.info("Certificate successfully deleted");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "certificate deleted successfully",
                        certification
                )
        );
    }

    /**
     * @param certificationUpdateRequest details
     * @return AppApiResponse containing the updated applicants if found
     */
    @PutMapping("/update-certificates")
    @Operation(
            summary = "Update and save certificates",
            description = "Update certificates"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Certificates updated successfully",
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

    public ResponseEntity<ApiDataResponse<?>> updateCertificates(CertificationUpdateRequest certificationUpdateRequest){
        logger.info("Update certificate request");

        Certification certifications = certificationService.updateCertification(certificationUpdateRequest);

        logger.info("Certificate successfully updated");

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "certificate updated successfully",
                        certifications
                )
        );
    }
}

