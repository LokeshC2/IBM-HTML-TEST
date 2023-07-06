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
    Product product = new Product("Fancy Widget", 19.99);
    System.out.println(product);

    InventoryService inventoryService = new InventoryServiceImpl();
    List<Inventory> inventories = inventoryService.getInventoryByProductName("Fancy Widget");
    Inventory inventory;
    if (inventories.isEmpty()) {
      inventory = inventoryService.createInventory(new Inventory(product.getId(), product.getName(), 100));
    } else {
      inventory = inventories.get(0);
    }
    System.out.println("Inventory: " + inventory);
    
    product = new Product(inventory.getName(), 29.99);
    product = inventoryService.addProductToInventory(product, inventory);
    System.out.println("Product saved successfully with id: " + product.getId());

    Session session = MyHibernateSessionFactory.getSessionFactory().openSession();
    session.beginTransaction();
    List<Product> products = session.createQuery("from Product", Product.class).list();
    session.getTransaction().commit();
    session.close();
    System.out.println("Products: " + products);

    inventory.setQuantity(50);
    inventoryService.updateInventory(inventory);
  }
}
