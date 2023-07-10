package com.example.service;

import com.example.factory.MySessionFactory;
import com.example.models.Address;
import com.example.models.Company;
import com.example.models.Employee;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;

public class EmploymentServiceImpl implements EmploymentService {

  private static Scanner scanner = new Scanner(System.in);

  private Address createAddress() {
    Address address = new Address();
    System.out.println("Enter street: ");
    address.setStreet(scanner.nextLine());
    System.out.println("Enter city: ");
    address.setCity(scanner.nextLine());
    System.out.println("Enter state: ");
    address.setState(scanner.nextLine());
    System.out.println("Enter zip: ");
    address.setZip(scanner.nextLine());
    return address;
  }

  @Override
  public void createCompany() {
    System.out.println("Enter company name: ");
    String name = scanner.nextLine();
    Address address = createAddress();
    Company company = new Company();
    company.setName(name);
    company.setAddress(address);
    MySessionFactory.save(company);
    System.out.println("Company created successfully!");
  }

  @Override
  public void getAllCompanies() {
    List<Company> companies = MySessionFactory.getAll(Company.class);
    for (Company company : companies) {
      System.out.println(company);
    }
  }

  @Override
  public void getCompanyById(int id) {
    Company company = MySessionFactory.getById(Company.class, id);
    System.out.println(company);
  }

  @Override
  public void findCompanyByName(String name) {
    Session session = MySessionFactory.getSessionFactory().openSession();
    List<Company> companies = session
      .createQuery("from Company where name = :name", Company.class)
      .setParameter("name", name)
      .list();
    session.close();
    for (Company company : companies) {
      System.out.println(company);
    }
  }

  @Override
  public void updateCompany(int id) {
    Company company = MySessionFactory.getById(Company.class, id);
    System.out.println("Enter new company name: ");
    String name = scanner.nextLine();
    Address address = createAddress();
    company.setName(name);
    company.setAddress(address);
    MySessionFactory.update(company);
    System.out.println("Company updated successfully!");
  }

  @Override
  public void deleteCompany(int id) {
    Company company = MySessionFactory.getById(Company.class, id);
    MySessionFactory.delete(company);
    System.out.println("Company deleted successfully!");
  }

  @Override
  public void createEmployeeInCompany(int companyId) {
    Employee employee = new Employee();
    System.out.println("Enter employee name: ");
    employee.setName(scanner.nextLine());
    employee.setAddress(createAddress());
    Company company = MySessionFactory.getById(Company.class, companyId);
    employee.setCompany(company);
    company.getEmployees().add(employee);
    MySessionFactory.save(employee);
  }

  @Override
  public void getAllEmployeesInCompany(int companyId) {
    Company company = MySessionFactory.getById(Company.class, companyId);
    for (Employee employee : company.getEmployees()) {
      System.out.println(employee);
    }
  }

  @Override
  public void getEmployeeById(int id) {
    Employee employee = MySessionFactory.getById(Employee.class, id);
    System.out.println(employee);
  }

  @Override
  public void updateEmployee(int id) {
    Employee employee = MySessionFactory.getById(Employee.class, id);
    System.out.println("Enter new employee name: ");
    employee.setName(scanner.nextLine());
    employee.setAddress(createAddress());
    MySessionFactory.update(employee);
    System.out.println("Employee updated successfully!");
  }

  @Override
  public void deleteEmployee(int id) {
    Employee employee = MySessionFactory.getById(Employee.class, id);
    MySessionFactory.delete(employee);
    System.out.println("Employee deleted successfully!");
  }

  @Override
  public void moveEmployeeToCompany(int employeeId, int companyId) {
    Employee employee = MySessionFactory.getById(Employee.class, employeeId);
    Company company = MySessionFactory.getById(Company.class, companyId);
    employee.setCompany(company);
    MySessionFactory.update(employee);
    System.out.println("Employee moved successfully!");
  }

  @Override
  public void findEmployeeByName(String name) {
    Session session = MySessionFactory.getSessionFactory().openSession();
    List<Employee> employees = session
      .createQuery("from Employee where name = :name", Employee.class)
      .setParameter("name", name)
      .list();
    session.close();
    for (Employee employee : employees) {
      System.out.println(employee);
    }
  }
}
