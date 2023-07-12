package com.example.dao;

import java.util.List;

import com.example.entity.Product;

public interface ProductDao {

  void saveProduct(Product product);

  List<Product> listProducts();

}