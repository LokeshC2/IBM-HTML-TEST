package com.example.dao;

import com.example.entity.Product;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component("productDao")
public class ProductDaoImpl implements ProductDao {

  ApplicationContext context;

  @Autowired
  public ProductDaoImpl(ApplicationContext context) {
    this.context = context;
  }
  
  @Override
  public void saveProduct(Product product) {
    SessionFactory sessionFactory = context.getBean("sessionFactory",SessionFactory.class);
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.save(product);
    session.getTransaction().commit();
    session.close();
  }

  @Override
  public List<Product> listProducts() {
    SessionFactory sessionFactory = context.getBean("sessionFactory",SessionFactory.class);
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<Product> p = session.createQuery("from Product", Product.class).list();
    session.getTransaction().commit();
    session.close();
    return p;
  }
}
