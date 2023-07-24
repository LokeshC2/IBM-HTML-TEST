package com.ibm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ibm.client.ClientApp;
import com.ibm.config.AppConfig;
import com.ibm.service.StockService;

public class App {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    StockService stockService = context.getBean(StockService.class);

    stockService.createStock("LNT", 1451.50);
    stockService.createStock("Reliance", 923.90);
    stockService.createStock("TataSteel", 435.60);

    ClientApp client = context.getBean(ClientApp.class);

    client.showMenu();
  }

}
