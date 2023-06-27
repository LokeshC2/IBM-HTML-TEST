package project3.model;

public class StreamedStudent extends Student {
  private String stream;

  public StreamedStudent() {
  }

  public String getStream() {
    return stream;
  }

  public void setStream(String stream) {
    this.stream = stream;
  }

  @Override
  public void getDetails() {
    super.getDetails();
    System.out.println("Stream: " + stream);
  }

  @Override
  public String toString() {
    return super.toString() + "StreamedStudent [stream=" + stream + "]";
  }
}
