package com.example.factory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.model.Comment;
import com.example.model.Tutorial;

public class MySessionFactory {

  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      Configuration configuration = new Configuration();
      configuration.configure("hibernate.cfg.xml");
      configuration.addAnnotatedClass(Tutorial.class);
      configuration.addAnnotatedClass(Comment.class);
      sessionFactory = configuration.buildSessionFactory();
    }
    return sessionFactory;
  }

  public static void save(Object o) {
    SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.save(o);
    session.getTransaction().commit();
    session.close();
  }

  public static <T> T getById(Class<T> clazz, int id) {
    SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
    Session session = sessionFactory.openSession();
    T t = session.get(clazz, id);
    session.close();
    return t;
  }

  public static <T> List<T> getAll(Class<T> clazz) {
    SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
    Session session = sessionFactory.openSession();
    List<T> list = session.createQuery("from " + clazz.getName(), clazz).list();
    session.close();
    return list;
  }

  public static void update(Object o) {
    SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.update(o);
    session.getTransaction().commit();
    session.close();
  }

  public static void delete(Object o) {
    SessionFactory sessionFactory = MySessionFactory.getSessionFactory();
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.delete(o);
    session.getTransaction().commit();
    session.close();
  }

  public static void closeSessionFactory() {
    if (sessionFactory != null) {
      sessionFactory.close();
    }
  }
}
