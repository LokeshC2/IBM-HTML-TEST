package com.example.service;

import com.example.Connector;
import com.example.models.Employee;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

  @Override
  public void addEmployee(Employee employee) {
    Connection connection = Connector.getConnection();
    try {
      connection
        .createStatement()
        .execute(
          "INSERT INTO employees (name, position, salary) VALUES ('" +
          employee.getName() +
          "', '" +
          employee.getPosition() +
          "', '" +
          employee.getSalary() +
          "')"
        );
    } catch (SQLException e) {
      System.out.println("Operation failed: \n" + e.getMessage());
    }
  }

  @Override
  public List<Employee> getEmployees() {
    Connection connection = Connector.getConnection();
    ArrayList<Employee> employees = new ArrayList<Employee>();
    try {
      ResultSet resultSet =
        connection.createStatement().executeQuery("SELECT * FROM employees");
      while (resultSet.next()) {
        employees.add(
          new Employee(
            resultSet.getString("name"),
            resultSet.getString("position"),
            resultSet.getString("salary")
          )
        );
      }
    } catch (SQLException e) {
      System.out.println("Operation failed: \n" + e.getMessage());
    }
    return employees;
  }

  @Override
  public List<Employee> findEmployeeByName(String name) {
    Connection connection = Connector.getConnection();
    ArrayList<Employee> employees = new ArrayList<Employee>();
    try {
      ResultSet resultSet =
        connection
          .createStatement()
          .executeQuery(
            "SELECT * FROM employees WHERE name = '?'".replace("?", name)
          );
      while (resultSet.next()) {
        employees.add(
          new Employee(
            resultSet.getString("name"),
            resultSet.getString("position"),
            resultSet.getString("salary")
          )
        );
      }
    } catch (SQLException e) {
      System.out.println("Operation failed: \n" + e.getMessage());
    }
    return employees;
  }
}
