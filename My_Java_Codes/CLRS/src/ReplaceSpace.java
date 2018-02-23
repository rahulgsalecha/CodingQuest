
// CTCI 1.4
/* Write a method to replace all spaces in a string with'%20'. 
 * You may assume that the string has sufficient space at the end 
 * of the string to hold the additional characters, and that 
 * you are given the "true" length of the string. 
 * (Note: if imple­ menting in Java, please use a character array 
 * so that you can perform this opera­ tion in place.)
EX A M P L E
Input: "Mr John Smith"
Output: "Mr%20John%20Smith"
*/
public class ReplaceSpace {

	private static char[] replaceSpaceInString(char[] str, int length) {
	    int spaceCounter = 0;

	    //First lets calculate number of spaces
	    for (int i = 0; i < length; i++) {
	      if (str[i] == ' ') 
	        spaceCounter++;
	    }

	    //calculate new size
	    int newLength = length + 2*spaceCounter;

	    char[] newArray = new char[newLength+1];
	    newArray[newLength] = '\0';

	    int newArrayPosition = 0;

	    for (int i = 0; i < length; i++) {
	      if (str[i] == ' ') {
	        newArray[newArrayPosition] = '%';
	    newArray[newArrayPosition+1] = '2';
	    newArray[newArrayPosition+2] = '0';
	    newArrayPosition = newArrayPosition + 3;
	      }
	      else {
	    newArray[newArrayPosition] = str[i];
	    newArrayPosition++;
	      }
	    }               
	    return newArray;
	  }

		
	public static void main(String[] args){
		char[] array = {'a','b','c','d',' ','e','f','g',' ','h',' ','j'};
		
		System.out.println("\n Original String :"+ new String(array));
		
		array = replaceSpaceInString(array, array.length);
		
		System.out.println("\n Replaced String :"+ new String(array));
		
		
		
	}

}
