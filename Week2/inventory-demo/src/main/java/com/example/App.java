package com.example;

import com.example.Exceptions.BankException;
import com.example.services.Bank;
import com.example.services.BankImpl;

// import java.util.List;

// import com.example.factory.MyHibernateSessionFactory;
// import com.example.models.Account;
// import com.example.models.Inventory;
// import com.example.models.Product;
// import com.example.services.InventoryService;
// import com.example.services.InventoryServiceImpl;
// import org.hibernate.Session;

public class App {

  public static void main(String[] args) {
    try {
      Bank bank = new BankImpl();
      int accountNumber = bank.openAccount("John Doe", 100.00);
      System.out.println(
        "Account opened successfully with number: " + accountNumber
      );
      double balance;
      balance = bank.getBalance(accountNumber);
      System.out.println("Balance: " + balance);
      bank.deposit(50.00, accountNumber);
      balance = bank.getBalance(accountNumber);
      System.out.println(
        "Balance: " + balance + " for account number: " + accountNumber
      );
      bank.withdraw(25.00, accountNumber);
      balance = bank.getBalance(accountNumber);
      System.out.println(
        "Balance: " + balance + " for account number: " + accountNumber
      );

      bank.closeAccount(accountNumber);
      System.out.println(
        "Account closed successfully with number: " + accountNumber
      );
    } catch (BankException e) {
      System.out.println(e.getMessage());
    }
  }
}
// Product product = new Product("Fancy Widget", 19.99);
// System.out.println(product);
// InventoryService inventoryService = new InventoryServiceImpl();
// List<Inventory> inventories = inventoryService.getInventoryByProductName("Fancy Widget");
// Inventory inventory;
// if (inventories.isEmpty()) {
//   inventory = inventoryService.createInventory(new Inventory(product.getId(), product.getName(), 100));
// } else {
//   inventory = inventories.get(0);
// }
// System.out.println("Inventory: " + inventory);
// product = new Product(inventory.getName(), 29.99);
// product = inventoryService.addProductToInventory(product, inventory);
// System.out.println("Product saved successfully with id: " + product.getId());
// Session session = MyHibernateSessionFactory.getSessionFactory().openSession();
// session.beginTransaction();
// List<Product> products = session.createQuery("from Product", Product.class).list();
// session.getTransaction().commit();
// session.close();
// System.out.println("Products: " + products);
// inventory.setQuantity(50);
// inventoryService.updateInventory(inventory);
// inventoryService.deleteInventory(inventory.getId());
// System.out.println("Inventory deleted successfully");
