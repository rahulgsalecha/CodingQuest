/* Java program for finding valid lotto pick numbers */

/*
 * Important take-aways from the Question is that:
 * a) Only 7 unique numbers between 1 and 59
 * b) Digits must be used in order
 * c) Every digit must be used exactly once -> no repetitive digit number like 11, 22, etc
 * 
 * Solution:
 * We can use the Depth-First-Search (DFS) approach to figure out valid combinations
 * of 1-digit and 2-digit numbers. (Because we have a decision problem out here).
 * We can maintain a HashSet to track the visited substrings.
 *
 * Algorithm Steps :
 *
 * i) Check length. If it is more than 7, it can have corresponding 2-digit number
 *    Eg : Length is 13 : 13 mod 7 = 6 of them are 2-digit numbers (Eg : 4938532894754)
 *    Eg: Length is 7 : 7 mod 7 = 0 0f them are 2-digit numbers (Eg : 1234567)
 *
 * ii) Once length is checked, for each set of 1-digit &  2-digit substrings,
 *      start the recusrsive comparison using DFS algorithm,
 * 
 * iii) If the criteria is met, add the output to a list and return the list
 *      of valid combinations
 *
 * Test Cases and Output are attached at the end of this code.
 *
 * Complexity : O(k^n)
 *
 * k = Height of the Decision tree in DFS : 1-digit or 2-digit (2)
 * n = Number of digits in the string (7)
 *
 * In this problem, it is O(2^7)
 */

import java.util.*;

public class LottoPickFinderSolution {


    /* Function to find list of possible combinations of lotto pick numbers 
     * for a given string */

    static List<String> lottoPickNumbers(String lotto_num) {
        /* Maintain a list of probable output combination per input string */
        List<String> output = new ArrayList<String>();

        /* Check if given string is empty or not */
        if (lotto_num.isEmpty()) { 
            return output; 
        }

        /* Call lottoPickNumbers function */
        lottoPickNumbers(lotto_num, output, new HashSet<String>(), "", 0, 0);

        /* Return the output list per input string */
        return output;
    }


    /* Function to find possible combinations of lotto pick numbers 
     * for a given string .
     * Use the Depth-First Search (DFS) tree traversal mechanism
     * */
    
    static void lottoPickNumbers(String s, List<String> output, 
                                 Set<String> set_visited, String number, 
                                 int count, int index) {

        /* Lotto Number has 7 unique numbers */
        if (count > 7) { 
            return; 
        }

        /* Add the number to output list if criteria is met*/
        if (count == 7 && number.length() == (s.length() + 6)) {
            output.add(number);
        }

        /* Check the 1-digit and 2-digit numbers against the given constraints */
        for (int i = 1; i <= 2; i++) {

            if (index + i > s.length()) { 
                break; 
            }

            /* Find the substring */
            String sub = s.substring(index, index + i);

            /* If the HashSet contains the substring or if the substring is greater than 59, skip the iteration*/
            if (set_visited.contains(sub) || (Integer.parseInt(sub) > 59 || Integer.parseInt(sub) < 1)) {
                continue;
            } else {
                /*Add the current string to the visited HashSet*/
                set_visited.add(sub);

                /* A space is added to distinguish the combination lotto pick */
                String next = number + sub + (count == 6 ? "" : " ");

                /* Recursively check the tree for more combinations */
                lottoPickNumbers(s, output, set_visited, next, count + 1, index + i);

                /* Remove the visited substring from set*/
                set_visited.remove(sub);
            }
        }
    }

    /* Main method with test cases */
    public static void main(String[] args) {
        List<String> str_list = new ArrayList<String>();
        str_list.add("4938532894754"); /* Standard test case */
        str_list.add("1634614512"); /* Standard test case */
        str_list.add("569815571556"); /*Standard test case */
        str_list.add("11223344"); /* Test case with non-unique repetitive numbers */
        str_list.add("1234567"); /* Test case with valid 1-digit numbers */
        str_list.add("472844278465445"); /* Test case with 15 digits */
        str_list.add("1011202241229"); /* Test case with '0' in it */
        str_list.add("0101122241229"); /* Negative test case with '0' in it */


        for(String str : str_list) {
            System.out.println("\nString is : " + str);
            List<String> result = lottoPickNumbers(str);
            if(result.size() != 0) {
                System.out.println("Lotto Pick Combinations : " + lottoPickNumbers(str));
            } else {
                System.out.println("Lotto Pick Combinations Do not exist");
            }
        }
    }
}

/* Output:
 *
 * String is : 4938532894754
 * Lotto Pick Combinations : [49 38 53 28 9 47 54]
 *
 * String is : 1634614512
 * Lotto Pick Combinations : [1 6 3 46 14 5 12, 1 6 3 46 14 51 2, 
 *                            16 3 4 6 1 45 12, 16 3 4 6 14 5 12, 
 *                            16 3 4 6 14 51 2, 16 3 46 1 4 5 12, 
 *                            16 3 46 1 4 51 2, 16 3 46 14 5 1 2, 
 *                            16 34 6 1 4 5 12, 16 34 6 1 4 51 2, 
 *                            16 34 6 14 5 1 2]
 *
 *
 * String is : 569815571556
 * Lotto Pick Combinations Do not exist
 *
 * String is : 11223344
 * Lotto Pick Combinations Do not exist
 *
 * String is : 1234567
 * Lotto Pick Combinations : [1 2 3 4 5 6 7]
 *
 * String is : 472844278465445
 * Lotto Pick Combinations Do not exist
 *
 * String is : 1011202241229
 * Lotto Pick Combinations : [10 11 2 02 24 12 29, 10 11 20 2 24 12 29, 10 11 20 22 4 12 29, 10 11 20 22 41 2 29]
 *
 * String is : 0101122241229
 * Lotto Pick Combinations Do not exist
 * 
 */
