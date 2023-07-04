package trycatch.employeeProj;

public class NameTooShortException extends RuntimeException {

  public NameTooShortException(String string) {
    super(string);
  }
  
}
