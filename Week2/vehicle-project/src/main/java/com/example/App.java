package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.factory.MySessionFactory;
import com.example.model.Car;
import com.example.model.Motorcycle;

public class App {
  public static void main(String[] args) {
    SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.save(new Car("Toyota", "Camry"));
    session.save(new Car("Honda", "Accord"));
    session.save(new Motorcycle("Honda", "CBR600RR"));
    session.save(new Motorcycle("Yamaha", "YZF-R6"));
    session.getTransaction().commit();
    session.close();
  }
}
