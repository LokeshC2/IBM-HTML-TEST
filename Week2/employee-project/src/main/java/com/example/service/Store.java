package com.example.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.Connector;
import com.example.models.Product;

public class Store implements Inventory {

  {

  }

  @Override
  public void addProduct(String name, int quantity, int price) {
    Connection conn = Connector.getConnection();
    try {
      conn.createStatement().execute(
        "INSERT INTO products (name, quantity, price) VALUES ('" +
        name +
        "', '" +
        quantity +
        "', '" +
        price +
        "')"
      );
    } catch (Exception e) {
      System.out.println("Operation failed: \n" + e.getMessage());
    }
  }

  @Override
  public void deleteProduct(int id) {
    Connection conn = Connector.getConnection();
    try {
      conn.createStatement().execute(
        "DELETE FROM products WHERE id = '" + id + "'"
      );
    } catch (Exception e) {
      System.out.println("Operation failed: \n" + e.getMessage());
    }
  }

  @Override
  public List<Product> getAllProducts() {
    ArrayList <Product> products = new ArrayList<Product>();
    Connection conn = Connector.getConnection();
    try {
      ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM products");
      while (resultSet.next()) {
        products.add(
          new Product(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getInt("quantity"),
            resultSet.getInt("price")
          )
        );
      }
    } catch (Exception e) {
      System.out.println("Operation failed: \n" + e.getMessage());
    }
    return products;
  }

  @Override
  public Product getProductById(int id) {
    Connection conn = Connector.getConnection();
    Product product = null;
    try {
      ResultSet resultSet = conn.createStatement().executeQuery("SELECT * FROM products WHERE id = '" + id + "'");
      while (resultSet.next()) {
        product = new Product(
          resultSet.getInt("id"),
          resultSet.getString("name"),
          resultSet.getInt("quantity"),
          resultSet.getInt("price")
        );
      }
    } catch (Exception e) {
      System.out.println("Operation failed: \n" + e.getMessage());
    }
    return product;
  }

  @Override
  public void updateProduct(int id, String name, int quantity, int price) {
    Connection conn = Connector.getConnection();
    try {
      conn.createStatement().execute(
        "UPDATE products SET name = '" +
        name +
        "', quantity = '" +
        quantity +
        "', price = '" +
        price +
        "' WHERE id = '" +
        id +
        "'"
      );
    } catch (Exception e) {
      System.out.println("Operation failed: \n" + e.getMessage());
    }
  }

  @Override
  public void updateProductName(int id, String name) {
    Connection conn = Connector.getConnection();
    try {
      conn.createStatement().execute(
        "UPDATE products SET name = '" +
        name +
        "' WHERE id = '" +
        id +
        "'"
      );
    } catch (Exception e) {
      System.out.println("Operation failed: \n" + e.getMessage());
    }
  }

  @Override
  public void updateProductPrice(int id, int price) {
    Connection conn = Connector.getConnection();
    try {
      conn.createStatement().execute(
        "UPDATE products SET price = '" +
        price +
        "' WHERE id = '" +
        id +
        "'"
      );
    } catch (Exception e) {
      System.out.println("Operation failed: \n" + e.getMessage());
    }
  }

  @Override
  public void updateProductQuantity(int id, int quantity) {
    Connection conn = Connector.getConnection();
    try {
      conn.createStatement().execute(
        "UPDATE products SET quantity = '" +
        quantity +
        "' WHERE id = '" +
        id +
        "'"
      );
    } catch (Exception e) {
      System.out.println("Operation failed: \n" + e.getMessage());
    }
  }
  
}
