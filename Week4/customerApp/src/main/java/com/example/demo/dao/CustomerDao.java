package com.example.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerDao {

	public List<Customer> getAllCustomers();
	
	public void save(Customer c);
	
	public Customer findById(Integer id);
	
	public void delete(Customer c);

}
