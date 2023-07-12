package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.ProductDao;
import com.example.entity.Product;

@Component("productService")
public class ProductServiceImpl implements ProductService {
  ProductDao productDao;

  @Autowired
  public ProductServiceImpl(ProductDao productDao) {
    this.productDao = productDao;
  }

  @Override
  public Product createProduct(String name, double price, int quantity) {
    Product product = new Product();
    product.setName(name);
    product.setPrice(price);
    product.setQuantity(quantity);
    return product;
  }

  @Override
  public void saveProduct(Product product) {
    productDao.saveProduct(product);
  }

  @Override
  public List<Product> listProducts() {
    return productDao.listProducts();
  }

}
