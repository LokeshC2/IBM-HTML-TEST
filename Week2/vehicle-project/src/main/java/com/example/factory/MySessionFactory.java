package com.example.factory;

import com.example.model.Car;
import com.example.model.Motorcycle;
import com.example.model.RoadVehicle;
import org.hibernate.SessionFactory;

public class MySessionFactory {

  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {
    if (sessionFactory != null) return sessionFactory;
    sessionFactory =
      new org.hibernate.cfg.Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(RoadVehicle.class)
        .addAnnotatedClass(Car.class)
        .addAnnotatedClass(Motorcycle.class)
        .buildSessionFactory();
    return sessionFactory;
  }
}