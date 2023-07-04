package project4;

public class CD {

  private int id;
  private String name;
  private double price;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public CD() {}

  public void getCdDetails() {
    System.out.println("CD ID: " + id);
    System.out.println("CD Name: " + name);
    System.out.println("CD Price: " + price);
  }
}
