package com.example.job.applicants.controller;

import com.example.job.applicants.model.Users;
import com.example.job.applicants.request.UserUpdateRequest;
import com.example.job.applicants.service.UserService;
import com.example.job.applicants.response.ApiDataResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "User Management", description = "Apis for managing system users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
    this.userService = userService;
    }

    @GetMapping("/get-all-users")
    @Operation(
            summary = "Get users",
            description = "Get all system users"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Users fetched successfully",
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

    public ResponseEntity<ApiDataResponse<?>> findAllUsers() {

        List<Users> users = userService.findAllUsers();

        if (users.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiDataResponse<>(
                            false,
                            "Users not found",
                            null
                    )
            );
        }

       return ResponseEntity.ok(
               new ApiDataResponse<>(
                       true,
                       "Users fetched successfully",
                       users
               )
       );
    }

    @PostMapping("/update-user-password")
    @Operation(
            summary = "Update password",
            description = "Update user password"
    )

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Password updated successfully",
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

    public ResponseEntity<ApiDataResponse<?>> updatePassword(@RequestBody UserUpdateRequest userUpdateRequest) {

        userService.updateUserPassword(userUpdateRequest);

        return ResponseEntity.ok(
                new ApiDataResponse<>(
                        true,
                        "User password updated successfully",
                        userUpdateRequest
                )
        );

    }
}
