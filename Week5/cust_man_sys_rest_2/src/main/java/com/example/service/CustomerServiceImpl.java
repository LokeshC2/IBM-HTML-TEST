package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.model.Customer;
import com.example.model.Employee;
import com.example.repository.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

  CustomerRepository customerRepository;

  @Override
  public List<Customer> getAll() {
    return customerRepository.findAll();
  }

  @Override
  public Optional<Customer> findById(Integer id) {
    return customerRepository.findById(id);
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