package intvw;

/*CC150-1-1: Implement an algorithm to determine if a string has all unique characters. 
 * What if you cannot use additional data structures?

1. Ask interviewer if the string is an ASCII string or Unicode string. 
(Difference between ASCII and Unicode: 
http://java67.blogspot.com/2013/02/10-examples-of-hashmap-in-java-programming-tutorial.html)

2. Ok, assume that it is an ASCII string.

1) If string length > 256, it must have repeated characters, then return false

2) Thoughts:

A. Compare every character of the string to every other character of the string. 
	Time complexity O(n^2), space complexity O(1)

B. If we are allowed to modify the string, 
	we can sort it in O(nlgn) time and linearly check the string for 
	neighboring characters that are identical. 
	(Careful: many sorting algorithms take up extra space. 
	Make sure you ask interviewers about this.)

C. Use HashMap<Character, Boolean>, only need one round scan, 
	every time when you try to insert a key into the map, 
	check whether the key is already there, if the returned value is true, 
	that means key is already there and the current character you try to
	 insert is a repeated one, return false; if no repeated characters, return true.

D. Create an array of boolean values where the flag at index i 
	indicates whether character i in alphabet is contained in the string. 
	 If you run across this character a second time, return false.
	 Time: O(n); Space O(n)

E. Use bit vector. Assume that the string only uses the lower case letters a through z. 
	This will allow us to use just a single int.
	Time: O(n); Space O(n)
*/
import java.util.Arrays;
import java.util.HashMap;

public class UniqueCharInString {

	public static void main(String[] args) {
		String s = "abc";
		System.out.println("Method 1 : String is : "+ s);
		
		//Implement an algorithm to determine if 
		//a string has all unique characters. 
		//What if you cannot use additional data structures?
		
		//method 1
		// Brute-force : compare each with every other character
		if(method1(s)){
			System.out.println("method1 : String is non-unique");
		} else {
			System.out.println("method1 : String is unique");
		};
		
		//method 2
		//sort and compare pairs
		s = "gevef";
		System.out.println("Method 2 : String is : "+ s);
		if(method2(s)){
			System.out.println("method2 : String is non-unique");
		} else {
			System.out.println("method2 : String is unique");
		};
		
		//method 3
		//Insert in hash map and check the count for each character
		s = "gvef";
		System.out.println("Method 3 : String is : "+ s);
		if(method3(s)){
			System.out.println("method3 : String is non-unique");
		} else {
			System.out.println("method3 : String is unique");
		};
		
		//method 4
		//Based on boolean value in an array for a character
		s = "govef";
		System.out.println("Method 4 : String is : "+ s);
		if(method4(s)){
			System.out.println("method4 : String is non-unique");
		} else {
			System.out.println("method4 : String is unique");
		};

		//method 5
		//Using bit vector
		s = "gveitrff";
		System.out.println("Method 5 : String is : "+ s);
		if(method5(s)){
			System.out.println("method5 : String is non-unique");
		} else {
			System.out.println("method5 : String is unique");
		};


	}

	public static boolean method1(String s){
		//Check each variable in entire string
		for(int i = 0; i < s.length(); i++){
			for(int j = 0; j < s.length(); j++){			
				if(i != j){
					Character c1 = s.charAt(i);
					Character c2 = s.charAt(j);
					if(c1.compareTo(c2) == 0){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	public static boolean method2(String s){
		
		char[] ar = s.toCharArray();
		Arrays.sort(ar);
		String sorted = String.valueOf(ar);

		//Check each variable in entire string
		for(int i = 0; i < sorted.length(); i++){
			int j = i+1;
			if(j < sorted.length()){
				Character c1 = sorted.charAt(i);
				Character c2 = sorted.charAt(j);
				if(c1.compareTo(c2) == 0){
					return true;
				}
			}
			
		}
		return false;
	}
	
	
	public static boolean method3(String s){
		
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i = 0; i < s.length(); i++){
			   char c = s.charAt(i);
			   Integer val = map.get(new Character(c));
			   if(val != null){
			     //map.put(c, new Integer(val + 1));
				 return true;
			   }else{
			     map.put(c,1);
			   }
		}
		return false;	
	}
	
	public static boolean method4(String str) {
		if (str.length() > 256) {
			return false;
		}
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			if (char_set[val]) return true;
			char_set[val] = true;
		}
		return false;
	}
	
	public static boolean method5(String str) {
		if (str.length() > 256) {
			return false;
		}
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0) return true;
			checker |= (1 << val);
		}
		return false;
	}



}
