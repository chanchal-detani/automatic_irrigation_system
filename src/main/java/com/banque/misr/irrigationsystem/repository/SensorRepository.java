package com.banque.misr.irrigationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.banque.misr.irrigationsystem.entity.SensorEntity;

@Repository
public interface SensorRepository extends JpaRepository<SensorEntity, Long>, JpaSpecificationExecutor<SensorEntity> {
}
