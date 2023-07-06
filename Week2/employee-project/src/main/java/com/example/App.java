package com.example;

import com.example.models.Product;
import com.example.service.Store;
import java.util.List;

public class App {

  public static void main(String[] args) {
    Store store = new Store();

    store.addProduct(new Product("Milk", 10, 100));
    store.addProduct(new Product("Bread", 5, 200));
    store.addProduct(new Product("Eggs", 20, 50));
    store.addProduct(new Product("Butter", 15, 100));

    List<Product> products = store.getAllProduct();
    products.forEach(System.out::println);

    System.out.println("Find product by name: ");
    products = store.findProductByName("Milk");
    products.forEach(System.out::println);
    int order = 80;
    if (products.size() > 0) {
      store.sellProduct(products.get(0).getId(), order);
    }
    System.out.println("After selling: ");
    products = store.getAllProduct();
    products.forEach(System.out::println);

    products.forEach(product -> {
      store.deleteProduct(product.getId());
    });
  }
}
