package com.banque.misr.irrigationsystem.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banque.misr.irrigationsystem.model.IrrigationTiming;
import com.banque.misr.irrigationsystem.model.TimingRequest;
import com.banque.misr.irrigationsystem.service.IrrigationTimingsService;

@RestController
@RequestMapping("/api/v1")
public class IrrigationTimingsApiController implements IrrigationTimingsApis {

	private IrrigationTimingsService irrigationTimingsService;
	
	public IrrigationTimingsApiController(IrrigationTimingsService irrigationTimingsService) {
		this.irrigationTimingsService = irrigationTimingsService;
	}
	
	@Override
	public ResponseEntity<IrrigationTiming> addIrrigationTimings(@NotNull Long plotId, @NotNull String authToken,
			@Valid TimingRequest timingRequest) {
		return new ResponseEntity<>(irrigationTimingsService.configureTimings(plotId, timingRequest), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<IrrigationTiming> updateIrrigationTimings(@NotNull Long plotId, @NotNull Long timingsId, @NotNull String authToken,
			@Valid TimingRequest timingRequest) {
		return new ResponseEntity<>(irrigationTimingsService.updateTimings(plotId, timingsId, timingRequest), HttpStatus.OK);
	}

}
