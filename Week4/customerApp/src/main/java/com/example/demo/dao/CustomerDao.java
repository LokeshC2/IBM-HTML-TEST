package com.example.demo.dao;

import java.sql.SQLException;
import java.util.List;

import com.example.demo.model.Customer;

public interface CustomerDao {

	List<Customer> getAllCustomers() throws SQLException;
	void save(Customer c) throws SQLException;
	Customer findById(Integer id) throws SQLException;
	void delete(Customer c) throws SQLException;
	void update(Customer c) throws SQLException;
}
