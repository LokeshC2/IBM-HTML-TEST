package Interfaces.Account;

import java.util.Vector;

public class Bank {
  private Vector<Account> accounts = new Vector<Account>();

  public void addAccount(String type, int id, double balance) {
    if (type.equals("Current")) {
      accounts.add(new CurrentAccount(id, balance));
    } else if (type.equals("Savings")) {
      accounts.add(new SavingsAccount(id, balance));
    }
  }

  public void removeAccount(int id) {
    int i = -1;
    for (Account account : accounts) {
      if (account.getId() == id) {
        i = accounts.indexOf(account);
      }
    }
    if (i != -1) {
      accounts.remove(i);
    }
  }

  public void viewAccounts() {
    for (Account account : accounts) {
      System.out.println(account);
    }
  }
}
