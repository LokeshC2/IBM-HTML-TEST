package com.example.cust_man_sys_rest_2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cust_man_sys_rest_2.model.Customer;
import com.example.cust_man_sys_rest_2.model.Employee;
import com.example.cust_man_sys_rest_2.service.CustomerService;

import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

  private CustomerService customerService;

  @GetMapping
  public ResponseEntity<List<Customer>> listAll() {
    return new ResponseEntity<List<Customer>>(customerService.getAll(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Customer> findById(@PathVariable("id") Integer id) {
    return new ResponseEntity<Customer>(customerService.findById(id), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
    return new ResponseEntity<Customer>(customerService.save(customer), HttpStatus.OK);
  }

  @PostMapping("/{id}/RM")
  public ResponseEntity<Customer> addRM(@PathVariable("id") Integer id, @RequestBody Employee employee) {
    Optional<Customer> oCustomer = customerService.addRM(id, employee);
    if (oCustomer.isEmpty()) {
      return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Customer>(oCustomer.get(), HttpStatus.OK);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Customer> updateCustomer (@PathVariable Integer id, @RequestBody Customer newCustomer) {
    Optional<Customer> oCustomer = customerService.updateCustomer(id, newCustomer);
    if (oCustomer.isEmpty()) {
      return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<Customer>(oCustomer.get(), HttpStatus.OK);
  }
}
