package com.example.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateFactory {
  private static SessionFactory sessionFactory = getsessionFactory();

  private HibernateFactory() {}

  public static SessionFactory getsessionFactory() {
    Configuration configuration = new Configuration();
    configuration.configure("hibernate.cfg.xml");
    configuration.addAnnotatedClass(com.example.model.League.class);
    return configuration.buildSessionFactory();
  }

  public static Session getSession() {
    return sessionFactory.openSession();
  }
}
