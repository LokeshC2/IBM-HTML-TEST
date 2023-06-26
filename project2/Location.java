package project2;

public class Location {
  private String locationId;
  private String locationName;
  private String locationCity;
  private String locationZipCode;

  public Location(
    String id,
    String name,
    String city,
    String zipCode
  ) {
    locationId = id;
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
