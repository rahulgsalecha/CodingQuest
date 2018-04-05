/*
 * Print all distinct permutation of a string having duplicates.
 *
 * Examples:
 *
 * Input : ABCA
 * Output : AABC AACB ABAC ABCA ACBA 
 *          ACAB BAAC BACA BCAA CABA 
 *                   CAAB CBAA
 */

public class UniquePermutationsOfaString {

    public static String swap(String str, int i, int j)
    {
        char ch[] = str.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return String.valueOf(ch);
    }

    public static boolean shouldSwap(char str[], int start, int curr, int n)
    {
            for (int i = start; i < curr; i++) 
                if (str[i] == str[curr])
                    return false;
            return true;
    }

    public static void findUniquePermutationsOfaString(String s, int index, int n) {

        if(index >= n) {
            System.out.println(s+"");
            return;
        }

        for(int i=index ; i< n; i++) {
            
            boolean check = shouldSwap(s.toCharArray(), index, i, n);

            if(check) {
                s = swap(s, index ,i);
                findUniquePermutationsOfaString(s, index+1, n);
                s = swap(s, index ,i);
            }
        }

    }

    public static void findUniquePermutationsOfaString2(String input, String sofar) {
        if (input.equals("")) {
            System.out.println(sofar+"");
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
        
            if (input.indexOf(c, i + 1) != -1)
                continue;
            
            findUniquePermutationsOfaString2(input.substring(0, i) + input.substring(i + 1), sofar+c);
        }
    }

    public static void main(String[] args) {
        //String s = "ABCA";
        String s = "AAB";
        int n = s.length();
        System.out.println("Solution 1: ");
        findUniquePermutationsOfaString(s,0,n);

        System.out.println("Solution 2: ");
        findUniquePermutationsOfaString2(s,"");
    }
}
