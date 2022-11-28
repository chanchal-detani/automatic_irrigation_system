package com.banque.misr.irrigationsystem.schedule;

import java.util.Date;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import com.banque.misr.irrigationsystem.entity.IrrigationTimingsEntity;
import com.banque.misr.irrigationsystem.entity.SensorEntity;
import com.banque.misr.irrigationsystem.enums.Status;
import com.banque.misr.irrigationsystem.repository.IrrigationTimingsRepository;

@Component
public class IrrigationExecutor {

	@Autowired
	private IrrigationTimingsRepository irrigationTimingsRepository;
	
	@Retryable(value = CompletionException.class, maxAttemptsExpression = "${maximum_irrigation_attempts}", backoff = @Backoff(delayExpression =  "${irrigation_attempts_backoff_timeout}"))
	public void executeScheduling(IrrigationTimingsEntity irrigationTimingsEntity) {
		long diffInMillies = Math.abs(irrigationTimingsEntity.getFrom().getTime() - new Date().getTime());
	    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
		Executors.newScheduledThreadPool(4).schedule(() -> performTask(irrigationTimingsEntity), diff, TimeUnit.DAYS);
	}

	private Object performTask(IrrigationTimingsEntity irrigationTimingsEntity) {
		SensorEntity sensor = irrigationTimingsEntity.getPlot().getSensor();
		// so based on the the sensor integration configuration, we can initiate the plot-irrigation process
		if(StringUtils.isNotBlank(sensor.getIntegrationConfig())) {
			// in the integration_config column, we can save how we can establish the communication to the sensor to initiate the process of irrigation
			CompletableFuture.supplyAsync(() -> {
				// actual implementation for contracting sensor
				return false;
			}).thenAccept(wasSuccessfull -> {
				if(Boolean.TRUE.equals(wasSuccessfull)) {
					irrigationTimingsEntity.setStatus(Status.IRRIGATED_SUCCESSFULLY);
					irrigationTimingsRepository.save(irrigationTimingsEntity);
				} else {
					throw new CompletionException("Attempt failed to irrigate plot, throwing exception for retrying purposes", new Throwable("Attempt failed to irrigate plot"));
				}
			});
		}
		return null;
	}
}
