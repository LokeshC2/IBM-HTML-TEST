package com.example.demo.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.repo.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private CustomerRepository customerRepository;

  @Override
  public Collection<Customer> getAllCustomers() {
    return customerRepository.getAllCustomers();
  }

  @Override
  public Customer getCustomerById(Integer uId) {
    return customerRepository.getCustomerById(uId);
  }

  @Override
  public Customer createCustomer(Customer customer) {
    return customerRepository.createCustomer(customer);
  }

  @Override
  public Customer updateCustomer(Integer userId, Customer customer) {
    return customerRepository.updateCustomer(userId, customer);
  }

  @Override
  public Boolean deleteCustomer(Integer userId) {
    return customerRepository.deleteCustomer(userId);
  }
  
}
