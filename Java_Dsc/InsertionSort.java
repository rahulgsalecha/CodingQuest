import java.util.*;

class InsertionSort {

    public static int[] doInsertionSort(int[] input, boolean reverse){
        int temp; // Constant O(1) memory
        for(int i = 1; i< input.length; i++){
            for(int j=i; j>0; j--){                 // O(n^2) time
                if(reverse == false) {
                    if(input[j] < input[j-1]){
                        temp = input[j];
                        input[j] = input[j-1];
                        input[j-1] = temp;
                    }
                } else {
                    if(input[j] > input[j-1]){
                        temp = input[j];
                        input[j] = input[j-1];
                        input[j-1] = temp;
                    }
                }
            }
        }
        return input;
    }

    public static int[] doRecursiveInsertionSort(int[] array, int n){
        int i;
        if (n > 1) {
            doRecursiveInsertionSort(array, n - 1);
            int last = array[n-1];
            i = n - 2;
            while (i >= 0  &&  array[i] > last) {
                array[i + 1] = array[i];
                i = i - 1;
            }
            array[i + 1] = last;
        }
        return array;

    }

    public static void main(String[] args){
        int[] arr1 = {10,34,2,56,7,67,88,42};
        System.out.println("Input array is: " + Arrays.toString(arr1));

        int[] arr2 = doInsertionSort(arr1, false);
        System.out.println("Insertion sort is: " + Arrays.toString(arr2));
        
        int[] arr3 = doInsertionSort(arr1, true);
        System.out.println("Reverse Insertion sort is: " + Arrays.toString(arr3));

        int[] arr4 = doRecursiveInsertionSort(arr1, arr1.length);
        System.out.println("Recursive Insertion sort is: " + Arrays.toString(arr4));
    }
}

/* Output:
 * Input array is: [10, 34, 2, 56, 7, 67, 88, 42]
 * Insertion sort is: [2, 7, 10, 34, 42, 56, 67, 88]
 * Reverse Insertion sort is: [88, 67, 56, 42, 34, 10, 7, 2]
 * Recursive Insertion sort is: [2, 7, 10, 34, 42, 56, 67, 88]
 */
