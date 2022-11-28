package com.banque.misr.irrigationsystem.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.banque.misr.irrigationsystem.entity.PlotEntity;

@Repository
public interface PlotRepository extends PagingAndSortingRepository<PlotEntity, Long>, JpaSpecificationExecutor<PlotEntity> {
	
	PlotEntity findByName(String plotName);
	PlotEntity findByNameAndIdNot(String plotName, Long id);
}
