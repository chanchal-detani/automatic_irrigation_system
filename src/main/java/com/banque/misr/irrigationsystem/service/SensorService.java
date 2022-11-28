package com.banque.misr.irrigationsystem.service;

import com.banque.misr.irrigationsystem.model.SensorsPage;

public interface SensorService {
	public SensorsPage listSensors(Integer pageSize, Integer offSet, String sortBy, String orderBy, String name, String description, String status);
}
