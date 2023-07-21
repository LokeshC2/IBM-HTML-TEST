package com.example.demo.service;

import java.util.List;

import com.example.demo.CustomerAppException;
import com.example.demo.model.Customer;

public interface CustomerService {
	Customer createCustomer();
	Customer saveCustomer(Customer c) throws CustomerAppException;
	List<Customer> listAllCustomers() throws CustomerAppException;
	Customer getCustomerById(Integer id) throws CustomerAppException;
	void updateCustomer(Customer c) throws CustomerAppException;
	void deleteCustomer(Customer c) throws CustomerAppException;
}
