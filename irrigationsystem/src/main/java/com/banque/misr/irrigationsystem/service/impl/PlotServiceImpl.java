package com.banque.misr.irrigationsystem.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banque.misr.irrigationsystem.entity.PlotEntity;
import com.banque.misr.irrigationsystem.entity.SensorEntity;
import com.banque.misr.irrigationsystem.model.Plot;
import com.banque.misr.irrigationsystem.model.PlotRequest;
import com.banque.misr.irrigationsystem.model.PlotsPage;
import com.banque.misr.irrigationsystem.model.mappers.PlotMapper;
import com.banque.misr.irrigationsystem.model.specifications.PlotSpecifications;
import com.banque.misr.irrigationsystem.repository.PlotRepository;
import com.banque.misr.irrigationsystem.repository.SensorRepository;
import com.banque.misr.irrigationsystem.service.PlotService;

@Service
public class PlotServiceImpl implements PlotService {

	private static final String DOESN_T_EXISTS = "' doesn't exists";

	private static final String PLOT_WITH_ID = "Plot with id '";
	
	@Autowired
	private PlotRepository plotRepository;
	
	@Autowired
	private SensorRepository sensorRepository;
	
	@Transactional
	@Override
	public Plot createPlot(PlotRequest createPlotRequest) {
		// checking for any duplicate plot
		PlotEntity existingPlot = plotRepository.findByName(createPlotRequest.getName());
		if(existingPlot != null) {
			throw new IllegalArgumentException("Plot with name '"+createPlotRequest.getName()+"' already exists with status '"+existingPlot.getStatus().getName()+"' and is marked as active='"+existingPlot.isActive()+"'");
		}
		PlotEntity plotEntity = PlotMapper.mapDTOIntoEntity(createPlotRequest, new PlotEntity());
		// finding sensor by id
		Optional<SensorEntity> sensor = sensorRepository.findById(createPlotRequest.getSensor().getId());
		if(sensor.isPresent()) {
			plotEntity.setSensor(sensor.get());
		} else {
			throw new IllegalArgumentException("Sensor with id '"+createPlotRequest.getSensor().getId()+DOESN_T_EXISTS);
		}
		PlotEntity savedEntity = plotRepository.save(plotEntity);
		return PlotMapper.mapEntityIntoDTO(savedEntity);
	}

	@Transactional
	@Override
	public Plot updatePlot(long id, PlotRequest updatePlotRequest) {
		
		// checking for existence
		Optional<PlotEntity> currentEntityOptional = plotRepository.findById(id);
		if(!currentEntityOptional.isPresent()) {
			throw new IllegalArgumentException(PLOT_WITH_ID+id+DOESN_T_EXISTS);
		}
		
		if(!currentEntityOptional.get().isActive()) {
			throw new IllegalArgumentException(PLOT_WITH_ID+id+"' already exists but is in inactive state. Please delete and try adding it again");
		}
		
		// check for the same plot name
		PlotEntity existingPlot = plotRepository.findByNameAndIdNot(updatePlotRequest.getName(),id);
		if(existingPlot != null) {
			throw new IllegalArgumentException("Plot with name '"+updatePlotRequest.getName()+"' already exists with status '"+existingPlot.getStatus().getName()+"' and is marked as active='"+existingPlot.isActive()+"'");
		}
		
		PlotEntity plotEntity = PlotMapper.mapDTOIntoEntity(updatePlotRequest, currentEntityOptional.get());
		// finding sensor by id
		Optional<SensorEntity> sensor = sensorRepository.findById(updatePlotRequest.getSensor().getId());
		if(sensor.isPresent()) {
			plotEntity.setSensor(sensor.get());
		} else {
			throw new IllegalArgumentException("Sensor with id '"+updatePlotRequest.getSensor().getId()+DOESN_T_EXISTS);
		}
		PlotEntity savedEntity = plotRepository.save(plotEntity);
		return PlotMapper.mapEntityIntoDTO(savedEntity);
	}

	@Transactional
	@Override
	public void deletePlot(long id) {
		// checking for existence
		Optional<PlotEntity> currentEntityOptional = plotRepository.findById(id);
		if(!currentEntityOptional.isPresent()) {
			throw new IllegalArgumentException(PLOT_WITH_ID+id+DOESN_T_EXISTS);
		}
		plotRepository.delete(currentEntityOptional.get());
	}

	@Transactional(readOnly = true)
	@Override
	public PlotsPage listPlots(Integer pageSize, Integer offSet, String sortBy, String orderBy, String name,
			String description, String status, String cropType) {
		// defaulting some values
		PageRequest pageRequest = PageRequest.of(offSet, pageSize, Sort.by(Direction.fromString(orderBy), sortBy));

		Specification<PlotEntity> criterias = Specification.where(PlotSpecifications.hasName(name)).
			or(PlotSpecifications.hasDescription(description)).
			or(PlotSpecifications.hasCropType(cropType))
			.or(PlotSpecifications.hasStatus(status)).and(PlotSpecifications.isActive());
		
		Page<PlotEntity> plots = plotRepository.findAll(criterias, pageRequest);
		
		return PlotMapper.mapEntityPageIntoDTOPage(plots);
	}

}
