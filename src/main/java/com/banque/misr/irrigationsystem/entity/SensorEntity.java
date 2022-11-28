package com.banque.misr.irrigationsystem.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.banque.misr.irrigationsystem.enums.Status;

import lombok.Data;

@Entity
@Table(name = SensorEntity.TABLE_NAME)
@Data
public class SensorEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "sensor";
	private static final String SENSOR_NAME = "sensorName";
	private static final String SENSOR_DESCRIPTION = "sensorDescription";
	private static final String CREATED_ON = "createdOn";
	private static final String MODIFIED_ON = "modifiedOn";
	private static final String INTEGRATION_CONFIG = "integrationConfig";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 255, name = SENSOR_NAME, unique = true)
	@NotNull
	private String name;
	
	@Column(length = 500, name = SENSOR_DESCRIPTION)
	private String description;
	
	@Column(length = 1024, name = INTEGRATION_CONFIG)
	@NotNull
	private String integrationConfig;
	
	@Column
	private boolean active;

	@Column
	private boolean deleted;

	@OneToMany(mappedBy = "sensor")
	private List<PlotEntity> plots = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	@Column(length = 50)
	@NotNull
	private Status status;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = CREATED_ON)
	private Date createdOn;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = MODIFIED_ON)
	private Date modifiedOn;
}
