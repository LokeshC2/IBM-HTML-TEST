// Q.1 Write method of date class to support the following:-
//     a.Method for validating that the integer-representing month is between 1 & 12 and checking
//       that the day part of the date objects is within the correct range for a month.
//     b.Obtaining the next day from a given date.

package Assignment;

import java.util.Scanner;

public class Q1 {

  public static void main(String[] args) {
    Q1 q1 = new Q1();
    Scanner sc = new Scanner(System.in);
    Date date;
    do {
      System.out.println("Enter day: ");
      int day = sc.nextInt();
      System.out.println("Enter month: ");
      int month = sc.nextInt();
      System.out.println("Enter year: ");
      int year = sc.nextInt();
      date = q1.new Date(day, month, year);
      if (date.validateDate()) {
        date.printDate();
        break;
      } else {
        System.out.println("Invalid date, please try again.");
      }
    } while (true);
    date.printDate();
    date.nextDay();
    date.printDate();
    date.nextDay();
    date.printDate();
    sc.close();
  }

  public class Date {

    private int day;
    private int month;
    private int year;

    private int[] daysInMonth = {
      31,
      28,
      31,
      30,
      31,
      30,
      31,
      31,
      30,
      31,
      30,
      31,
    };

    Date(int day, int month, int year) {
      this.day = day;
      this.month = month;
      this.year = year;
      if (checkLeap(this.year)) {
        this.daysInMonth[1] = 29;
      }
    }

    public Boolean validateDate() {
      if (this.month < 1 || this.month > 12) {
        return false;
      }
      if (this.day < 1 || this.day > this.daysInMonth[this.month - 1]) {
        return false;
      }
      return true;
    }

    public void nextDay() {
      if (this.day == daysInMonth[this.month - 1]) {
        this.day = 1;
        if (this.month == 12) {
          this.month = 1;
          this.year++;
        } else {
          this.month++;
        }
      } else {
        this.day++;
      }
    }

    public void printDate() {
      System.out.println(this.day + "/" + this.month + "/" + this.year);
    }
  }

  static Boolean checkLeap(int year) {
    if (year % 4 == 0) {
      if (year % 100 == 0) {
        if (year % 400 == 0) {
          return true;
        } else {
          return false;
        }
      } else {
        return true;
      }
    } else {
      return false;
    }
  }

}
