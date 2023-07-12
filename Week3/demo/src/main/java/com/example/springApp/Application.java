package com.example.springApp;

import com.example.springApp.config.SpringConfig;
import com.example.springApp.model.Department;
import com.example.springApp.model.Employee;
import com.example.springApp.model.Location;
import com.example.springApp.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

  public static void main(String[] args) {
    ApplicationContext context;
    try {
      context = new AnnotationConfigApplicationContext(SpringConfig.class);

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

      {
        Student student = context.getBean("student", Student.class);
        System.out.println(student);

        student.setId(1);
        student.setName("John");
        System.out.println(student);
      }

      Student otherStudent = context.getBean("student", Student.class);
      System.out.println(otherStudent);

      otherStudent.setId(2);
      otherStudent.setName("Jane");

      System.out.println(otherStudent);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
