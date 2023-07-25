package com.example.demo.repo;

import com.example.demo.model.Customer;
import java.util.Collection;

public interface CustomerRepository {
  
  Customer createCustomer(Customer c);

  Collection<Customer> getAllCustomers();

  Customer getCustomerById(Integer uId);

  Customer updateCustomer(Integer userId, Customer customer);

  Boolean deleteCustomer(Integer userId);

}
