package project2;

public class Department {
  public String departmentName;

  Department() {
    departmentName = "not-assigned";
  }
  
  Department(String name) {
    departmentName = name;
  }

  public String getDetails() {
    return "this is demo department....";
  }
}