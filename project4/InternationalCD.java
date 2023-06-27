package project4;

public class InternationalCD extends CD {
  private String language;

  public String getLanguage() {
    return language;
  }
  
  public void setLanguage(String language) {
    this.language = language;
  }

  public InternationalCD() {
    super();
  }

  @Override
  public void getCdDetails() {
    super.getCdDetails();
    System.out.println("Language: " + language);
  }
}
