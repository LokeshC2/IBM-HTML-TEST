package EnumsExample;

public class UseColors {
  public static void main(String[] args) {
    System.out.println(Colors.Red);
    System.out.println(Colors.Green);
    System.out.println(Colors.Blue);
    
    System.out.println("Red:");
    System.out.println(Colors.Red.getR());
    System.out.println(Colors.Red.getG());
    System.out.println(Colors.Red.getB());
  }
}
