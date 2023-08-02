package org.ibm.tutorialservice.dto;

import org.ibm.tutorialservice.model.Tutorial;

import lombok.Getter;

@Getter
public class UserRequest extends Tutorial {
  private String userId;
  private String password;
}
