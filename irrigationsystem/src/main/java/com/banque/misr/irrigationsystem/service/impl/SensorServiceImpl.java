package com.banque.misr.irrigationsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banque.misr.irrigationsystem.entity.SensorEntity;
import com.banque.misr.irrigationsystem.model.SensorsPage;
import com.banque.misr.irrigationsystem.model.mappers.SensorMapper;
import com.banque.misr.irrigationsystem.model.specifications.SensorSpecifications;
import com.banque.misr.irrigationsystem.repository.SensorRepository;
import com.banque.misr.irrigationsystem.service.SensorService;

@Service
public class SensorServiceImpl implements SensorService {

	@Autowired
	private SensorRepository sensorRepository;
	
	@Transactional(readOnly = true)
	@Override
	public SensorsPage listSensors(Integer pageSize, Integer offSet, String sortBy, String orderBy, String name,
			String description, String status) {
		// defaulting some values
		PageRequest pageRequest = PageRequest.of(offSet, pageSize, Sort.by(Direction.fromString(orderBy), sortBy));

		Specification<SensorEntity> criterias = Specification.where(SensorSpecifications.hasName(name)).
			or(SensorSpecifications.hasDescription(description))
			.or(SensorSpecifications.hasStatus(status)).and(SensorSpecifications.isActive());
		
		Page<SensorEntity> plots = sensorRepository.findAll(criterias, pageRequest);
		
		return SensorMapper.mapEntityPageIntoDTOPage(plots);
	}

}
