package Interfaces.Account;

public interface Account {
  public void deposit(double amount);
  public void withdraw(double amount);
  public void viewBalance();
  public void calculateInterest();
  public String toString();
  public String getType();
  public int getId();
}