package com.example;

import com.example.config.SpringConfig;
import com.example.entity.Product;
import com.example.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

  public static void main(String[] args) {
    ApplicationContext context;
    try {
      context = new AnnotationConfigApplicationContext(
        SpringConfig.class
      );
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
