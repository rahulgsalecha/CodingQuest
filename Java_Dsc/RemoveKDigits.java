/* Given a non-negative integer num represented as a string, remove k digits from the number 
 * so that the new number is the smallest possible.
 *
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 * 
 * Example 1:
 *
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 * 
 * Example 2:
 *
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 * 
 * Example 3:
 *
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 */

import java.util.*;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        int len = num.length();
        if ( k == len) return "0";

        Stack<Character> stack = new Stack<Character>();
        int i = 0;

        while(i < len) {
            while(k>0 && !stack.isEmpty() && stack.peek() > num.charAt(i)){
                stack.pop();
                k--;
            }

            stack.push(num.charAt(i));
            i++;
        }

        // corner cases like "1111"
        while(k>0){
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        sb.reverse();

        // remove all the 0 at the head
        while(sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);

        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveKDigits rem = new RemoveKDigits();

        String str = "1432219";
        String strRemove = rem.removeKdigits(str, 3);
        System.out.println("\n The input is : " + str);
        System.out.println("\n The output is : " + strRemove);

        String str1 = "1111";
        String str1Remove = rem.removeKdigits(str1, 2);
        System.out.println("\n The input is : " + str1);
        System.out.println("\n The output is : " + str1Remove);

    }
}
