package Interfaces.Account;

public class Tester {
  
  public static void main(String[] args) {
    Bank bank = new Bank();
    
    bank.addAccount("Current", 1, 1000);
    bank.addAccount("Savings", 2, 2000);
    bank.viewAccounts();
    System.out.println("Removing account 1...");
    bank.removeAccount(1);
    bank.viewAccounts();
  }
}
