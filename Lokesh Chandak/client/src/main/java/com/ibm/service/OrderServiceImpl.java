package com.ibm.service;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.dao.OrderDao;
import com.ibm.model.Order;
import com.ibm.model.Stock;

@Component
public class OrderServiceImpl implements OrderService {

  @Autowired
  OrderDao orderDao;

  @Autowired
  Random random;

  @Autowired
  private Map<String, Double> commissionRates;
  
  @Override
  public List<Order> getAllOrders() {
    return orderDao.getAllOrders();
  }

  @Override
  public Order placeOrder(Stock stock, String action, int quantity) {
    Integer orderNo = random.nextInt(100000);

    Double commisionRate;
    if (action.startsWith("B") || action.startsWith("b")) {
      commisionRate = commissionRates.get("buy");
    } else {
      commisionRate = commissionRates.get("sell");
    }

    Double amount = stock.getPrice() * quantity;

    Double commission = amount * commisionRate / 100;

    Double totalAmount = amount + commission;

    return orderDao.createOrder(orderNo, stock, action, quantity, amount, commission, totalAmount);

  }

}
