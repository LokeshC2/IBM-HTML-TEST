package com.example.service;

import java.util.List;

import com.example.entity.Product;

public interface ProductService {

  Product createProduct(String name, double price, int quantity);

  void saveProduct(Product product);

  List<Product> listProducts();

}