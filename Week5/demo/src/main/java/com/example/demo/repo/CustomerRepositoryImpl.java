package com.example.demo.repo;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Customer;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

  private final Map<Integer, Customer> customers;

  {
    customers = new HashMap<Integer, Customer>();
  }

  @Override
  public Customer createCustomer(Customer customer) {
    Integer uId = new Random().nextInt(10000);
    customer.setId(uId);
    customers.put(uId, customer);
    return customer;
  }

  @Override
  public Collection<Customer> getAllCustomers() {
    return (Collection<Customer>) customers.values();
  }

  @Override
  public Customer getCustomerById(Integer uId) {
    return customers.get(uId);
  }

  @Override
  public Customer updateCustomer(Integer userId, Customer customer) {
    if (customers.containsKey(userId)) {
      customer.setId(userId);
      customers.put(userId, customer);
      return customer;
    }
    return null;
  }

  @Override
  public Boolean deleteCustomer(Integer userId) {
    if (customers.containsKey(userId)) {
      customers.remove(userId);
      return true;
    }
    return false;
  }
}
