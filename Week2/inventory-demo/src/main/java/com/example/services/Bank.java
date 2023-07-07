package com.example.services;

import com.example.Exceptions.AccountNotFoundException;
import com.example.Exceptions.InsufficientFundsException;

public interface Bank {
  public int openAccount(String name, double balance);
  public void deposit(double amount, int accountNumber) throws AccountNotFoundException;
  public void withdraw(double amount, int accountNumber) throws InsufficientFundsException, AccountNotFoundException;
  public double getBalance(int accountNumber) throws AccountNotFoundException;
  public void closeAccount(int accountNumber) throws AccountNotFoundException;
}
