package com.banque.misr.irrigationsystem.api;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banque.misr.irrigationsystem.model.Plot;
import com.banque.misr.irrigationsystem.model.PlotRequest;
import com.banque.misr.irrigationsystem.model.PlotsPage;
import com.banque.misr.irrigationsystem.service.PlotService;

@RestController
@RequestMapping("/api/v1")
public class PlotsApisController implements PlotsApis {
	
	private PlotService plotService;
	
	public PlotsApisController(PlotService plotService) {
		this.plotService = plotService;
	}

	@Override
	public ResponseEntity<PlotsPage> getPlots(@NotNull String authToken, @Valid Integer pageSize,
			@Valid Integer offSet, @Valid String sortBy, @Valid String orderBy, @Valid String name,
			@Valid String description, @Valid String status, @Valid String cropType) {
		return new ResponseEntity<>(plotService.listPlots(pageSize, offSet, sortBy, orderBy, name, description, status, cropType), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Plot> createPlot(@NotNull String authToken, @Valid PlotRequest createPlotRequest) {
		return new ResponseEntity<>(plotService.createPlot(createPlotRequest), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Plot> updatePlot(@NotNull Long id, @NotNull String authToken, @Valid PlotRequest updatePlotRequest) {
		return new ResponseEntity<>(plotService.updatePlot(id, updatePlotRequest), HttpStatus.OK);
	}

	@Override
	public ResponseEntity<Void> deletePlot(@NotNull Long id, @NotNull String authToken) {
		plotService.deletePlot(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
