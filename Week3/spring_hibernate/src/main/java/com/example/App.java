package com.example;

import com.example.config.SpringConfig;
import com.example.entity.Product;
import com.example.service.CarService;
import com.example.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

  public static void main(String[] args) {
    // ProductExample(args);
    CarExample(args);
  }

  public static void CarExample(String[] args) {
    ApplicationContext context;
    try {
      context = new AnnotationConfigApplicationContext(SpringConfig.class);
      CarService carService = context.getBean("carService", CarService.class);
      carService.createCar("BMW", "Black");
      carService.createCar("Audi", "White");
      carService.createCar("Mercedes", "Red");
      carService.listCars();
      carService.findCarById(2);
      carService.updateCar(2, "Audi", "OceanBlue");
      carService.deleteCar(3);
      carService.listCars();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

  public static void ProductExample(String[] args) {
    ApplicationContext context;
    try {
      context = new AnnotationConfigApplicationContext(SpringConfig.class);
      ProductService productService = context.getBean(
        "productService",
        ProductService.class
      );
      Product product = productService.createProduct("Laptop", 1000, 10);
      System.out.println(product);
      productService.saveProduct(product);
      System.out.println(productService.listProducts());
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
