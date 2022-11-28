package com.banque.misr.irrigationsystem.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banque.misr.irrigationsystem.entity.IrrigationTimingsEntity;
import com.banque.misr.irrigationsystem.entity.PlotEntity;
import com.banque.misr.irrigationsystem.enums.Status;
import com.banque.misr.irrigationsystem.model.IrrigationTiming;
import com.banque.misr.irrigationsystem.model.TimingRequest;
import com.banque.misr.irrigationsystem.repository.IrrigationTimingsRepository;
import com.banque.misr.irrigationsystem.repository.PlotRepository;
import com.banque.misr.irrigationsystem.schedule.IrrigationExecutor;
import com.banque.misr.irrigationsystem.service.IrrigationTimingsService;

@Service
public class IrrigationTimingsServiceImpl implements IrrigationTimingsService{

	
	// Wed Oct 16 00:00:00 CEST 2013
	private final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
	
	@Autowired
	private IrrigationTimingsRepository irrigationTimingsRepository;
	
	@Autowired
	private PlotRepository plotRepository;
	
	@Autowired
	IrrigationExecutor irrigationExecutor;

	@Override
	public IrrigationTiming configureTimings(Long plotId, TimingRequest timingRequest) {
		
		
		// parsing give dates first
		Date startingAt = parseDate(timingRequest.getStartAt());
		Date endingAt = parseDate(timingRequest.getEndsAt());
		
		// fetching existing timings
		List<IrrigationTimingsEntity> existingTimingsByPlotId = irrigationTimingsRepository.findByPlotId(plotId);
		
		if(existingTimingsByPlotId != null &&  !existingTimingsByPlotId.isEmpty()) {
			
			// checking for conflict of timings
			for(IrrigationTimingsEntity irrigationTimingsEntity : existingTimingsByPlotId) {
				if(irrigationTimingsEntity.getFrom().compareTo(startingAt) * startingAt.compareTo(irrigationTimingsEntity.getTo()) >= 0 ||
						irrigationTimingsEntity.getFrom().compareTo(endingAt) * endingAt.compareTo(irrigationTimingsEntity.getTo()) >= 0) {
					throw new IllegalArgumentException("We found an existing timings conflicting with what you have entered, please try to refine or add new timings.");
				}
			}
		}
		IrrigationTimingsEntity irrigationTimingsEntity =  new IrrigationTimingsEntity();
		// finding plot by id
		Optional<PlotEntity> plot = plotRepository.findById(plotId);
		if(plot.isPresent()) {
			irrigationTimingsEntity.setPlot(plot.get());
		} else {
			throw new IllegalArgumentException("Plot with id '"+plotId+" doesn't exists");
		}
		
		irrigationTimingsEntity.setAmountOfWater(timingRequest.getAmountOfWater());
		irrigationTimingsEntity.setFrom(startingAt);
		irrigationTimingsEntity.setTo(endingAt);
		irrigationTimingsEntity.setStatus(Status.SCHEDULED);
		irrigationTimingsRepository.save(irrigationTimingsEntity);
		irrigationExecutor.executeScheduling(irrigationTimingsEntity);
		return IrrigationTiming.builder()
				.amountOfWater(timingRequest.getAmountOfWater())
				.startAt(timingRequest.getStartAt())
				.endsAt(timingRequest.getEndsAt())
				.build();
	}

	@Override
	public IrrigationTiming updateTimings(Long plotId, Long irrigationTimingsId, TimingRequest timingRequest) {
	
		// parsing give dates first
		Date startingAt = parseDate(timingRequest.getStartAt());
		Date endingAt = parseDate(timingRequest.getEndsAt());
		
		Optional<IrrigationTimingsEntity> existingIrrigationTimings = irrigationTimingsRepository.findById(irrigationTimingsId);
		
		if(existingIrrigationTimings.isPresent()) {

			// we won't allow to timings if the status of the timings is requested_for_irrigation
			if(StringUtils.equalsAnyIgnoreCase(existingIrrigationTimings.get().getStatus().getName(), Status.REQUESTED_FOR_IRRIGATION.getName())) {
				throw new IllegalArgumentException("Timings can't be updated since a request is already sent to sensor for irrigation");
			}
			
			
			List<IrrigationTimingsEntity> existingTimingsByPlotId = irrigationTimingsRepository.findByPlotId(plotId);
			
			if(existingTimingsByPlotId != null && !existingTimingsByPlotId.isEmpty()) {
				
				boolean isToIgnore = existingIrrigationTimings.get().getPlot().getId().longValue() == plotId.longValue();
				
				for(IrrigationTimingsEntity irrigationTimingsEntity : existingTimingsByPlotId) {
					// if plot id is same we have to ignore current irrigationTimingsId
					if(isToIgnore && irrigationTimingsEntity.getId().longValue() == irrigationTimingsId.longValue()) {
						continue;
					}
					
					if(irrigationTimingsEntity.getFrom().compareTo(startingAt) * startingAt.compareTo(irrigationTimingsEntity.getTo()) >= 0 ||
							irrigationTimingsEntity.getFrom().compareTo(endingAt) * endingAt.compareTo(irrigationTimingsEntity.getTo()) >= 0) {
						throw new IllegalArgumentException("We found an existing timing conflicting with what you have entered, please try to refine or add new timings.");
					}
				}
				IrrigationTimingsEntity irrigationTimingsEntity = existingIrrigationTimings.get();
				irrigationTimingsEntity.setAmountOfWater(timingRequest.getAmountOfWater());
				irrigationTimingsEntity.setFrom(startingAt);
				irrigationTimingsEntity.setTo(endingAt);
				PlotEntity plotEntity = new PlotEntity();
				plotEntity.setId(plotId);
				irrigationTimingsEntity.setPlot(plotEntity);
				irrigationTimingsRepository.save(irrigationTimingsEntity);
				irrigationExecutor.executeScheduling(irrigationTimingsEntity);
				return IrrigationTiming.builder()
						.amountOfWater(timingRequest.getAmountOfWater())
						.startAt(timingRequest.getStartAt())
						.endsAt(timingRequest.getEndsAt())
						.build();
			}
		} else {
			throw new IllegalArgumentException("Irrigation timings not found with id '"+irrigationTimingsId+"'");
		}
		return null;
	}

	private Date parseDate(@NotNull String date) {
		try {
			return DATEFORMAT.parse(date);
		} catch (ParseException e) {
			throw new IllegalArgumentException("date entered is not in valid format, it should be in 'EEE MMM d HH:mm:ss zzz yyyy' format");
		}
	}
}
