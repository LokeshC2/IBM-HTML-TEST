package com.example.cust_man_sys_rest_2.service;

import java.util.List;
import java.util.Optional;

import com.example.cust_man_sys_rest_2.model.Customer;
import com.example.cust_man_sys_rest_2.model.Employee;

public interface CustomerService {

  List<Customer> getAll();

  Customer save(Customer customer);

  Optional<Customer> addRM(Integer id, Employee rm);

  Optional<Customer> updateCustomer(Integer id, Customer newCustomer);

  Customer findById(Integer id);
}
