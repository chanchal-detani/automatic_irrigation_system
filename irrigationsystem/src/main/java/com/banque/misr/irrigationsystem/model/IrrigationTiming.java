package com.banque.misr.irrigationsystem.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

/**
 * Irrigation Timing Response
 */

@Schema(name = "IrrigationTiming", description = "Irrigation Timing Response")
@Builder
public class IrrigationTiming {

  @JsonProperty("startAt")
  private String startAt;

  @JsonProperty("endsAt")
  private String endsAt;

  @JsonProperty("amountOfWater")
  private Double amountOfWater;

  public IrrigationTiming startAt(String startAt) {
    this.startAt = startAt;
    return this;
  }

  /**
   * startAt 'YYYY-mm-dd HH:MM:SS'
   * @return startAt
  */
  @NotNull 
  @Schema(name = "startAt", description = "startAt 'YYYY-mm-dd HH:MM:SS'")
  public String getStartAt() {
    return startAt;
  }

  public void setStartAt(String startAt) {
    this.startAt = startAt;
  }

  public IrrigationTiming endsAt(String endsAt) {
    this.endsAt = endsAt;
    return this;
  }

  /**
   * endsAt 'YYYY-mm-dd HH:MM:SS'
   * @return endsAt
  */
  @NotNull 
  @Schema(name = "endsAt", description = "endsAt 'YYYY-mm-dd HH:MM:SS'")
  public String getEndsAt() {
    return endsAt;
  }

  public void setEndsAt(String endsAt) {
    this.endsAt = endsAt;
  }

  public IrrigationTiming amountOfWater(Double amountOfWater) {
    this.amountOfWater = amountOfWater;
    return this;
  }

  /**
   * Get amountOfWater
   * @return amountOfWater
  */
  @NotNull 
  @Schema(name = "amountOfWater")
  public Double getAmountOfWater() {
    return amountOfWater;
  }

  public void setAmountOfWater(Double amountOfWater) {
    this.amountOfWater = amountOfWater;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    IrrigationTiming irrigationTiming = (IrrigationTiming) o;
    return Objects.equals(this.startAt, irrigationTiming.startAt) &&
        Objects.equals(this.endsAt, irrigationTiming.endsAt) &&
        Objects.equals(this.amountOfWater, irrigationTiming.amountOfWater);
  }

  @Override
  public int hashCode() {
    return Objects.hash(startAt, endsAt, amountOfWater);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class IrrigationTiming {\n");
    sb.append("    startAt: ").append(toIndentedString(startAt)).append("\n");
    sb.append("    endsAt: ").append(toIndentedString(endsAt)).append("\n");
    sb.append("    amountOfWater: ").append(toIndentedString(amountOfWater)).append("\n");
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

