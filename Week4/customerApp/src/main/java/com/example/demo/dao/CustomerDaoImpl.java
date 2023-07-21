package com.example.demo.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.model.Customer;

@Repository
@EnableTransactionManagement
public class CustomerDaoImpl implements CustomerDao {

	private EntityManager entityManager;

	@Override
	@Transactional
	public List<Customer> getAllCustomers() throws SQLException {
		TypedQuery<Customer> query = entityManager.createQuery("FROM Customer C", Customer.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void save(Customer c) throws SQLException{
		entityManager.persist(c);
	}

	@Override
	@Transactional
	public Customer findById(Integer id) throws SQLException{
		return entityManager.find(Customer.class, id);
	}

	@Override
	@Transactional
	public void update(Customer c) throws SQLException{
		entityManager.merge(c);
	}

	@Override
	@Transactional
	public void delete(Customer c) throws SQLException{
		entityManager.remove(c);
	}

}
