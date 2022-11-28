package com.banque.misr.irrigationsystem.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.banque.misr.irrigationsystem.model.Error;
import com.banque.misr.irrigationsystem.model.IrrigationTiming;
import com.banque.misr.irrigationsystem.model.TimingRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Validated
@Tag(name = "Timings", description = "the irrigation timings API")
public interface IrrigationTimingsApis {

	/**
     * POST /plots/{id}/timings : Configures irrigation timings for given plot id
     * Creates a new plot irrigation timings
     *
     * @param id  (required)
     * @param authToken for securing api (required)
     * @param timingRequest  (required)
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Conflict (status code 409)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "addIrrigationTimings",
        summary = "Configures irrigation timings for given plot id",
        tags = { "Timings" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = IrrigationTiming.class))
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
        value = "/plots/{id}/timings",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    public ResponseEntity<IrrigationTiming> addIrrigationTimings(
    		@NotNull @Parameter(name = "id", description = "", required = true) @PathVariable("id") Long id,
        @NotNull @Parameter(name = "authToken", description = "for securing api", required = true) @RequestHeader(value = "authToken", required = true) String authToken,
        @Parameter(name = "TimingRequest", description = "", required = true) @Valid @RequestBody TimingRequest timingRequest
    );
    
    /**
     * PATCH /plots/{id}/timings/{timingsId} : Updates irrigation timings Configures for given plot id
     * Update irrigation timings for given plot id
     *
     * @param id  (required)
     * @param authToken for securing api (required)
     * @param timingRequest  (required)
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Unauthorized (status code 401)
     *         or Forbidden (status code 403)
     *         or Conflict (status code 409)
     *         or Internal Server Error (status code 500)
     */
    @Operation(
        operationId = "updateIrrigationTimings",
        summary = "Updates irrigation timings Configures for given plot id and timings id",
        tags = { "Timings" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = IrrigationTiming.class))
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
    @PatchMapping(
        value = "/plots/{id}/timings/{timingsId}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    public ResponseEntity<IrrigationTiming> updateIrrigationTimings(
    		@NotNull @Parameter(name = "id", description = "", required = true) @PathVariable("id") Long id,
    		@NotNull @Parameter(name = "timingsId", description = "", required = true) @PathVariable("timingsId") Long timingsId,
        @NotNull @Parameter(name = "authToken", description = "for securing api", required = true) @RequestHeader(value = "authToken", required = true) String authToken,
        @Parameter(name = "TimingRequest", description = "", required = true) @Valid @RequestBody TimingRequest timingRequest
    );
}
