package Interfaces.Account;

public class SavingsAccount implements Account {
  
    private double balance;
    private int id;
  
    public SavingsAccount(int id, double balance) {
      this.id = id;
      this.balance = balance;
    }
  
    @Override
    public void viewBalance() {
      System.out.println("Savings Account Balance: " + balance);
    }
  
    @Override
    public void deposit(double amount) {
      balance += amount;
    }
  
    @Override
    public void withdraw(double amount) {
      balance -= amount;
    }

    @Override
    public void calculateInterest() {
      System.out.println("Savings Account Interest: " + balance * 0.05);
    }
  
    @Override
    public String toString() {
      return "Savings Account id: " + id + " balance: " + balance;
    }

    @Override
    public String getType() {
      return "Savings";
    }

    @Override
    public int getId() {
      return id;
    }
}