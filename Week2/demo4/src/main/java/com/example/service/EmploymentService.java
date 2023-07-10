package com.example.service;

public interface EmploymentService {
  public void createCompany();

  public void getAllCompanies();

  public void getCompanyById(int id);

  public void findCompanyByName(String name);

  public void updateCompany(int id);

  public void deleteCompany(int id);

  public void createEmployeeInCompany(int companyId);

  public void getAllEmployeesInCompany(int companyId);

  public void getEmployeeById(int id);

  public void updateEmployee(int id);

  public void deleteEmployee(int id);

  public void moveEmployeeToCompany(int employeeId, int companyId);

  public void findEmployeeByName(String name);
}
