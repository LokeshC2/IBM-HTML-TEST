package com.example.service;

import com.example.Connector;
import com.example.models.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService {

  public void printResult(ResultSet rs) throws SQLException {
    while (rs.next()) System.out.println(
      new Customer(
        rs.getInt("id"),
        rs.getString("fname"),
        rs.getString("lname"),
        rs.getString("email")
      )
    );
  }

  @Override
  public void addCustomer(String fname, String lname, String email) {
    Connection connection = Connector.getConnection();
    String sql = "INSERT INTO customers (fname, lname, email) VALUES (?, ?, ?)";
    try {
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setString(1, fname);
      ps.setString(2, lname);
      ps.setString(3, email);
      ps.executeUpdate();
      System.out.println("Customer added successfully");
    } catch (SQLException e) {
      System.out.println("Error adding customer: \n" + e.getMessage());
    }
  }

  @Override
  public void deleteCustomer(int id) {
    Connection connection = Connector.getConnection();
    String sql = "DELETE FROM customers WHERE id = ?";
    try {
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setInt(1, id);
      ps.executeUpdate();
      System.out.println("Customer deleted successfully");
    } catch (SQLException e) {
      System.out.println("Error deleting customer: \n" + e.getMessage());
    }
  }

  @Override
  public void getAllCustomers() {
    Connection connection = Connector.getConnection();
    String sql = "SELECT * FROM customers";
    ResultSet rs = null;
    try {
      PreparedStatement ps = connection.prepareStatement(sql);
      rs = ps.executeQuery();
      printResult(rs);
    } catch (SQLException e) {
      System.out.println("Error fetching customers: \n" + e.getMessage());
    }
  }

  @Override
  public void getCustomer(int id) {
    Connection connection = Connector.getConnection();
    String sql = "SELECT * FROM customers WHERE id = ?";
    ResultSet rs = null;
    try {
      connection.createStatement().executeQuery(sql);
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setInt(1, id);
      rs = ps.executeQuery();
      printResult(rs);
    } catch (SQLException e) {
      System.out.println("Error fetching customer: \n" + e.getMessage());
    }
  }

  @Override
  public void getCustomersByFname(String fname) {
    Connection connection = Connector.getConnection();
    String sql = "SELECT * FROM customers WHERE fname = ?";
    ResultSet rs = null;
    try {
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setString(1, fname);
      rs = ps.executeQuery();
      while (rs.next()) System.out.println(
        new Customer(
          rs.getInt("id"),
          rs.getString("fname"),
          rs.getString("lname"),
          rs.getString("email")
        )
      );
    } catch (SQLException e) {
      System.out.println("Error fetching customers: \n" + e.getMessage());
    }

  }

  @Override
  public void updateCustomer(int id, String fname, String lname, String email) {
    Connection connection = Connector.getConnection();
    String sql = "UPDATE customers SET fname = ?, lname = ?, email = ? WHERE id = ?";
    try {
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.setString(1, fname);
      ps.setString(2, lname);
      ps.setString(3, email);
      ps.setInt(4, id);
      ps.executeUpdate();
      System.out.println("Customer updated successfully");
    } catch (SQLException e) {
      System.out.println("Error saving customer: \n" + e.getMessage());
    }
  }

  @Override
  public void deleteAllCustomers() {
    Connection connection = Connector.getConnection();
    String sql = "DELETE FROM customers";
    try {
      PreparedStatement ps = connection.prepareStatement(sql);
      ps.executeUpdate();
      System.out.println("All customers deleted successfully");
    } catch (SQLException e) {
      System.out.println("Error deleting customers: \n" + e.getMessage());
    }
  }
}
