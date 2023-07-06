package com.example.service;

import java.util.List;

import com.example.models.Order;
import com.example.models.Product;

public interface Inventory {
  public void addProduct(Product product);
  public void deleteProduct(int id);
  public List<Product> getAllProduct();
  public List<Product> findProductByName(String name);
  public Order sellProduct(int id, int quantity);
  public void updateProductQuantity(int id, int quantity);
  public void updateProductPrice(int id, int cost);
}
