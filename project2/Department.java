package project2;
import java.util.UUID;

public class Department {
  private String departmentId;
  private String departmentName;
  private Location deptLocation;

  public Department(String name, Location location) {
    departmentId = UUID.randomUUID().toString();
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