package com.example.Exceptions;

public class AccountNotFoundException extends BankException {
  public AccountNotFoundException() {
    super("Account not found");
  }
}