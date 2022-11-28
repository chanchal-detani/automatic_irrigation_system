package com.banque.misr.irrigationsystem.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

/**
 * PlotsPage
 */

@Schema(name = "PlotsPage", description = "The representation of an Plots List")
@Builder
public class PlotsPage {

  @JsonProperty("plots")
  @Valid
  private List<Plot> plots;

  @JsonProperty("pageInfo")
  private PageInfo pageInfo;

  public PlotsPage plots(List<Plot> plots) {
    this.plots = plots;
    return this;
  }

  public PlotsPage addPlotsItem(Plot plotsItem) {
    if (this.plots == null) {
      this.plots = new ArrayList<>();
    }
    this.plots.add(plotsItem);
    return this;
  }

  /**
   * Get plots
   * @return plots
  */
  @Valid 
  @Schema(name = "plots")
  public List<Plot> getPlots() {
    return plots;
  }

  public void setPlots(List<Plot> plots) {
    this.plots = plots;
  }

  public PlotsPage pageInfo(PageInfo pageInfo) {
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
    PlotsPage plotsPage = (PlotsPage) o;
    return Objects.equals(this.plots, plotsPage.plots) &&
        Objects.equals(this.pageInfo, plotsPage.pageInfo);
  }

  @Override
  public int hashCode() {
    return Objects.hash(plots, pageInfo);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlotsPage {\n");
    sb.append("    plots: ").append(toIndentedString(plots)).append("\n");
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

