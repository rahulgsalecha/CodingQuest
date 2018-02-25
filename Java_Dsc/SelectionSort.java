import java.util.*;

class SelectionSort {

    public static int[] doSelectionSort(int[] input, int n){
        
        int i,j,min,temp;

        for(i = 0; i < n-1; i++){
            min = i;
            for( j= i+1; j < n; j++ ){                 // O(n^2) time
                if(input[j] < input[min]){
                    min = j;
                }
            }
            temp = input[i];
            input[i] = input[min];
            input[min] = temp;
        }

        return input;
    }

    public static void main(String[] args){

        int[] arr1 = {10,34,2,56,7,67,88,42};
        System.out.println("Input array is: " + Arrays.toString(arr1));

        int[] arr2 = doSelectionSort(arr1, arr1.length);
        System.out.println("Selection sort is: " + Arrays.toString(arr2));
        
    }
}

/* Output:
 * Input array is: [10, 34, 2, 56, 7, 67, 88, 42]
 * Selection sort is: [2, 7, 10, 34, 42, 56, 67, 88]
  */
