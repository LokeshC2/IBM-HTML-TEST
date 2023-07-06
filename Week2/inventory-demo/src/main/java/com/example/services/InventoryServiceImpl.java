package com.example.services;

import java.util.List;

import org.hibernate.Session;

import com.example.factory.MyHibernateSessionFactory;
import com.example.models.Inventory;
import com.example.models.Product;

public class InventoryServiceImpl implements InventoryService {

  @Override
  public Inventory createInventory(Inventory inventory) {
    Session session = MyHibernateSessionFactory.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(inventory);
    session.getTransaction().commit();
    session.close();
    return inventory;
  }

  @Override
  public List<Inventory> getAllInventory() {
    Session session = MyHibernateSessionFactory.getSessionFactory().openSession();
    session.beginTransaction();
    List<Inventory> inventoryList = session.createQuery("from Inventory", Inventory.class).list();
    session.getTransaction().commit();
    session.close();
    return inventoryList;
  }

  @Override
  public Inventory getInventoryByid(int inventoryId) {
    Session session = MyHibernateSessionFactory.getSessionFactory().openSession();
    session.beginTransaction();
    Inventory inventory = session.get(Inventory.class, inventoryId);
    session.getTransaction().commit();
    session.close();
    return inventory;
  }

  @Override
  public List<Inventory> getInventoryByProductName(String productName) {
    Session session = MyHibernateSessionFactory.getSessionFactory().openSession();
    session.beginTransaction();
    List<Inventory> inventoryList = session.createQuery("from Inventory where product_name = :productName", Inventory.class)
        .setParameter("productName", productName).list();
    session.getTransaction().commit();
    session.close();
    return inventoryList;    
  }
  
  @Override
  public Inventory updateInventory(Inventory inventory) {
    Session session = MyHibernateSessionFactory.getSessionFactory().openSession();
    session.beginTransaction();
    session.merge(inventory);
    session.close();
    return inventory;
  }

  @Override
  public Product addProductToInventory(Product product, Inventory inventory) {
    Session session = MyHibernateSessionFactory.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(product);
    session.getTransaction().commit();
    session.close();
    return product;
  }
}
