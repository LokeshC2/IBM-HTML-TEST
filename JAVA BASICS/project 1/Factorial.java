public class Factorial {
  public static void main(String[] args) {
    Integer userInput = 5;
    Integer factorial = 1;
    for(int i = 1; i<=userInput; i++) {
      factorial = factorial * i;
    }
    System.out.println("Factorial of input is: "+ factorial.toString());
  }
}
