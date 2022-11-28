package com.banque.misr.irrigationsystem.model;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.banque.misr.irrigationsystem.enums.CropType;
import com.banque.misr.irrigationsystem.enums.MeasuringUnit;
import com.banque.misr.irrigationsystem.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

/**
 * Plot Resource
 */

@Schema(name = "Plot", description = "Plot Resource")
@Builder
public class Plot {

  @JsonProperty("id")
  private Long id;

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("createdOn")
  private String createdOn;

  @JsonProperty("modifiedOn")
  private String modifiedOn;

  @JsonProperty("status")
  private Status status;

  @JsonProperty("cropType")
  private CropType cropType;

  @JsonProperty("measuringUnit")
  private MeasuringUnit measuringUnit;

  @JsonProperty("active")
  private Boolean active;

  @JsonProperty("deleted")
  private Boolean deleted;

  @JsonProperty("plotArea")
  private double plotArea;

  @JsonProperty("sensor")
  private Sensor sensor;
  
  @JsonProperty("irrigationTimings")
  private List<IrrigationTiming> irrigationTimings;
  
  public Plot id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull 
  @Schema(name = "id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Plot name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  */
  @NotNull 
  @Schema(name = "name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Plot description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  
  @Schema(name = "description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Plot createdOn(String createdOn) {
    this.createdOn = createdOn;
    return this;
  }

  /**
   * Get createdOn
   * @return createdOn
  */
  @NotNull 
  @Schema(name = "createdOn")
  public String getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(String createdOn) {
    this.createdOn = createdOn;
  }

  public Plot modifiedOn(String modifiedOn) {
    this.modifiedOn = modifiedOn;
    return this;
  }

  /**
   * Get modifiedOn
   * @return modifiedOn
  */
  @NotNull 
  @Schema(name = "modifiedOn")
  public String getModifiedOn() {
    return modifiedOn;
  }

  public void setModifiedOn(String modifiedOn) {
    this.modifiedOn = modifiedOn;
  }

  public Plot status(Status status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @NotNull @Valid 
  @Schema(name = "status")
  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public Plot cropType(CropType cropType) {
    this.cropType = cropType;
    return this;
  }

  /**
   * Get cropType
   * @return cropType
  */
  @NotNull @Valid 
  @Schema(name = "cropType")
  public CropType getCropType() {
    return cropType;
  }

  public void setCropType(CropType cropType) {
    this.cropType = cropType;
  }

  public Plot measuringUnit(MeasuringUnit measuringUnit) {
    this.measuringUnit = measuringUnit;
    return this;
  }

  /**
   * Get measuringUnit
   * @return measuringUnit
  */
  @NotNull @Valid 
  @Schema(name = "measuringUnit")
  public MeasuringUnit getMeasuringUnit() {
    return measuringUnit;
  }

  public void setMeasuringUnit(MeasuringUnit measuringUnit) {
    this.measuringUnit = measuringUnit;
  }

  public Plot active(Boolean active) {
    this.active = active;
    return this;
  }

  /**
   * Get active
   * @return active
  */
  @NotNull 
  @Schema(name = "active")
  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public Plot deleted(Boolean deleted) {
    this.deleted = deleted;
    return this;
  }

  /**
   * Get deleted
   * @return deleted
  */
  @NotNull 
  @Schema(name = "deleted")
  public Boolean getDeleted() {
    return deleted;
  }

  public void setDeleted(Boolean deleted) {
    this.deleted = deleted;
  }

  public Plot plotArea(double plotArea) {
    this.plotArea = plotArea;
    return this;
  }

  /**
   * Get plotArea
   * @return plotArea
  */
  @NotNull @Valid 
  @Schema(name = "plotArea")
  public double getPlotArea() {
    return plotArea;
  }

  public void setPlotArea(double plotArea) {
    this.plotArea = plotArea;
  }
  
  public Plot irrigationTimings(List<IrrigationTiming> irrigationTimings) {
	  this.irrigationTimings = irrigationTimings;
	  return this;
  }
  
  /**
   * Get irrigationTimings
   * @return irrigationTimings
  */
  @Schema(name = "irrigationTimings")
  public List<IrrigationTiming> getIrrigationTimings() {
	return irrigationTimings;
  }
	
  public void setIrrigationTimings(List<IrrigationTiming> irrigationTimings) {
	this.irrigationTimings = irrigationTimings;
  }
  
  public Plot sensor(Sensor sensor) {
	  this.sensor = sensor;
	  return this;
  }
  
  /**
   * Get sensor
   * @return sensor
  */
  @Schema(name = "sensor")
  public Sensor getSensor() {
	return sensor;
  }
	
  public void setSensor(Sensor sensor) {
	this.sensor = sensor;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Plot plot = (Plot) o;
    return Objects.equals(this.id, plot.id) &&
        Objects.equals(this.name, plot.name) &&
        Objects.equals(this.description, plot.description) &&
        Objects.equals(this.createdOn, plot.createdOn) &&
        Objects.equals(this.modifiedOn, plot.modifiedOn) &&
        Objects.equals(this.status, plot.status) &&
        Objects.equals(this.cropType, plot.cropType) &&
        Objects.equals(this.measuringUnit, plot.measuringUnit) &&
        Objects.equals(this.active, plot.active) &&
        Objects.equals(this.deleted, plot.deleted) &&
        Objects.equals(this.plotArea, plot.plotArea) &&
        Objects.equals(this.irrigationTimings, plot.irrigationTimings) &&
        Objects.equals(this.sensor, plot.sensor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, createdOn, modifiedOn, status, cropType, measuringUnit, active, deleted, plotArea, irrigationTimings, sensor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Plot {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
    sb.append("    modifiedOn: ").append(toIndentedString(modifiedOn)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    cropType: ").append(toIndentedString(cropType)).append("\n");
    sb.append("    measuringUnit: ").append(toIndentedString(measuringUnit)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    deleted: ").append(toIndentedString(deleted)).append("\n");
    sb.append("    plotArea: ").append(toIndentedString(plotArea)).append("\n");
    sb.append("    irrigationTimings: ").append(toIndentedString(irrigationTimings)).append("\n");
    sb.append("    sensor: ").append(toIndentedString(sensor)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

