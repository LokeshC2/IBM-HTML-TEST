package com.example;

import com.example.models.*;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

  public static void main(String[] args) {
    // CD_example(args);
    Order_example(args);
    // Department_example(args);
  }

  public static void CD_example(String[] args) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(CD.class)
      .addAnnotatedClass(InternationalCD.class)
      .addAnnotatedClass(SpecialCD.class)
      .buildSessionFactory();

    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.save(new CD("CD1"));
    session.save(new InternationalCD("CD2", "English"));
    session.save(new SpecialCD("CD3", "Special Feature"));
    session.getTransaction().commit();
    session.close();

    session = sessionFactory.openSession();
    session.beginTransaction();
    List<CD> cds = session.createQuery("from CD", CD.class).getResultList();
    session.getTransaction().commit();
    session.close();

    for (CD cd : cds) {
      System.out.println(cd);
    }
  }

  public static void Order_example(String[] args) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Order.class)
      .addAnnotatedClass(Shipment.class)
      .buildSessionFactory();

    Order order = new Order();
    order.setOrderName("Order1");

    Shipment shipment = new Shipment();
    shipment.setCity_name("City1");
    shipment.setZip_code("Zip1");
    shipment.setOrder(order);

    order.setShipment(shipment);

    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.persist(order);
    session.getTransaction().commit();
    session.close();

    session = sessionFactory.openSession();
    session.beginTransaction();
    List<Order> orders = session.createQuery("from Order", Order.class).getResultList();
    List<Shipment> shipments = session.createQuery("from Shipment", Shipment.class).getResultList();
    session.getTransaction().commit();
    session.close();

    for (Order o : orders) {
      System.out.println(o);
    }

    for (Shipment s : shipments) {
      System.out.println(s);
    }
  }

  private static void Department_example(String[] args) {
    SessionFactory sessionFactory = new Configuration()
      .configure("hibernate.cfg.xml")
      .addAnnotatedClass(Department.class)
      .addAnnotatedClass(Employee.class)
      .buildSessionFactory();

    Department department = new Department();
    department.setDepartmentName("Department1");

    Employee employee = new Employee();
    employee.setEmployeeName("Employee1");

    department.addEmployee(employee);

    Session session = sessionFactory.openSession();
    session.beginTransaction();
    session.persist(department);
    session.getTransaction().commit();
    session.close();

    session = sessionFactory.openSession();
    session.beginTransaction();
    List<Department> departments = session.createQuery("from Department", Department.class).getResultList();
    List<Employee> employees = session.createQuery("from Employee", Employee.class).getResultList();
    session.getTransaction().commit();
    session.close();

    departments.forEach(System.out::println);
    employees.forEach(System.out::println);
  }
}
