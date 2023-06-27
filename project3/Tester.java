package project3;

import java.util.Scanner;

// import project3.model.Employee;
import project3.model.StreamedStudent;
import project3.model.Student;
// import project3.model.TaxCalculator;
// import project3.model.Manager;
// import project3.model.RegularEmployee;

public class Tester {
  public static void main(String[] args) {
    // Scanner input = new Scanner(System.in);

    // StreamedStudent student = new StreamedStudent();
    // System.out.println("Enter student ID:");
    // student.setId(input.nextInt());
    // System.out.println("Enter student name:");
    // student.setName(input.next());
    // System.out.println("Enter student stream:");
    // student.setStream(input.next());
    
    // RegularEmployee employee = new RegularEmployee();
    // System.out.println("Enter employee ID:");
    // employee.setId(input.nextInt());
    // System.out.println("Enter employee name:");
    // employee.setName(input.next());
    // System.out.println("Enter employee salary:");
    // employee.setSalary(input.nextInt());

    // System.out.println("Student details:");
    // student.getDetails();
    // System.out.println("Employee details:");
    // employee.getDetails();

    // Manager e = new Manager();
    // e.setId(1);
    // e.setName("John");
    // e.getDetails();
  
    // Employee e2 = new RegularEmployee();
    // e2.setId(3);
    // e2.setName("Jane");
    // e2.getDetails();

    // TaxCalculator taxCalculator = new TaxCalculator();
    // taxCalculator.calculateTax(e2);

    // input.close();

    Student s2 = new StreamedStudent();
    s2.setId(1);
    s2.setName("John");
    s2.getDetails();
    
    StreamedStudent s3 = (StreamedStudent) s2;
    s3.setStream("Maths", "Science", "English");
    s3.getDetails();

    Student[] students = s3.createStudents("John", "Jane", "Jack");
    for (Student s : students) {
      s.getDetails();
    }
  }
}