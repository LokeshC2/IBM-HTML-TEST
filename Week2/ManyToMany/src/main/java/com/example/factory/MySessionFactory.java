package com.example.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.model.Album;
import com.example.model.InternationalAlbum;
import com.example.model.NationalAlbum;

public class MySessionFactory {

  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {
    if (sessionFactory == null) {
      Configuration configuration = new Configuration();
      configuration.configure("hibernate.cfg.xml");
      configuration.addAnnotatedClass(Album.class);
      configuration.addAnnotatedClass(NationalAlbum.class);
      configuration.addAnnotatedClass(InternationalAlbum.class);
      sessionFactory = configuration.buildSessionFactory();
    }
    return sessionFactory;
  }
}