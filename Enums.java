public class Enums {

  public enum Day {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
  }

  public static void main(String[] args) {
    Enums enums = new Enums();
    Meeting meeting = enums.new Meeting(Day.MONDAY, 10, 12);
    System.out.println(meeting.getDay());
    System.out.println(meeting.getStartTime());
    System.out.println(meeting.getEndTime());

    meeting.setDay(Day.TUESDAY);
    meeting.setStartTime(11);
    System.out.println(meeting.getDay());

  }

  public class Meeting {
    private Day day;
    private int startTime;
    private int endTime;

    Meeting() {}

    Meeting(Day day, int startTime, int endTime) {
      this.day = day;
      this.startTime = startTime;
      this.endTime = endTime;
    }

    public Day getDay() {
      return day;
    }

    public int getStartTime() {
      return startTime;
    }

    public int getEndTime() {
      return endTime;
    }

    public void setDay(Day day) {
      this.day = day;
    }

    public void setStartTime(int startTime) {
      this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
      this.endTime = endTime;
    }
  }
}