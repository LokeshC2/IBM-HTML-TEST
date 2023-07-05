package com.example.service;

import java.util.List;

import com.example.models.Product;

public interface Inventory {
  public void addProduct(String name, int quantity, int price);
  public void deleteProduct(int id);
  public List<Product> getAllProducts();
  public Product getProductById(int id);
  public void updateProduct(int id, String name, int quantity, int price);
  public void updateProductQuantity(int id, int quantity);
  public void updateProductPrice(int id, int price);
  public void updateProductName(int id, String name);
}
