public class Palindrome {
 
	public static void main(String[] args) {
		String userInput = "121";
		Boolean palindrome = true;
		Integer len = userInput.length();
		for(int i = 0; i<=len/2; i++) {
			if (userInput.charAt(i) != userInput.charAt(len-1-i)) {
				palindrome = false;
			}
		}
		System.out.println("Input is palindrome: "+ palindrome.toString());
	}
 
}