package AbstractClasses.Employee;

// public abstract class EmployeeService {
public interface EmployeeService {

  abstract public Employee createEmployee(
    String firstName,
    String lastname,
    String email,
    int salary
  );

  abstract public void displayAllEmployees();

  abstract public Boolean deleteEmployeeById(String id);

  abstract public Boolean updateEmployeeByid(String id);

}