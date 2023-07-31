package org.ibm.conversionservice.ui;

public class ExceptionResponseModel {
  private String message;
  private String details;

  public ExceptionResponseModel(String message, String details) {
    this.message = message;
    this.details = details;
  }

  public String getMessage() {
    return this.message;
  }

  public String getDetails() {
    return this.details;
  }
}
