package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerServiceInterface {
	public Customer createCustomer(String firstname, String lastname, String emailID);
	public List<Customer> listAllCustomers();
}
