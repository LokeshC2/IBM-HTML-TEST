package com.ibm.dao;

import java.util.List;

import com.ibm.model.Order;
import com.ibm.model.Stock;

public interface OrderDao {

  List<Order> getAllOrders();

  Order createOrder(Integer orderNo, Stock stock, String action, int quantity, Double amount, Double commission,
      Double totalAmount);

}
