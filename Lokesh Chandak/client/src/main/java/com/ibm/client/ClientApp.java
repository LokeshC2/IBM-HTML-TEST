package com.ibm.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.model.Order;
import com.ibm.model.Stock;
import com.ibm.service.InputService;
import com.ibm.service.OrderService;
import com.ibm.service.StockService;

@Component
public class ClientApp {

  @Autowired
  InputService inputService;

  @Autowired
  OrderService orderService;

  @Autowired
  StockService stockService;

  public void showMenu() {
    System.out.println("Welcome to the Stock Trading App");
    System.out.println("1. Create Order");
    System.out.println("2. View Orders");
    System.out.println("3. Exit");
    int choice = inputService.getIntChoice("Enter your choice: ", List.of(1, 2, 3));
    switch (choice) {
      case 1:
        createOrder();
        break;
      case 2:
        viewOrders();
        break;
      case 3:
        System.out.println("Thank you for using the Stock Trading App");
        System.exit(0);
        break;
      default:
        System.out.println("Invalid choice");
        break;
    }
  }

  private void viewOrders() {
    System.out.println("\n\n\nYour orders: ");
    List<Order> orders = orderService.getAllOrders();
    for (Order order : orders) {
      System.out.println(order);
    }
    System.out.println("\n\n\n");
    System.out.println("Press enter to continue");
    inputService.skipLine();
  }

  private void createOrder() {
    System.out.println("\n\n\nAvailable stocks: ");
    List<Stock> stocks = stockService.listAllStocks();
    for (Stock stock : stocks) {
      System.out.println(stock);
    }
    System.out.println("\n\n\n");

    System.out.println("Enter the stock symbol: ");
    List<String> validSymbols = stockService.listAllStockNames();
    String symbol = inputService.getStringChoice("Enter the stock symbol: ", validSymbols); 
    Stock stock = stockService.getStock(symbol);
    
    System.out.println("Choose action [Buy/Sell]: ");
    List <String> validChoices = List.of("Buy", "buy", "B", "b", "Sell", "sell", "S", "s");
    String action = inputService.getStringChoice("Choose action [Buy/Sell]: ", validChoices);

    System.out.println("Enter the quantity: ");
    int quantity = inputService.getPositiveIntChoice("Enter the quantity: ");

    Order order = orderService.placeOrder(stock, action, quantity);
    System.out.println("Order created: " + order);
  }

}
