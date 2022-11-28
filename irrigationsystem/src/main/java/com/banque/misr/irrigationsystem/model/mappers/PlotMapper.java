package com.banque.misr.irrigationsystem.model.mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.banque.misr.irrigationsystem.entity.IrrigationTimingsEntity;
import com.banque.misr.irrigationsystem.entity.PlotEntity;
import com.banque.misr.irrigationsystem.model.IrrigationTiming;
import com.banque.misr.irrigationsystem.model.PageInfo;
import com.banque.misr.irrigationsystem.model.Plot;
import com.banque.misr.irrigationsystem.model.PlotRequest;
import com.banque.misr.irrigationsystem.model.PlotsPage;
import com.banque.misr.irrigationsystem.model.Sensor;

public final class PlotMapper {

	private PlotMapper() {}
	
	private static List<Plot> mapEntitiesIntoDTOs(List<PlotEntity> entities) {
        return entities.stream()
                .map(PlotMapper::mapEntityIntoDTO)
                .collect(Collectors.toList());
    }

    public static Plot mapEntityIntoDTO(PlotEntity entity) {
    	List<IrrigationTiming> timings = new ArrayList<>();
    	if(entity.getSlots() != null && !entity.getSlots().isEmpty()) {
    		for(IrrigationTimingsEntity irrigationTimingsEntity : entity.getSlots()) {
    			timings.add(IrrigationTiming.builder()
    			.amountOfWater(irrigationTimingsEntity.getAmountOfWater())
    			.startAt(irrigationTimingsEntity.getFrom().toString())
    			.endsAt(irrigationTimingsEntity.getTo().toString())
    			.build());
    		}
    	}
        return Plot.builder()
        		.active(entity.isActive())
        		.deleted(entity.isDeleted())
        		.cropType(entity.getCropType())
        		.status(entity.getStatus())
        		.id(entity.getId())
        		.name(entity.getName())
        		.description(entity.getDescription())
        		.measuringUnit(entity.getMeasuringUnit())
        		.plotArea(entity.getArea())
        		.createdOn(entity.getCreatedOn().toString())
        		.modifiedOn(entity.getModifiedOn().toString())
        		.irrigationTimings(timings)
        		.sensor(Sensor.builder()
        				.active(entity.getSensor().isActive())
        				.deleted(entity.getSensor().isDeleted())
        				.name(entity.getSensor().getName())
        				.description(entity.getSensor().getDescription())
        				.status(entity.getSensor().getStatus())
        				.createdOn(entity.getSensor().getCreatedOn().toString())
        				.modifiedOn(entity.getSensor().getModifiedOn().toString())
        				.build())
        		.build();
    }

    public static PlotsPage mapEntityPageIntoDTOPage(Page<PlotEntity> plotsPage) {
        List<Plot> plots = mapEntitiesIntoDTOs(plotsPage.getContent());
        return PlotsPage.builder()
        		.pageInfo(PageInfo.builder().pageSize(plotsPage.getSize()).offset(plotsPage.getNumber()).totalItems(plotsPage.getTotalElements()).build())
        		.plots(plots)
        		.build();
    }
    
    public static PlotEntity mapDTOIntoEntity(PlotRequest source, PlotEntity target) {
		target.setActive(true);
		target.setDeleted(false);
		target.setName(source.getName());
		target.setDescription(source.getDescription());
		target.setArea(source.getPlotArea());
		target.setMeasuringUnit(source.getMeasuringUnit());
		target.setStatus(source.getStatus());
		target.setCropType(source.getCropType());
    	return target;
    }
}
