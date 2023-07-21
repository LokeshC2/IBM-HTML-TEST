package com.example.demo.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.CustomerAppException;
import com.example.demo.dao.CustomerDao;
import com.example.demo.factory.CustomerFactory;
import com.example.demo.model.Customer;

@Service
public class CutomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Autowired
	CustomerFactory customerFactory;

	@Override
	public Customer createCustomer() {
		return customerFactory.createCustomer();
	}

	@Override
	public Customer saveCustomer(Customer c) throws CustomerAppException {
		String firstname = c.getFirstname();
		String lastname = c.getLastname();
		String emailID = c.getEmail();
		if (firstname == null || firstname.isBlank()) {throw new CustomerAppException("Firstname is blank");}
		if (lastname == null || lastname.isBlank()) {throw new CustomerAppException("Lastname is blank");}
		if (emailID == null || emailID.isBlank()) {throw new CustomerAppException("EmailID is blank");}
		try {
			customerDao.save(c);
			return c;
		} catch (SQLException e) {
			throw new CustomerAppException("Error saving customer", e);
		}
	}

	

	@Override
	public List<Customer> listAllCustomers() throws CustomerAppException {
		try {
			return customerDao.getAllCustomers();
		} catch (SQLException e) {
			throw new CustomerAppException("Error listing customers", e);
		}
	}

	@Override
	public Customer getCustomerById(Integer id) throws CustomerAppException {
		try {
			return customerDao.findById(id);
		} catch (SQLException e) {
			throw new CustomerAppException("Error getting customer", e);
		}
	}

	@Override
	public void updateCustomer(Customer c) throws CustomerAppException {
		try {
			customerDao.update(c);
		} catch (SQLException e) {
			throw new CustomerAppException("Error updating customer", e);
		}
	}

	@Override
	public void deleteCustomer(Customer c) throws CustomerAppException {
		try {
			customerDao.delete(c);
		} catch (SQLException e) {
			throw new CustomerAppException("Error deleting customer", e);
		}
	}

}
