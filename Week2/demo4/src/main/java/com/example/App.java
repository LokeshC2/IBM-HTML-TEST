package com.example;

import com.example.models.*;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

  public static void main(String[] args) {
    first_example(args);
  }

  public static void first_example(String[] args) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Employee.class)
      .addAnnotatedClass(Company.class)
      .buildSessionFactory();

    Company company = new Company();
    company.setName("Company1");
    company.setAddress(new Address("Street1", "City1", "State1", "Zip1"));
  
    Employee employee = new Employee();
    employee.setName("Employee1");
    employee.setAddress(new Address("Street2", "City2", "State2", "Zip2"));
    employee.setCompany(company);

    Employee employee2 = new Employee();
    employee2.setName("Employee2");
    employee2.setAddress(new Address("Street3", "City3", "State3", "Zip3"));
    employee2.setCompany(company);

    Employee employee3 = new Employee();
    employee3.setName("Employee3");
    employee3.setAddress(new Address("Street4", "City4", "State4", "Zip4"));
    employee3.setCompany(company);

    company.setEmployees(List.of(employee, employee2, employee3));

    try (Session session = sessionFactory.openSession()) {
      session.beginTransaction();
      session.save(company);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }

    try (Session session = sessionFactory.openSession()) {
      session.beginTransaction();
      List<Company> companies = session.createQuery("from Company", Company.class).getResultList();
      List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();
      companies.forEach(System.out::println);
      employees.forEach(System.out::println);
      session.getTransaction().commit();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}