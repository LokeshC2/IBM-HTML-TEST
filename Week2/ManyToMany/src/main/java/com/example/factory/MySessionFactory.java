package com.example.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.model.Student;
import com.example.model.Course;

public class MySessionFactory {

  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      Configuration configuration = new Configuration();
      configuration.configure("hibernate.cfg.xml");
      configuration.addAnnotatedClass(Course.class);
      configuration.addAnnotatedClass(Student.class);
      sessionFactory = configuration.buildSessionFactory();
    }
    return sessionFactory;
  }
}