package com.example;

import java.sql.SQLException;
import java.util.List;

import com.example.factory.MyHibernateSessionFactory;
import com.example.models.Inventory;
import com.example.models.Product;
import com.example.services.InventoryService;
import com.example.services.InventoryServiceImpl;
import org.hibernate.Session;

public class App {

  public static void main(String[] args) throws SQLException {
    Product product = new Product(1, "Fancy Widget", 19.99);
    System.out.println(product);

    InventoryService inventoryService = new InventoryServiceImpl();
    List<Inventory> inventories = inventoryService.getInventoryByProductName("Fancy Widget");
    if (inventories.isEmpty()) return;
    Inventory inventory = inventories.get(0);
    
    Session session = MyHibernateSessionFactory.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(new Product(inventory.getName(), 29.99));
    session.getTransaction().commit();
    session.close();
  }
}
