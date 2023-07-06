package com.example.service;

import com.example.Connector;
import com.example.models.Order;
import com.example.models.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Store implements Inventory {

  @Override
  public void addProduct(Product product) {
    Connection connection = Connector.getConnection();
    try {
      connection
        .createStatement()
        .execute(
          "INSERT INTO products (name, cost, quantity) VALUES ('" +
          product.getName() +
          "', '" +
          product.getCost() +
          "', '" +
          product.getQuantity() +
          "')"
        );
    } catch (Exception e) {
      System.out.println("Operation failed: \n" + e.getMessage());
    }
  }

  @Override
  public void deleteProduct(int id) {
    Connection connection = Connector.getConnection();
    try {
      connection
        .createStatement()
        .execute("DELETE FROM products WHERE id = " + id);
    } catch (Exception e) {
      System.out.println("Operation failed: \n" + e.getMessage());
    }
  }

  @Override
  public List<Product> findProductByName(String name) {
    Connection connection = Connector.getConnection();
    ArrayList<Product> products = new ArrayList<Product>();
    try {
      ResultSet resultSet = connection
        .createStatement()
        .executeQuery(
          "SELECT * FROM products WHERE name LIKE '%" + name + "%'"
        );
      while (resultSet.next()) {
        products.add(
          new Product(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getInt("cost"),
            resultSet.getInt("quantity")
          )
        );
      }
    } catch (Exception e) {
      System.out.println("Operation failed: \n" + e.getMessage());
    }
    return products;
  }

  @Override
  public List<Product> getAllProduct() {
    Connection connection = Connector.getConnection();
    ArrayList<Product> products = new ArrayList<Product>();
    try {
      ResultSet resultSet = connection
        .createStatement()
        .executeQuery("SELECT * FROM products");
      while (resultSet.next()) {
        products.add(
          new Product(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getInt("cost"),
            resultSet.getInt("quantity")
          )
        );
      }
    } catch (Exception e) {
      System.out.println("Operation failed: \n" + e.getMessage());
    }
    return products;
  }

  @Override
  public Order sellProduct(int id, int quantity) {
    Product product = findProductById(id);
    if (product.getQuantity() < quantity) {
      System.out.println("Not enough product in stock");
      return null;
    }

    int totalCost = product.getCost() * quantity;
    System.out.println(
      "Total cost of " + quantity + " " + product.getName() + " is " + totalCost
    );

    updateProductQuantity(id, product.getQuantity() - quantity);

    Connection connection = Connector.getConnection();
    try {
      PreparedStatement p = connection.prepareStatement(
        "INSERT INTO orders (product_id, quantity, total_cost) VALUES (?, ?, ?)",
        Statement.RETURN_GENERATED_KEYS
      );
      p.setInt(1, id);
      p.setInt(2, quantity);
      p.setInt(3, totalCost);
      p.executeUpdate();
      ResultSet resultSet = p.getGeneratedKeys();
      if (resultSet.next()) {
        return new Order(resultSet.getInt(1), id, quantity, totalCost);
      }
    } catch (Exception e) {
      System.out.println("Operation failed: \n" + e.getMessage());
    }
    return null;
  }

  private Product findProductById(int id) {
    Connection connection = Connector.getConnection();
    Product product = null;
    try {
      ResultSet resultSet = connection
        .createStatement()
        .executeQuery("SELECT * FROM products WHERE id = '" + id + "'");
      while (resultSet.next()) {
        product =
          new Product(
            resultSet.getInt("id"),
            resultSet.getString("name"),
            resultSet.getInt("cost"),
            resultSet.getInt("quantity")
          );
      }
    } catch (Exception e) {
      System.out.println("Operation failed: \n" + e.getMessage());
    }
    return product;
  }

  @Override
  public void updateProductPrice(int id, int price) {
    Connection connection = Connector.getConnection();
    try {
      connection
        .createStatement()
        .execute(
          "UPDATE products SET cost = '" + price + "' WHERE id = '" + id + "'"
        );
    } catch (Exception e) {
      System.out.println("Operation failed: \n" + e.getMessage());
    }
  }

  @Override
  public void updateProductQuantity(int id, int quantity) {
    Connection connection = Connector.getConnection();
    try {
      connection
        .createStatement()
        .execute(
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
