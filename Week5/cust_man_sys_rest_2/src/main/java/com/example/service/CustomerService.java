package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Customer;
import com.example.model.Employee;

public interface CustomerService {

  List<Customer> getAll();

  Optional<Customer> findById(Integer id);

  Customer save(Customer customer);

  Optional<Customer> addRM(Integer id, Employee rm);

  Optional<Customer> updateCustomer(Integer id, Customer newCustomer);

}
