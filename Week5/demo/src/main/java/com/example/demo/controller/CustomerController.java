package com.example.demo.controller;

import java.util.Collection;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

  private final CustomerService customerService;

  @GetMapping
  public ResponseEntity<Collection<Customer>> getAllCustomers() {
    return new ResponseEntity<Collection<Customer>>(customerService.getAllCustomers(), HttpStatus.OK);
  }

  @GetMapping("/{uId}")
  public ResponseEntity<Customer> getCustomerByPathId(@PathVariable("uId") Integer userId) {
    Customer customer = customerService.getCustomerById(userId);
    if (customer == null) {
      return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
    } else {
      return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }
  }

  @PostMapping
  public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
    customer = customerService.createCustomer(customer);
    return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
  }

  @PutMapping("/{uId}")
  public ResponseEntity<Customer> updateCustomer(@PathVariable("uId") Integer userId, @RequestBody Customer customer) {
    Customer customer2 = customerService.updateCustomer(userId, customer);
    return new ResponseEntity<Customer>(customer2, HttpStatus.OK);
  }

  @PatchMapping("/{uId}")
  public ResponseEntity<Customer> patchCustomer(@PathVariable("uId") Integer userId, @RequestBody Customer customer) {
    Customer temp = customerService.getCustomerById(userId);
    if (temp == null) {
      return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
    }
    if (customer.getFirstName() != null) {
      temp.setFirstName(customer.getFirstName());
    }
    if (customer.getLastName() != null) {
      temp.setLastName(customer.getLastName());
    }
    if (customer.getEmailId() != null) {
      temp.setEmailId(customer.getEmailId());
    }
    Customer customer2 = customerService.updateCustomer(userId, customer);

    return new ResponseEntity<Customer>(customer2, HttpStatus.OK);
  }

  @DeleteMapping(path="/{uId}", produces=MediaType.TEXT_XML_VALUE)
  public ResponseEntity<Boolean> deleteCustomer(@PathVariable("uId") Integer userId) {
    Boolean deleteSuccess = customerService.deleteCustomer(userId);

    return new ResponseEntity<Boolean>(deleteSuccess, deleteSuccess ? HttpStatus.OK : HttpStatus.NOT_FOUND);
  }
}
