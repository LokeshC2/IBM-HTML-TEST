package com.example;

import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;

public class App {

  public static void main(String[] args) {
    try {
      DriverManager.registerDriver(new Driver());
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shop", "lox", "mysql0");
      // get all rows from products table
      ResultSet r = connection.createStatement().executeQuery("SELECT * FROM products");
      while (r.next()) {
        System.out.println(r.getString("name") + " " + r.getString("cost"));
      }

      // make statement now insert lots of valuse later
      // PreparedStatement statement = connection.prepareStatement("INSERT INTO products (name, cost) VALUES (?, ?)");
      // // insert 1000 rows
      // for (int i = 0; i < 1000; i++) {
      //   statement.setString(1, "product" + i);
      //   statement.setInt(2, i);
      //   statement.addBatch();
      // }
      // // execute batch
      // statement.executeBatch();
      
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
