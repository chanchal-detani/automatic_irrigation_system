package com.banque.misr.irrigationsystem.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.banque.misr.irrigationsystem.model.Error;
import com.banque.misr.irrigationsystem.model.SensorsPage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Validated
@Tag(name = "Sensors", description = "the sensors API")
public interface SensorsApis {

	/**
     * GET /sensors : Get All Sensors
     * Get all plots with filters
     *
     * @param authToken bearer token for security purpose (required)
     * @param pageSize  (optional, default to 1000)
     * @param offSet  (optional, default to 0)
     * @param sortBy  (optional, default to createdOn)
     * @param orderBy  (optional, default to asc)
     * @param name name (optional) (optional)
     * @param description description (optional) (optional)
     * @param status status (optional, default to ACTIVE) (optional, default to ACTIVE)
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Conflict (status code 409)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "getSensors",
        summary = "Get All Sensors",
        tags = { "Sensors" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = SensorsPage.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "409", description = "Conflict", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
            })
        }
    )
    @GetMapping(
        value = "/sensors",
        produces = { "application/json" }
    )
    public ResponseEntity<SensorsPage> getSensors(
            @NotNull @Parameter(name = "authToken", description = "bearer token for security purpose", required = true) @RequestHeader(value = "authToken", required = true) String authToken,
            @Parameter(name = "pageSize", description = "") @Valid @RequestParam(value = "pageSize", required = false, defaultValue = "1000") Integer pageSize,
            @Parameter(name = "offSet", description = "") @Valid @RequestParam(value = "offSet", required = false, defaultValue = "0") Integer offSet,
            @Parameter(name = "sortBy", description = "", schema = @io.swagger.v3.oas.annotations.media.Schema(allowableValues = {"createdOn", "modifiedOn"})) @Valid @RequestParam(value = "sortBy", required = false, defaultValue = "createdOn") String sortBy,
            @Parameter(name = "orderBy", description = "", schema = @io.swagger.v3.oas.annotations.media.Schema(allowableValues = {"asc", "desc"})) @Valid @RequestParam(value = "orderBy", required = false, defaultValue = "asc") String orderBy,
            @Parameter(name = "name", description = "name (optional)") @Valid @RequestParam(value = "name", required = false) String name,
            @Parameter(name = "description", description = "description (optional)") @Valid @RequestParam(value = "name", required = false) String description,
            @Parameter(name = "status", description = "status (optional)", schema = @io.swagger.v3.oas.annotations.media.Schema(allowableValues = {"ACTIVE", "INACTIVE", "UNDER_MAINTENANCE"})) @Valid @RequestParam(value = "status", required = false, defaultValue = "ACTIVE") String status
        );
}
