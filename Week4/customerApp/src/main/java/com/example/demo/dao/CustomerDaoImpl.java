package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.model.Customer;

@Repository
@EnableTransactionManagement
public class CustomerDaoImpl implements CustomerDao {

	private EntityManager entityManager;

	@Override
	public List<Customer> getAllCustomers() {
		return entityManager.createQuery("FROM Customer C", Customer.class).getResultList();
	}

	@Override
	public void save(Customer c) {
		entityManager.persist(c);
	}

	@Override
	public Customer findById(Integer id) {
		return entityManager.find(Customer.class, id);
	}

	@Override
	public void delete(Customer c) {
		entityManager.remove(c);
	}

}
