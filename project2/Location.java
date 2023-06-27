package project2;
import java.util.UUID;

public class Location {
  private String locationId;
  private String locationName;
  private String locationCity;
  private String locationZipCode;


  public String getLocationId() {
    return locationId;
  }

  public String getLocationName() {
    return locationName;
  }

  public void setLocationName(String locationName) {
    this.locationName = locationName;
  }

  public String getLocationCity() {
    return locationCity;
  }

  public void setLocationCity(String locationCity) {
    this.locationCity = locationCity;
  }

  public String getLocationZipCode() {
    return locationZipCode;
  }

  public void setLocationZipCode(String locationZipCode) {
    this.locationZipCode = locationZipCode;
  }

  public Location() {
    locationId = UUID.randomUUID().toString();
  }

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

  @Override
  public String toString() {
    return (
      "Location ID: " + locationId + "\n" +
      "Location Name: " + locationName + "\n" +
      "Location City: " + locationCity + "\n" +
      "Location Zip Code: " + locationZipCode + "\n"
    );
  }
}
