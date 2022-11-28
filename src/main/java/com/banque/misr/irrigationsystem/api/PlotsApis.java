package com.banque.misr.irrigationsystem.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.banque.misr.irrigationsystem.model.Error;
import com.banque.misr.irrigationsystem.model.Plot;
import com.banque.misr.irrigationsystem.model.PlotRequest;
import com.banque.misr.irrigationsystem.model.PlotsPage;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Validated
@Tag(name = "Plots", description = "the plots API")
public interface PlotsApis {

	/**
     * GET /plots : Get All Plots
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
     * @param cropType cropType (optional, default to FOOD) (optional, default to FOOD)
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Conflict (status code 409)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "getPlots",
        summary = "Get All Plots",
        tags = { "Plots" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = PlotsPage.class))
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
        value = "/plots",
        produces = { "application/json" }
    )
    public ResponseEntity<PlotsPage> getPlots(
            @NotNull @Parameter(name = "authToken", description = "bearer token for security purpose", required = true) @RequestHeader(value = "authToken", required = true) String authToken,
            @Parameter(name = "pageSize", description = "") @Valid @RequestParam(value = "pageSize", required = false, defaultValue = "1000") Integer pageSize,
            @Parameter(name = "offSet", description = "") @Valid @RequestParam(value = "offSet", required = false, defaultValue = "0") Integer offSet,
            @Parameter(name = "sortBy", description = "", schema = @io.swagger.v3.oas.annotations.media.Schema(allowableValues = {"createdOn", "modifiedOn"})) @Valid @RequestParam(value = "sortBy", required = false, defaultValue = "createdOn") String sortBy,
            @Parameter(name = "orderBy", description = "", schema = @io.swagger.v3.oas.annotations.media.Schema(allowableValues = {"asc", "desc"})) @Valid @RequestParam(value = "orderBy", required = false, defaultValue = "asc") String orderBy,
            @Parameter(name = "name", description = "name (optional)") @Valid @RequestParam(value = "name", required = false) String name,
            @Parameter(name = "description", description = "description (optional)") @Valid @RequestParam(value = "name", required = false) String description,
            @Parameter(name = "status", description = "status (optional)", schema = @io.swagger.v3.oas.annotations.media.Schema(allowableValues = {"ACTIVE", "INACTIVE", "ELIGIBLE_FOR_IRRIGATION", "UNDER_MAINTENANCE"})) @Valid @RequestParam(value = "status", required = false, defaultValue = "ACTIVE") String status,
            @Parameter(name = "cropType", description = "cropType (optional)", schema = @io.swagger.v3.oas.annotations.media.Schema(allowableValues = {"FOOD", "FEED", "FIBER", "OIL", "ORNAMENTAL", "INDUSTRIAL"})) @Valid @RequestParam(value = "cropType", required = false, defaultValue = "FOOD") String cropType
        );
    
    
    /**
     * POST /plots : Creates a new plot
     * Creates a new plot
     *
     * @param authToken auto token for securing purposes (required)
     * @param plotRequest  (required)
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Conflict (status code 409)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "createPlot",
        summary = "Creates a new plot",
        tags = { "Plots" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Plot.class))
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
    @PostMapping(
        value = "/plots",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    public ResponseEntity<Plot> createPlot(
            @NotNull @Parameter(name = "authToken", description = "auto token for securing purposes", required = true) @RequestHeader(value = "authToken", required = true) String authToken,
            @Parameter(name = "PlotRequest", description = "details to be saved", required = true) @Valid @RequestBody PlotRequest plotRequest
        );
    
    
    /**
     * PATCH /plots/{id} : Updates the specified plot
     * Updates the specified plot
     *
     * @param id  (required)
     * @param authToken for securing api (required)
     * @param plotRequest  (required)
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Conflict (status code 409)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "updatePlot",
        summary = "Updates the specified plot",
        tags = { "Plots" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Job.class))
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
    @PutMapping(
        value = "/plots/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    public ResponseEntity<Plot> updatePlot(
    		@NotNull @Parameter(name = "id", description = "", required = true) @PathVariable("id") Long id,
        @NotNull @Parameter(name = "authToken", description = "for securing api", required = true) @RequestHeader(value = "authToken", required = true) String authToken,
        @Parameter(name = "body", description = "details to be updated", required = true) @Valid @RequestBody PlotRequest plotRequest
    );
    
    /**
     * DELETE /plots/{id} : Delete the specified plot information
     * Delete the specified plot
     *
     * @param id  (required)
     * @param authToken for securing api (required)
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Conflict (status code 409)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "deletePlot",
        summary = "Delete the specified plot information",
        tags = { "Plots" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK"),
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
    @DeleteMapping(
        value = "/plots/{id}",
        produces = { "application/json" }
    )
    public ResponseEntity<Void> deletePlot(
    		@NotNull @Parameter(name = "id", description = "", required = true) @PathVariable("id") Long id,
        @NotNull @Parameter(name = "authToken", description = "for securing api", required = true) @RequestHeader(value = "authToken", required = true) String authToken
    );
}
