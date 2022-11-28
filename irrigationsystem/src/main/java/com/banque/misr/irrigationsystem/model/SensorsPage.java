package com.banque.misr.irrigationsystem.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

/**
 * SensorsPage
 */

@Schema(name = "SensorsPage", description = "The representation of an Sensors List")
@Builder
public class SensorsPage {

  @JsonProperty("sensors")
  @Valid
  private List<Sensor> sensors;

  @JsonProperty("pageInfo")
  private PageInfo pageInfo;

  public SensorsPage sensors(List<Sensor> sensors) {
    this.sensors = sensors;
    return this;
  }

  public SensorsPage addSensorItem(Sensor sensorItem) {
    if (this.sensors == null) {
      this.sensors = new ArrayList<>();
    }
    this.sensors.add(sensorItem);
    return this;
  }

  /**
   * Get sensors
   * @return sensors
  */
  @Valid 
  @Schema(name = "sensors")
  public List<Sensor> getSensors() {
    return sensors;
  }

  public void setSensors(List<Sensor> sensors) {
    this.sensors = sensors;
  }

  public SensorsPage pageInfo(PageInfo pageInfo) {
    this.pageInfo = pageInfo;
    return this;
  }

  /**
   * Get pageInfo
   * @return pageInfo
  */
  @Valid 
  @Schema(name = "pageInfo")
  public PageInfo getPageInfo() {
    return pageInfo;
  }

  public void setPageInfo(PageInfo pageInfo) {
    this.pageInfo = pageInfo;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SensorsPage sensorsPage = (SensorsPage) o;
    return Objects.equals(this.sensors, sensorsPage.sensors) &&
        Objects.equals(this.pageInfo, sensorsPage.pageInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sensors, pageInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SensorsPage {\n");
    sb.append("    sensors: ").append(toIndentedString(sensors)).append("\n");
    sb.append("    pageInfo: ").append(toIndentedString(pageInfo)).append("\n");
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

