package Interfaces.Account;

public class CurrentAccount implements Account {

    private String Type = "Current";

    private int id;
  
    private double balance;
  
    public CurrentAccount(int id, double balance) {
      this.id = id;
      this.balance = balance;
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
    public void viewBalance() {
      System.out.println("Current Account Balance: " + balance);
    }
  
    @Override
    public void calculateInterest() {
      System.out.println("Current Account Interest: " + balance * 0.02);
    }

    @Override
    public String toString() {
      return "Current Account id: " + id + " balance: " + balance;
    }

    @Override
    public String getType() {
      return Type;
    }

    @Override
    public int getId() {
      return id;
    }
}