package com.banque.misr.irrigationsystem.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

/**
 * The representation of an error
 */

@Schema(name = "Error", description = "The representation of an error")
@Builder
public class Error {

  @JsonProperty("message")
  private String message;

  @JsonProperty("code")
  private String code;

  public Error message(String message) {
    this.message = message;
    return this;
  }

  /**
   * The cause of the Error.
   * @return message
  */
  @NotNull 
  @Schema(name = "message", description = "The cause of the Error.")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Error code(String code) {
    this.code = code;
    return this;
  }

  /**
   * The error code.
   * @return code
  */
  @NotNull 
  @Schema(name = "code", description = "The error code.")
  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.message, error.message) &&
        Objects.equals(this.code, error.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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

