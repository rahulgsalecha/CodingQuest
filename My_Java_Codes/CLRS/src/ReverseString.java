import java.util.Scanner;

// CTCI : 1.2
//Implement a function void reverse(char* str) 
//in C or C++ which reverses a null- terminated string.

public class ReverseString {

	public static void main(String[] args) {
		
		String original;
	      Scanner in = new Scanner(System.in);
	 
	      System.out.println("Enter a string to reverse");
	      original = in.nextLine();
	      
	      reverse1(original);
	      
	      reverse2(original);
	}
	
	public static void reverse1(String original){
		String reverse = "";
		int length = original.length();
		 
	      for ( int i = length - 1 ; i >= 0 ; i-- )
	         reverse = reverse + original.charAt(i);

	      System.out.println("Method 1: Use charAt : Reverse of entered string is: "+reverse);
	}
	
	public static void reverse2(String original){
		StringBuffer a = new StringBuffer(original);
	    System.out.println("Method 2:Use StringBuffer : Reverse of entered string is: "+a.reverse());
	}
}
