public class Find_vovels {

  public static void main(String[] args) {
    String userInput = "Hello World, I am a hungry programmer";
    Integer len = userInput.length();
    Integer vovels = 0;
    char[] vovelsArray = {'a','e','i','o','u'};
    for(int i = 0; i<len; i++) {
      for(int j = 0; j<5; j++) {
        if (userInput.toLowerCase().charAt(i) == vovelsArray[j]) {
          vovels++;
        }
      }
    }
    System.out.println("Number of vovels in input is: "+ vovels.toString());
  }
}
