package AbstractClasses;
import AbstractClasses.Employee.EmployeeService;
import AbstractClasses.Employee.EmployeeServiceImpl;

public class Tester {
  public static void main(String[] args) {
    EmployeeService employeeService = new EmployeeServiceImpl();
    employeeService.createEmployee("John", "Doe", "john.doe@abc", 1000);
    employeeService.displayAllEmployees();
    employeeService.updateEmployeeByid("1");
    employeeService.displayAllEmployees();
    employeeService.deleteEmployeeById("1");
    employeeService.displayAllEmployees();
    
  }
}
