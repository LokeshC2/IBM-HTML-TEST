package org.ibm.tutorialservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
  private String userId;
  private String password;
  private String description;
  @JsonProperty
  private boolean isActive;
}
