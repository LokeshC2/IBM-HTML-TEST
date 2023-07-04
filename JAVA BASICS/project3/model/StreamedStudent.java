package project3.model;

public class StreamedStudent extends Student {
  private String[] stream;

  public StreamedStudent() {
  }

  public void setStream(String... subjects) {
    this.stream = subjects.clone();
  }

  public String[] getStream() {
    return stream;
  }

  public Student[] createStudents(String... names) {
    Student[] students = new Student[names.length];
    for (int i = 0; i < names.length; i++) {
      students[i] = new Student();
      students[i].setId(i + 1);
      students[i].setName(names[i]);
    }
    return students;
  }

  @Override
  public void getDetails() {
    super.getDetails();
    if (stream != null && stream.length > 0) System.out.println("Stream: " + String.join(", ", stream));
    else System.out.println("Stream: None");
  }

  @Override
  public String toString() {
    return super.toString() + "StreamedStudent [stream=" + String.join(", ", stream) + "]";
  }
}
