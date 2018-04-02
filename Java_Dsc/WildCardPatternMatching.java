/*
 * Given a text and a wildcard pattern, implement wildcard pattern matching algorithm that 
 * finds if wildcard pattern is matched with text. The matching should cover the entire text (not partial text).
 *
 * The wildcard pattern can include the characters ‘?’ and ‘*’
 * ‘?’ – matches any single character
 * ‘*’ – Matches any sequence of characters (including the empty sequence)
 *
 * For example,
 *
 * Text = "baaabab",
 * Pattern = “*****ba*****ab", output : true
 * Pattern = "baaa?ab", output : true
 * Pattern = "ba*a?", output : true
 * Pattern = "a*ab", output : false 
 *
 */
/* Solution : Use Dynamic Programming */

/* DP Initialization:
 * ===================
 *
 * both text and pattern are null : 
 * T[0][0] = true; 
 *
 * pattern is null
 * T[i][0] = false; 
 *
 * text is null
 * T[0][j] = T[0][j - 1] if pattern[j – 1] is '*'  
 *
 * DP relation :
 * ===========
 *
 * If current characters match, result is same as result for lengths minus one. Characters match in two cases:
 * a) If pattern character is '?' then it matches with any character of text. 
 * b) If current characters in both match
 * if ( pattern[j – 1] == ‘?’) || (pattern[j – 1] == text[i - 1])
 *      T[i][j] = T[i-1][j-1]   
 *
 * If we encounter ‘*’, two choices are possible-
 * a) We ignore ‘*’ character and move to next character in the pattern, i.e., ‘*’ indicates an empty sequence.
 * b) '*' character matches with ith character in input 
 *
 * else if (pattern[j – 1] == ‘*’)
 *      T[i][j] = T[i][j-1] || T[i-1][j]  
 * else // if (pattern[j – 1] != text[i - 1])
 *      T[i][j]  = false 
*/



import java.util.Arrays;

public class WildCardPatternMatching {

    static boolean isMatch(String str, String pattern) {
        int lenS = str.length();
        int lenP = pattern.length();

        /* Empty pattern can match only with empty string*/
        if (lenP == 0) return (lenS == 0);

        /* lookup table for storing results of subproblems */
        boolean[][] lookup = new boolean[lenS + 1][lenP + 1];

        /*initailze lookup table to false*/
        for(int i=0; i<lenS+1; i++)
            Arrays.fill(lookup[i], false);

        /* empty pattern can match with empty string */
        lookup[0][0] = true;

        /* Only '*' can match with empty string */
        for (int j = 1; j <= lenP; j++)
            if (pattern.charAt(j - 1) == '*')
                lookup[0][j] = lookup[0][j - 1];

        /* fill the table in bottom-up fashion*/
        for (int i = 1; i <= lenS; i++){
            for (int j = 1; j <= lenP; j++){
                /* Two cases if we see a '*'
                 * a) We ignore '*'' character and move
                 * to next  character in the pattern,
                 * i.e., '*' indicates an empty sequence.
                 * b) '*' character matches with ith
                 * character in input
                 * */
                if (pattern.charAt(j - 1) == '*')
                    lookup[i][j] = lookup[i][j - 1] ||
                        lookup[i - 1][j];

                /* Current characters are considered as
                 * matching in two cases
                 * (a) current character of pattern is '?'
                 * (b) characters actually match
                 * */
                else if (pattern.charAt(j - 1) == '?' ||
                        str.charAt(i - 1) == pattern.charAt(j - 1))
                    lookup[i][j] = lookup[i - 1][j - 1];

                /* If characters don't match*/
                else lookup[i][j] = false;
            }
        }

        return lookup[lenS][lenP];
    }

    public static void main(String args[])
    {
        String str = "baaabab";
        String pattern = "*****ba*****ab";
        /* String pattern = "ba*****ab";*/
        /* String pattern = "ba*ab";*/
        /* String pattern = "a*ab";*/
        /* String pattern = "a*****ab";*/
        /* String pattern = "*a*****ab";*/
        /* String pattern = "ba*ab****";*/
        /* String pattern = "****";*/
        /* String pattern = "*";*/
        /* String pattern = "aa?ab";*/
        /* String pattern = "b*b";*/
        /* String pattern = "a*a";*/
        /* String pattern = "baaabab";*/
        /* String pattern = "?baaabab";*/
        /* String pattern = "*baaaba*";*/

        if (isMatch(str, pattern))
            System.out.println("Yes");
        else
            System.out.println("No");

    }
}
