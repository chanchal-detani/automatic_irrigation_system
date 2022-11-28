package com.banque.misr.irrigationsystem.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banque.misr.irrigationsystem.model.SensorsPage;
import com.banque.misr.irrigationsystem.service.SensorService;

@RestController
@RequestMapping("/api/v1")
public class SensorsApisController implements SensorsApis {
	
	private SensorService sensorService;
	
	public SensorsApisController(SensorService sensorService) {
		this.sensorService = sensorService;
	}

	@Override
	public ResponseEntity<SensorsPage> getSensors(@NotNull String authToken, @Valid Integer pageSize,
			@Valid Integer offSet, @Valid String sortBy, @Valid String orderBy, @Valid String name,
			@Valid String description, @Valid String status) {
		return new ResponseEntity<>(sensorService.listSensors(pageSize, offSet, sortBy, orderBy, name, description, status), HttpStatus.OK);
	}
}
