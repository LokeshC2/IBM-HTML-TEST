package com.ibm.service;

import java.util.List;

import com.ibm.model.Order;
import com.ibm.model.Stock;

public interface OrderService {


  List<Order> getAllOrders();

  Order placeOrder(Stock stock, String action, int quantity);

}
