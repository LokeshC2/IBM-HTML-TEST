package project3.model;

public class MyDate {
  private int day;
  private int month;
  private int year;

  public MyDate() {
  }

  public MyDate(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public int getDay() {
    return day;
  }

  public void setDay(int day) {
    this.day = day;
  }

  public int getMonth() {
    return month;
  }

  public void setMonth(int month) {
    this.month = month;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof MyDate) {
      MyDate d = (MyDate) obj;
      return this.day == d.day && this.month == d.month && this.year == d.year;
    }
    return false;
  }
}