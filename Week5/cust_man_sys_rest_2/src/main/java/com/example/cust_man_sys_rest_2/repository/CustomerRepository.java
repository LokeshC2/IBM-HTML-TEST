package com.example.cust_man_sys_rest_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cust_man_sys_rest_2.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
  
}
