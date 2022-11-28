package com.banque.misr.irrigationsystem.entity;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.banque.misr.irrigationsystem.enums.Status;

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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = IrrigationTimingsEntity.TABLE_NAME)
@Data
public class IrrigationTimingsEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static final String TABLE_NAME = "irrigationTimings";

	private static final String IRRIGATION_STARTS_AT = "irrigationStartsAt";
	private static final String IRRIGATION_ENDS_AT = "irrigationEndsAt";
	private static final String CREATED_ON = "createdOn";
	private static final String MODIFIED_ON = "modifiedOn";
	private static final String PLOT_ID = "plotId";
	private static final String AMOUNT_OF_WATER = "amountOfWater";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = AMOUNT_OF_WATER)
	@NotNull
	private double amountOfWater;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = IRRIGATION_STARTS_AT)
	@NotNull
	private Date from;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = IRRIGATION_ENDS_AT)
	@NotNull
	private Date to;
	
	@Enumerated(EnumType.STRING)
	@Column(length = 50)
	@NotNull
	private Status status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = PLOT_ID)
	private PlotEntity plot;
	
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = CREATED_ON)
	private Date createdOn;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = MODIFIED_ON)
	private Date modifiedOn;
}
