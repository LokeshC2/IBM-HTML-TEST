// Q.4 Define a “Clock” class that does the following: -
//     a. Accept hours, minutes and seconds.
//     b. Check the validity numbers.
//     c. Set the time to AM/PM mode.
//   Use necessary constructors and methods to do the above task.

package Assignment;

public class Q4 {
  public static void main(String[] args) 
  {
    Q4 q4 = new Q4();
    Clock clock = q4.new Clock();
    clock.setHours(12);
    clock.setMinutes(30);
    clock.setSeconds(45);
    clock.getTime24hr();
    clock.getTime12hr();
  }

  public class Clock {
    private int hours;
    private int minutes;
    private int seconds;
    private boolean isAM;

    Clock() {
      this.hours = 0;
      this.minutes = 0;
      this.seconds = 0;
      this.isAM = true;
    }

    public int getHours() {
      return hours;
    }

    public int getMinutes() {
      return minutes;
    }
    
    public int getSeconds() {
      return seconds;
    }

    public boolean isAM() {
      return isAM;
    }

    public void setHours(int hours) {
      if (0 <= hours && hours <= 23) this.hours = hours;
      else {
        System.out.println("Invalid hours.");
        return;
      }
      if (hours >= 12) {
        this.isAM = false;
      }
    }

    public void setMinutes(int minutes) {
      if (0 <= minutes && minutes <= 59) this.minutes = minutes;
      else System.out.println("Invalid minutes.");
    }

    public void setSeconds(int seconds) {
      if (0 <= seconds && seconds <= 59) this.seconds = seconds;
      else System.out.println("Invalid seconds.");
    }

    public void getTime24hr() {
      System.out.println(this.hours + ":" + this.minutes + ":" + this.seconds);
    }

    public void getTime12hr() {
      if (this.isAM) {
        System.out.println(this.hours + ":" + this.minutes + ":" + this.seconds + " AM");
      } else {
        System.out.println((this.hours - 12 | 12) + ":" + this.minutes + ":" + this.seconds + " PM");
      }
    }
  }
}
