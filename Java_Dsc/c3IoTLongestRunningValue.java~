/*
 * Input : [30,50,60,20,10,40,60,70,80]
 * Output: [1, 2, 3, 1, 1, 3, 7, 8, 9]
 *
 * Time=series data
 *
 * Longes Running values
 *
 * Eg: If temperature is 50, which is greater tha 30 as wel as consecutive to 30, the count is 2.
 * Similarly, for 60 , which comes after 30 and 50 and since 60 is max, the count is 3.
 * When it reaches 20, it is less than 60 and hence the count is reset to 1.
 * When it reaches 40, it lokks for all previous consecutive temperature less than 40,
 * in this case, 10 and 20 are less than 40 (consecutively) and hecne count is 3
 */

/* Initial brute-force soultion I provided was O(n^2) solution : */

import java.util.*;

class c3IoTLongestRunningValue{

public static int[] longestRunningValueImproved(int[] input){

    if(input == null || input.length == 0){
        throw new IllegalArgumentException("The input array is incorrect\n");
    }
    int n = input.length;
    int[] res = new int[n];

    Stack<Integer> stack = new Stack<Integer>();

    if(n ==0){
        return res;
    }

    for(int i = 0;i<n;i++){

        if(stack.size()==0 || input[stack.peek()]> input[i]){
            stack.push(i);
            res[i]=1;
        }
        else{
            while(stack.size()!=0 && input[stack.peek()]<=input[i]){
                stack.pop();
            }
            res[i] = (stack.size()==0)?i+1: i-stack.peek()+1;
            stack.push(i);
        }
    }

    return res;
}

public static int[] longestRunningValue(int[] input, int length) {
    int[] output = new int[length];
    output[0] = 1;
    int count = 1;
    int Max = input[0];
    int MaxIndex = 0;

    for (int i= 1; i < length; i++){
        if(input[i] < input[i-1]) {
            output[i] = 1;
        } else {
            if(input[i] >= Max){
                MaxIndex = i;
                Max = input[i];
                output[i] = i+1;
                //output[i] = getPreviousLowerCounts(input, input[i], i);
            } else {
                int ind = i-1;
                int hop = 0;
                while( ind != MaxIndex) {
                    hop += output[ind];
                    ind--;
                }
                output[i] = 1+hop;
            }
        }
    }

    return output;
}

public static int getPreviousLowerCounts(int[] input, int current, int index) {
    int count = 0;

    for(int i = index; i>= 0; i--){
        if(input[i] <= current){
            count+=1;
        } else {
            break;
        }
    }

    return count;
}

public static void main(String[] args){
    int[] input = {30,50,60,20,10,40,60,70,80};
    int[] output = longestRunningValue(input, input.length);
    int[] output1 = longestRunningValueImproved(input);

    System.out.println("Input: " + Arrays.toString(input));
    System.out.println("Output:Non-Efficient O(n^2): " + Arrays.toString(output));
    System.out.println("Output Improved O(n): " + Arrays.toString(output1));
}
}
/* Output:
 * Input: [30, 50, 60, 20, 10, 40, 60, 70, 80]
 * Output:Non-Efficient O(n^2): [1, 2, 3, 1, 1, 3, 7, 8, 9]
 * Output Improved O(n): [1, 2, 3, 1, 1, 4, 7, 8, 9]
 * */
