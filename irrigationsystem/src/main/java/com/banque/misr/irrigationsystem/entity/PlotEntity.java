package com.banque.misr.irrigationsystem.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.banque.misr.irrigationsystem.enums.CropType;
import com.banque.misr.irrigationsystem.enums.MeasuringUnit;
import com.banque.misr.irrigationsystem.enums.Status;

import lombok.Data;

@Entity
@Table(name = PlotEntity.TABLE_NAME)
@Data
public class PlotEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "plot";
	private static final String SENDOR_ID = "sensorId";
	private static final String PLOT_NAME = "plotName";
	private static final String PLOT_DESCRIPTION = "plotDescription";
	private static final String PLOT_AREA = "plotArea";
	private static final String PLOT_MEASURING_UNIT = "plotMeasuringUnit";
	private static final String CROP_TYPE = "cropType";
	private static final String CREATED_ON = "createdOn";
	private static final String MODIFIED_ON = "modifiedOn";
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 255, name = PLOT_NAME, unique = true)
	@NotNull
	private String name;
	
	@Column(length = 500, name = PLOT_DESCRIPTION)
	private String description;

	@Column(name = PLOT_AREA, precision = 4)
	@NotNull
	private double area;

	@Enumerated(EnumType.STRING)
	@Column(name = PLOT_MEASURING_UNIT, length = 50)
	@NotNull
	private MeasuringUnit measuringUnit;

	@Enumerated(EnumType.STRING)
	@Column(name = CROP_TYPE, length = 50)
	@NotNull
	private CropType cropType;

	@Column
	private boolean active;

	@Column
	private boolean deleted;

	@Enumerated(EnumType.STRING)
	@Column(length = 50)
	@NotNull
	private Status status;
	
	@OneToMany(mappedBy = "plot")
	private List<IrrigationTimingsEntity> slots = new ArrayList<>();
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = SENDOR_ID)
	private SensorEntity sensor;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = CREATED_ON)
	private Date createdOn;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = MODIFIED_ON)
	private Date modifiedOn;
}
