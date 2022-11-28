package com.banque.misr.irrigationsystem.model.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;

import com.banque.misr.irrigationsystem.entity.SensorEntity;
import com.banque.misr.irrigationsystem.model.PageInfo;
import com.banque.misr.irrigationsystem.model.Sensor;
import com.banque.misr.irrigationsystem.model.SensorsPage;

public final class SensorMapper {

	private SensorMapper() {}
	
	private static List<Sensor> mapEntitiesIntoDTOs(List<SensorEntity> entities) {
        return entities.stream()
                .map(SensorMapper::mapEntityIntoDTO)
                .collect(Collectors.toList());
    }

    public static Sensor mapEntityIntoDTO(SensorEntity entity) {
        return Sensor.builder()
        		.active(entity.isActive())
        		.deleted(entity.isDeleted())
        		.status(entity.getStatus())
        		.id(entity.getId())
        		.name(entity.getName())
        		.description(entity.getDescription())
        		.createdOn(entity.getCreatedOn().toString())
        		.modifiedOn(entity.getModifiedOn().toString())
        		.build();
    }

    public static SensorsPage mapEntityPageIntoDTOPage(Page<SensorEntity> sensorsPage) {
        List<Sensor> sensors = mapEntitiesIntoDTOs(sensorsPage.getContent());
        return SensorsPage.builder()
        		.pageInfo(PageInfo.builder().pageSize(sensorsPage.getSize()).offset(sensorsPage.getNumber()).totalItems(sensorsPage.getTotalElements()).build())
        		.sensors(sensors)
        		.build();
    }
}
