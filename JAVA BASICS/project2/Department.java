package project2;
import java.util.UUID;

public class Department {
  private String departmentId;
  private String departmentName;
  private Location deptLocation;

  public String getDepartmentId() {
    return departmentId;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public Location getDeptLocation() {
    return deptLocation;
  }

  public void setDeptLocation(Location deptLocation) {
    this.deptLocation = deptLocation;
  }

  public Department() {
    departmentId = UUID.randomUUID().toString();
  }

  public Department(String name, Location location) {
    departmentId = UUID.randomUUID().toString();
    departmentName = name;
    deptLocation = location;
  }

  @Override
  public String toString() {
    return (
      "Department ID: " + departmentId + "\n" +
      "Department Name: " + departmentName + "\n" +
      "Department Location: \n" + deptLocation
    );
  }
}