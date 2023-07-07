package com.example.Exceptions;

public class InsufficientFundsException extends BankException {

  public InsufficientFundsException() {
    super("Insufficient funds");
  }
}
