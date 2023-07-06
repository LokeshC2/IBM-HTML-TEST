package com.example.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.models.Inventory;
import com.example.models.Product;

public class MyHibernateSessionFactory {
  private static SessionFactory sessionFactory;

  {
    sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Inventory.class)
        .addAnnotatedClass(Product.class).buildSessionFactory();
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}
