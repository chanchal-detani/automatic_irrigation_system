package com.banque.misr.irrigationsystem.model;

import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.banque.misr.irrigationsystem.enums.CropType;
import com.banque.misr.irrigationsystem.enums.MeasuringUnit;
import com.banque.misr.irrigationsystem.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Create Plot Request
 */

@Schema(name = "PlotRequest", description = "Plot Request")
public class PlotRequest {

  @JsonProperty("name")
  private String name;

  @JsonProperty("description")
  private String description;

  @JsonProperty("plotArea")
  private Integer plotArea;

  @JsonProperty("status")
  private Status status;

  @JsonProperty("cropType")
  private CropType cropType;

  @JsonProperty("measuringUnit")
  private MeasuringUnit measuringUnit;
  
  @JsonProperty("sensor")
  private SensorRequest sensor;

  public PlotRequest name(String name) {
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

  public PlotRequest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  */
  @NotNull 
  @Schema(name = "description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PlotRequest plotArea(Integer plotArea) {
    this.plotArea = plotArea;
    return this;
  }

  /**
   * Get plotArea
   * @return plotArea
  */
  @NotNull 
  @Schema(name = "plotArea")
  public Integer getPlotArea() {
    return plotArea;
  }

  public void setPlotArea(Integer plotArea) {
    this.plotArea = plotArea;
  }

  public PlotRequest status(Status status) {
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

  public PlotRequest cropType(CropType cropType) {
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

  public PlotRequest measuringUnit(MeasuringUnit measuringUnit) {
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
  
  public PlotRequest sensor(SensorRequest sensor) {
	  this.sensor = sensor;
	  return this;
  }
  /**
   * Get sensor
   * @return sensor
  */
  @NotNull @Valid 
  @Schema(name = "sensorRequest")
  public SensorRequest getSensor() {
	return sensor;
  }

  public void setSensor(SensorRequest sensor) {
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
    PlotRequest plotRequest = (PlotRequest) o;
    return Objects.equals(this.name, plotRequest.name) &&
        Objects.equals(this.description, plotRequest.description) &&
        Objects.equals(this.plotArea, plotRequest.plotArea) &&
        Objects.equals(this.status, plotRequest.status) &&
        Objects.equals(this.cropType, plotRequest.cropType) &&
        Objects.equals(this.sensor, plotRequest.sensor) &&
        Objects.equals(this.measuringUnit, plotRequest.measuringUnit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, description, plotArea, status, cropType, measuringUnit, sensor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class plotRequest {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    plotArea: ").append(toIndentedString(plotArea)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    cropType: ").append(toIndentedString(cropType)).append("\n");
    sb.append("    sensor: ").append(toIndentedString(sensor)).append("\n");
    sb.append("    measuringUnit: ").append(toIndentedString(measuringUnit)).append("\n");
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

