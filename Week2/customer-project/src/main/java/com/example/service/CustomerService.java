package com.example.service;

public interface CustomerService {
  public void addCustomer(String fname, String lname, String email);
  public void updateCustomer(int id, String fname, String lname, String email);
  public void deleteCustomer(int id);
  public void getCustomer(int id);
  public void getAllCustomers();
  public void getCustomersByFname(String fname);
  public void deleteAllCustomers();
}