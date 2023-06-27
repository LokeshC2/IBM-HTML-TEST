package project4;

public class SpecialCD extends CD {

  private String specialFeature;

  public SpecialCD() {
    super();
  }

  public String getSpecialFeature() {
    return specialFeature;
  }

  public void setSpecialFeature(String specialFeature) {
    this.specialFeature = specialFeature;
  }

  @Override
  public void getCdDetails() {
    super.getCdDetails();
    System.out.println("Special Feature: " + specialFeature);
  }
}
