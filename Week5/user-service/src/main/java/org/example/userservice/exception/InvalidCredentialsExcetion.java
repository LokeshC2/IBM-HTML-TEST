package org.example.userservice.exception;

public class InvalidCredentialsExcetion extends Exception {

  private static final long serialVersionUID = 1L;

  public InvalidCredentialsExcetion(String message) {
    super(message);
  }

}