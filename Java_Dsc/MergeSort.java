/* Java program for Merge Sort */
import java.util.*;

class MergeSort{

    // Main function that sorts arr[l..r] using merge()
    public static void Sort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            Sort(arr, low, mid);
            Sort(arr,mid+1, high);
            Merge(arr,low,mid,high);
        }
    }

    // Merges two subarrays of arr[].
    // First subarray is arr[l..m]
    // Second subarray is arr[m+1..r]

    public static void Merge(int arr[], int low, int mid, int high) {

        // Find sizes of two subarrays to be merged
        int n1 = mid - low + 1;
        int n2 = high - mid;
        
        /* Create temp arrays */
        int L[] = new int[n1];
        int R[] = new int[n2];

        /* Copy data to temp arrays */
        for (int i=0; i < n1; ++i){
            L[i] = arr[low+i];
        }
        for (int j=0; j < n2; ++j){
            R[j] = arr[mid+1+j];
        }

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = low;

        while(i<n1 && j<n2) {
            if(L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while(i<n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while(j<n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }


    /* A utility function to print array of size n*/
    public static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
 
    public static void main(String args[])
    {
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Given Array");
        printArray(arr);
         
        MergeSort ob = new MergeSort();
        ob.Sort(arr, 0, arr.length-1);
         
        System.out.println("\nSorted array");
        printArray(arr);
    }
}

/* Output:
 * Given Array
 * 12 11 13 5 6 7 
 *
 * Sorted array
 * 5 6 7 11 12 13 
 */
