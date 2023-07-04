// Q.3 Design a class for a bank database the database should support the following operations.
//     1. Deposit a certain amount into an account,
//     2. Withdrawing a certain amount from an account,
//     3. Return a value specifying the amount (i.e. balance) in an amount.

package Assignment;

import java.util.HashMap;

public class Q3 {

  public static void main(String[] args) {
    Q3 q3 = new Q3();
    BankDb bankDb = q3.new BankDb();
    Account account1 = q3.new Account(1, "Account 1", 1000);
    Account account2 = q3.new Account(2, "Account 2", 2000);
    Account account3 = q3.new Account(3, "Account 3", 3000);
    bankDb.addAccount(account1);
    bankDb.addAccount(account2);
    bankDb.addAccount(account3);
    bankDb.deposit(1, 100);
    bankDb.withdraw(2, 200);
    System.out.println(bankDb.getBalance(1));
    System.out.println(bankDb.getBalance(2));
    System.out.println(bankDb.getBalance(3));
  }

  public class BankDb {
    private HashMap<Integer, Account> accounts = new HashMap<>();

    BankDb() {}

    private void addAccount(Account account) {
      accounts.put(account.getAccountNumber(), account);
    }

    private void deposit(int accountNumber, int amount) {
      Account account = accounts.get(accountNumber);
      account.deposit(amount);
    }

    private void withdraw(int accountNumber, int amount) {
      Account account = accounts.get(accountNumber);
      account.withdraw(amount);
    }

    private int getBalance(int accountNumber) {
      Account account = accounts.get(accountNumber);
      return account.getBalance();
    }
  }

  public class Account {

    private int accountNumber;
    private String accountHolderName;
    private int balance;

    Account() {}

    Account(int accountNumber, String accountHolderName, int balance) {
      this.accountNumber = accountNumber;
      this.accountHolderName = accountHolderName;
      this.balance = balance;
    }

    public void deposit(int amount) {
      this.balance += amount;
    }

    public void withdraw(int amount) {
      this.balance -= amount;
    }

    public int getAccountNumber() {
      return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
      this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
      return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
      this.accountHolderName = accountHolderName;
    }

    public void setBalance(int balance) {
      this.balance = balance;
    }

    public int getBalance() {
      return this.balance;
    }
  }
}
