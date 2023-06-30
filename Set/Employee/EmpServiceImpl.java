package Set.Employee;

import java.util.Collection;

public class EmpServiceImpl<T extends Collection<Employee>> implements EmployeeService {

  private T employees;

  public EmpServiceImpl(T employees) {
    this.employees = employees;
  }

  @Override
  public void addEmployee(String id, String firstName, String lastName, String email) {
    Employee emp = new Employee();
    emp.setId(id);
    emp.setFirstName(firstName);
    emp.setLastName(lastName);
    emp.setEmail(email);
    employees.add(emp);
    System.out.println("Added employee " + id );
  }
  
  @Override
  public Employee findEmployee(String id) {
    for (Employee emp : employees) {
      if (emp.getId().equals(id)) return emp;
    }
    System.out.println("Employee " + id + " not found");
    return null;
  }

  @Override
  public void deleteEmployee(String id) {
    Employee emp = findEmployee(id);
    if (emp == null) return;
    employees.remove(emp);
    System.out.println("Deleted employee " + id );
  }

  @Override
  public void updateEmployee(String id, String newFirstName, String newLastName, String newEmail) {
    Employee emp = findEmployee(id);
    if (emp == null) return;
    if (newFirstName != null) emp.setFirstName(newFirstName);
    if (newLastName != null) emp.setLastName(newLastName);
    if (newEmail != null) emp.setEmail(newEmail);
    System.out.println("Updated employee " + id );
  }

  @Override
  public void viewAllEmployees() {
    for (Employee emp : employees) {
      System.out.println(emp);
    }
  }

}
