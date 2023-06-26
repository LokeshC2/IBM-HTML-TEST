package project2;

public class Department {
  private String departmentId;
  private String departmentName;
  private Location deptLocation;

  public void createDepartment(String id, String name, Location location) {
    departmentId = id;
    departmentName = name;
    deptLocation = location;
  }

  public String getDetails() {
    return (
      "Department ID: " +
      departmentId +
      " Department Name: " +
      departmentName +
      " Department Location: " +
      deptLocation.getDetails()
    );
  }
}