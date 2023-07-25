package com.example.demo.service;

import java.util.Collection;

import com.example.demo.model.Customer;

public interface CustomerService {

  Collection<Customer> getAllCustomers();
  Customer getCustomerById(Integer uId);
  Customer createCustomer(Customer customer);
  Customer updateCustomer(Integer userId, Customer customer);
  Boolean deleteCustomer(Integer userId);
}
