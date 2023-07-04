package trycatch.employeeProj;

public interface EmployeeService {
  public void createEmployee(String name, Integer Salary);
  public void listEmployees();
  public void deleteEmployee(Integer ID);
  public void updateEmployee(Integer ID, String name, Integer Salary);
  public void createContractEmployee(String name, Integer salary, Integer duration);
}
