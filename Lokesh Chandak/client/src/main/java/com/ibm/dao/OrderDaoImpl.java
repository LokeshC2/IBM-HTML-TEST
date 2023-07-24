package com.ibm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.model.Order;
import com.ibm.model.Stock;

@Component
public class OrderDaoImpl implements OrderDao {

  @Autowired
  SessionFactory sessionFactory;

  @Override
  public List<Order> getAllOrders() {
    Session session = sessionFactory.openSession();
    List<Order> orders = session.createQuery("from Order", Order.class).list();
    session.close();
    return orders;
  }

  @Override
  public Order createOrder(Integer orderNo, Stock stock, String action, int quantity, Double amount, Double commission,
      Double totalAmount) {
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    Order order = new Order(orderNo, stock, action, quantity, amount, commission, totalAmount);
    session.save(order);
    session.getTransaction().commit();
    session.close();
    return order;
  }
  
}
