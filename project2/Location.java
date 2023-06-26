package project2;
import java.util.UUID;

public class Location {
  private String locationId;
  private String locationName;
  private String locationCity;
  private String locationZipCode;

  public Location(
    String name,
    String city,
    String zipCode
  ) {
    locationId = UUID.randomUUID().toString();
    locationName = name;
    locationCity = city;
    locationZipCode = zipCode;
  }

  public String getDetails() {
    return (
      "Location ID: " +
      locationId +
      " Location Name: " +
      locationName +
      " Location City: " +
      locationCity +
      " Location Zip Code: " +
      locationZipCode
    );
  }
}
