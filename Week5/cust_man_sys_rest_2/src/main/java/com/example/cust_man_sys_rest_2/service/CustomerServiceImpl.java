package com.example.cust_man_sys_rest_2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.cust_man_sys_rest_2.exceptions.NotFoundException;
import com.example.cust_man_sys_rest_2.model.Customer;
import com.example.cust_man_sys_rest_2.model.Employee;
import com.example.cust_man_sys_rest_2.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  private final CustomerRepository customerRepository;

  @Override
  public List<Customer> getAll() {
    return customerRepository.findAll();
  }

  @Override
  public Customer findById(Integer id) {
    Optional<Customer> c = customerRepository.findById(id);
    if (c.isEmpty()) {
      throw new NotFoundException("Customer not found");
    }
    return c.get();
  }

  @Override
  public Customer save(Customer customer) {
    return customerRepository.save(customer);
  }

  @Override
  public Optional<Customer> addRM(Integer customerId, Employee employee) {
    Optional<Customer> oCustomer = customerRepository.findById(customerId);
    if (oCustomer.isEmpty()) {
      return Optional.empty();
    }
    Customer customer = oCustomer.get();
    customer.setRelationshipManager(employee);
    customer = customerRepository.save(customer);
    return Optional.of(customer);
  }

  @Override
  public Optional<Customer> updateCustomer(Integer id, Customer newCustomer) {
    if (!customerRepository.existsById(id)) {
      return Optional.of(null);
    }
    Customer customer = customerRepository.findById(id).get();

    if (Optional.of(newCustomer.getFirstName()).isPresent()) {
      customer.setFirstName(newCustomer.getFirstName());
    }

    if (Optional.of(newCustomer.getLastName()).isPresent()) {
      customer.setLastName(customer.getLastName());
    }

    if (Optional.of(newCustomer.getEmail()).isPresent()) {
      customer.setEmail(newCustomer.getEmail());
    }

    customerRepository.flush();

    return Optional.of(customer);
  }
}