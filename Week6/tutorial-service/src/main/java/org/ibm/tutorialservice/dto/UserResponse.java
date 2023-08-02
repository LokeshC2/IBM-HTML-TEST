package org.ibm.tutorialservice.dto;

import lombok.Data;

@Data
public class UserResponse {
  private String userId;
  private String firstName;
  private String lastName;
  private String email;
  private String errorResponseTime;
	private String errorMessage;
	private int status;
}
