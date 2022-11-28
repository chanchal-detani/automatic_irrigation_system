package com.banque.misr.irrigationsystem.service;

import com.banque.misr.irrigationsystem.model.IrrigationTiming;
import com.banque.misr.irrigationsystem.model.TimingRequest;

public interface IrrigationTimingsService {

	public IrrigationTiming configureTimings(Long plotId, TimingRequest timingRequest);
	public IrrigationTiming updateTimings(Long plotId, Long irrigationTimingsId, TimingRequest timingRequest);
}
