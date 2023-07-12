package org.example.factory;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("carFactory")
public class CarFactory {

  private Connection connection = null;

  private final DataSource dataSource;

  @Autowired
  public CarFactory(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public Connection getConnection() throws SQLException {
    if (connection == null || connection.isClosed()) {
      connection = dataSource.getConnection();
    }
    return connection;
  }
}