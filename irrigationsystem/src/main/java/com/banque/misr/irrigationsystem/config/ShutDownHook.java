package com.banque.misr.irrigationsystem.config;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.banque.misr.irrigationsystem.entity.IrrigationTimingsEntity;
import com.banque.misr.irrigationsystem.enums.Status;
import com.banque.misr.irrigationsystem.repository.IrrigationTimingsRepository;

@Configuration
public class ShutDownHook implements ServletContextListener {

	@Autowired
	IrrigationTimingsRepository irrigationTimingsRepository;
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// changing the statuses of all the timings from SCHEDULED to YET_TO_BE_SCHEDULED
		List<IrrigationTimingsEntity> scheduledIrrigations = irrigationTimingsRepository.findByStatus(Status.SCHEDULED);
		if(scheduledIrrigations != null && !scheduledIrrigations.isEmpty()) {
			scheduledIrrigations.forEach(scheduledIrrigation -> scheduledIrrigation.setStatus(Status.YET_TO_BE_SCHEDULED));
			irrigationTimingsRepository.saveAll(scheduledIrrigations);
		}
	}
}
