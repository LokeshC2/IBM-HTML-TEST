package Set.Employee;

public interface EmployeeService {

  public void addEmployee(String id, String firstName, String lastName, String email);

  public void deleteEmployee(String id);

  public Employee findEmployee(String id);

  public void updateEmployee(String id, String newFirstName, String newLastName, String newEmail);
  
  public void viewAllEmployees();
}
