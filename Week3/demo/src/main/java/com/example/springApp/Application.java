package com.example.springApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.springApp.model.Department;
import com.example.springApp.model.Employee;
import com.example.springApp.model.Location;

public class Application {

  public static void main(String[] args) {

    ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    
    Employee employee = context.getBean("employee", Employee.class);
    
    System.out.println(employee);

    employee.setId(1);
    employee.setName("John");
    
    Department department = employee.getDepartment();
    department.setSymbol('A');
    department.setName("Aeronautics");
    
    Location location = department.getLocation();
    location.setCity("Bangalore");
    location.setState("Karnataka");
    location.setCountry("India");

    System.out.println(employee);
  }
}
