package com.example;

import com.example.models.CD;
import com.example.models.InternationalCD;
import com.example.models.SpecialCD;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

  public static void main(String[] args) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(CD.class)
      .addAnnotatedClass(InternationalCD.class)
      .addAnnotatedClass(SpecialCD.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.save(new CD("CD1"));
    session.save(new InternationalCD("CD2", "English"));
    session.save(new SpecialCD("CD3", "Special Feature"));
    session.getTransaction().commit();
    session.close();

    session = sessionFactory.openSession();
    session.beginTransaction();
    List<CD> cds = session.createQuery("from CD", CD.class).getResultList();
    session.getTransaction().commit();
    session.close();

    for (CD cd : cds) {
      System.out.println(cd);
    }
  }
}
