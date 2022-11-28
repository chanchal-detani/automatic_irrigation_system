package com.banque.misr.irrigationsystem;

import java.util.List;

import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.banque.misr.irrigationsystem.config.ShutDownHook;
import com.banque.misr.irrigationsystem.entity.IrrigationTimingsEntity;
import com.banque.misr.irrigationsystem.enums.Status;
import com.banque.misr.irrigationsystem.repository.IrrigationTimingsRepository;
import com.banque.misr.irrigationsystem.schedule.IrrigationExecutor;

@SpringBootApplication
@EnableScheduling
public class IrrigationsystemApplication {
	
	@Autowired
	private ShutDownHook shutDownHook;
	
	@Autowired
	private IrrigationTimingsRepository irrigationTimingsRepository;
	
	@Autowired
	private IrrigationExecutor irrigationExecutor;
	
	@Bean
	public ServletListenerRegistrationBean<ServletContextListener> registerShutdownEvent() {
		ServletListenerRegistrationBean<ServletContextListener> srb
	      = new ServletListenerRegistrationBean<>();
	    srb.setListener(shutDownHook);
	    return srb;
	}
	
	@Scheduled(cron = "0 0 0/6 * * *")
	public void scheduleIrrigations() {
		List<IrrigationTimingsEntity> yetToBeScheduledTimings = irrigationTimingsRepository.findByStatus(Status.YET_TO_BE_SCHEDULED);
		if(yetToBeScheduledTimings != null && !yetToBeScheduledTimings.isEmpty()) {
			yetToBeScheduledTimings.forEach(timing -> {
				irrigationExecutor.executeScheduling(timing);
				timing.setStatus(Status.SCHEDULED);
			});
			irrigationTimingsRepository.saveAll(yetToBeScheduledTimings);
		}
	}
	
	public static void main(String[] args) {
		SpringApplication.run(IrrigationsystemApplication.class, args);
	}
}
