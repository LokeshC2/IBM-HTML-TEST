package com.example.services;

import com.example.Exceptions.AccountNotFoundException;
import com.example.Exceptions.InsufficientFundsException;
import com.example.factory.MyHibernateSessionFactory;
import com.example.models.Account;
import org.hibernate.Session;

public class BankImpl implements Bank {

  private Account getAccount(int accountNumber)
    throws AccountNotFoundException {
    Session session = MyHibernateSessionFactory
      .getSessionFactory()
      .openSession();
    session.beginTransaction();
    Account account = session.get(Account.class, accountNumber);
    session.getTransaction().commit();
    session.close();
    if (account == null) throw new AccountNotFoundException();
    return account;
  }

  @Override
  public int openAccount(String name, double balance) {
    Account account = new Account(name, balance);
    Session session = MyHibernateSessionFactory
      .getSessionFactory()
      .openSession();
    session.beginTransaction();
    session.save(account);
    session.getTransaction().commit();
    session.close();
    return account.getId();
  }

  @Override
  public void closeAccount(int accountNumber) throws AccountNotFoundException {
    Account account = getAccount(accountNumber);
    Session session = MyHibernateSessionFactory
      .getSessionFactory()
      .openSession();
    session.beginTransaction();
    session.delete(account);
    session.getTransaction().commit();
    session.close();
  }

  @Override
  public double getBalance(int accountNumber) throws AccountNotFoundException {
    Account account = getAccount(accountNumber);
    return account.getBalance();
  }

  @Override
  public void deposit(double amount, int accountNumber)
    throws AccountNotFoundException {
    Account account = getAccount(accountNumber);
    Session session = MyHibernateSessionFactory
      .getSessionFactory()
      .openSession();
    session.beginTransaction();
    account.setBalance(account.getBalance() + amount);
    session.merge(account);
    session.getTransaction().commit();
    session.close();
  }

  @Override
  public void withdraw(double amount, int accountNumber)
    throws InsufficientFundsException, AccountNotFoundException {
    Account account = getAccount(accountNumber);
    if (account.getBalance() < amount) throw new InsufficientFundsException();
    account.setBalance(account.getBalance() - amount);
    Session session = MyHibernateSessionFactory
      .getSessionFactory()
      .openSession();
    session.beginTransaction();
    session.merge(account);
    session.getTransaction().commit();
    session.close();
  }
}
