package com.example.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateFactory {
  private static final HibernateFactory instance = new HibernateFactory();
  private static SessionFactory factory;

  static {
    try {
      factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    } catch (Exception ex) {
      System.err.println("Failed to create sessionFactory object." + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }

  public static HibernateFactory getInstance() {
    return instance;
  }

  public Session getSession() {
    return factory.openSession();
  }

  public void close() {
    factory.close();
  }
}