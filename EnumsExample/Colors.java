package EnumsExample;

public enum Colors {

  Red(255, 0, 0),
  Green(0, 255, 0),
  Blue(0, 0, 255),
  Black(0, 0, 0),
  White(255, 255, 255);

  private int r;
  private int g;
  private int b;

  Colors(int r, int g, int b) {
    this.r = r;
    this.g = g;
    this.b = b;
  }

  public int getR() {
    return r;
  }

  public int getG() {
    return g;
  }

  public int getB() {
    return b;
  }

  @Override
  public String toString() {
    return "Color #" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
  }
  
}
