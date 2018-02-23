import java.util.Arrays;


// CTCI : 1.3
//Given two strings, write a method to decide 
//if one is a permutation of the other.
// Eg : CARD and DRAC are permutation of each other
// Eg : PACK and SACK are not permutations of each other

// Method 1 : Sort and Compare
// Method 2 : Check if the 2 strings have identical character count

public class PermutationOfEachOther {

	public static String sort(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	
	public static boolean isAnagram1(String s, String t){
		if(s.length() != t.length()){
			return false;
		}
		
		return sort(s).equals(sort(t));
	}
	
	public static boolean isAnagram2(String s, String t){
		if(s.length() != t.length()){
			return false;
		}
		
		int[] letters = new int[256];
		
		char[] s_arr = s.toCharArray();
		
		for(char c : s_arr){
			letters[c]++;
		}
		
		for(int i=0; i< t.length(); i++){
			int c = (int)t.charAt(i);
			if (--letters[c] < 0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args){
		String C = "dark";
		String D = "arkd";
		
		System.out.println("String to compare are : "+ C +","+D);
		if(isAnagram1(C,D)){
			System.out.println("isAnagram1 : Anagrams");
		} else {
			System.out.println("isAnagram1 : not Anagrams");
		}
		
		if(isAnagram2(C,D)){
			System.out.println("isAnagram2 : Anagrams");
		} else {
			System.out.println("isAnagram2 : not Anagrams");
		}
			
	}
	
}
