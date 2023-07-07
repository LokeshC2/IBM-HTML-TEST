package com.example.services;

import com.example.models.Inventory;
import com.example.models.Product;

import java.util.List;

public interface InventoryService {
  public Inventory createInventory(Inventory inventory);

  public List<Inventory> getAllInventory();

  public Inventory getInventoryByid(int inventoryId);

  public List<Inventory> getInventoryByProductName(String productName);

  public Inventory updateInventory(Inventory inventory);

  public Product addProductToInventory(Product product, Inventory inventory);

  public void deleteInventory(int inventoryId);
}
