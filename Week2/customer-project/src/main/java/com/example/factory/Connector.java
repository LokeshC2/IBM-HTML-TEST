package com.example.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class Connector {

  private static Connection connection;

  private static Connection newConnection() throws SQLException {
    DriverManager.registerDriver(new Driver());
    connection =
      DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/shop",
        "lox",
        "mysql0"
      );
    return connection;
  }

  public static Connection getConnection() {
    if (connection == null) {
      try {
        connection = newConnection();
      } catch (SQLException e) {
        System.out.println("Error connecting to database: \n" + e.getMessage());
      }
    }
    return connection;
  }
}