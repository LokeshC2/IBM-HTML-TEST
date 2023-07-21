package com.example.demo.factory;

import org.springframework.stereotype.Component;

import com.example.demo.model.Customer;

@Component
public class CustomerFactory {

  public Customer createCustomer() {
    return new Customer();
  }

  public Customer createCustomer(String firstname, String lastname, String emailID) {
    Customer c = new Customer();
    c.setFirstname(firstname);
    c.setLastname(lastname);
    c.setEmail(emailID);
    return c;
  }

}
