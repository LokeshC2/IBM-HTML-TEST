package Collection.Employee;

public class Employee {

  private String id;
  private String firstName;
  private String lastName;
  private String email;

  Employee() {}

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return (
      "Employee [id=" +
      id +
      ", firstName=" +
      firstName +
      ", lastName=" +
      lastName +
      ", email=" +
      email +
      "]"
    );
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) return false;
    if (!(obj instanceof Employee)) return false;
    if (obj == this) return true;

    Employee employee = (Employee) obj;
    return (
      employee.getId().equals(id) &&
      employee.getFirstName().equals(firstName) &&
      employee.getLastName().equals(lastName) &&
      employee.getEmail().equals(email)
    );
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

}
