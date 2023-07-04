public class String_reverse {
  public static void main(String[] args) {
    String userInput = "Hello World, I am a hungry programmer";
    String reverse = "";
    Integer len = userInput.length();
    for(int i = 0; i<len; i++) {
      reverse = reverse + userInput.charAt(len-1-i);
    }
    System.out.println("Reverse of input is: "+ reverse);
  }
}