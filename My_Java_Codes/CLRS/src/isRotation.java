
/*
 * CTCI : 1.8
 * 
 * Assume you have a method isSubstring which checks 
 * if one word is a substring of another. 
 * 
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of 
 * s1 using only one call to isSubstring 
 * (e.g.,"waterbottle"is a rota­tion of"erbottlewat").
 */
public class isRotation {
	
	public static boolean isRotation(String s1, String s2){
		int len = s1.length();
		
		if(len==s2.length() && len>0){
			String s1s1 = s1 + s1;
			return isSubstring(s1s1, s2);
		}
		return false;
	}
	
	public static boolean isSubstring(String str1, String str2){
		return str1.toLowerCase().contains(str2.toLowerCase());
	}
	
	public static void main(String[] args){
		String A = "waterbottle";
		String B = "erbottlewat";
		System.out.println("\n String A is : " + A);
		System.out.println("\n String B is : " + B);
		
		if(isRotation(A,B)){
			System.out.println("\n String A is a rotation of String B");
		} else {
			System.out.println("\n String A is not a rotation of String B");
		}
	}

}
