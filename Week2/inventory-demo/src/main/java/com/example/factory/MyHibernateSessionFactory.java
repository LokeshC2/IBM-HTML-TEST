package com.example.factory;

import com.example.models.Account;
import com.example.models.Inventory;
import com.example.models.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MyHibernateSessionFactory {

  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {
    sessionFactory =
      new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Inventory.class)
        .addAnnotatedClass(Product.class)
        .addAnnotatedClass(Account.class)
        .buildSessionFactory();
    return sessionFactory;
  }
}
