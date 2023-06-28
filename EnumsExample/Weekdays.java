package EnumsExample;

public enum Weekdays {
  Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;

  private int dayNumber;

  Weekdays() {
    this.dayNumber = ordinal() + 1;
  }

  public int getDayNumber() {
    return dayNumber;
  }
}
