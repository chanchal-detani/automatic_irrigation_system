package com.banque.misr.irrigationsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.banque.misr.irrigationsystem.entity.IrrigationTimingsEntity;
import com.banque.misr.irrigationsystem.enums.Status;

@Repository
public interface IrrigationTimingsRepository extends PagingAndSortingRepository<IrrigationTimingsEntity, Long>, JpaSpecificationExecutor<IrrigationTimingsEntity> {
	List<IrrigationTimingsEntity> findByPlotId(Long plotId);
	List<IrrigationTimingsEntity> findByStatus(Status status);
}
