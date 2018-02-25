import java.util.*;

class BinarySearch {

    public static int doIterativeBinarySearch(int[] input, int key, int low, int high){
    
        int mid;

        while(low <= high) {
            mid = low + (high - low) / 2;
            if(input[mid] < key)
                low = mid + 1;
            else if (input[mid] > key) 
                high = mid -1;
            else
                return mid;
        }

        return -1;
    }

    public static int doRecursiveBinarySearch(int[] input, int key, int low, int high){
    
        int mid;

        while(low <= high) {
            mid = low + (high - low) / 2;
            if(input[mid] < key)
                return doRecursiveBinarySearch(input,key,mid + 1,high);
            else if (input[mid] > key) 
                return doRecursiveBinarySearch(input,key,low, mid-1);
            else
                return mid;
        }

        return -1;
    }

    public static void printOutput(int key, int ret) {
        
        if(ret > -1) 
            System.out.println("Key "+key+" found at index "+ret);
        else 
            System.out.println("Key "+key+" not found");

    }

    public static void main(String[] args){

        int[] arr1 = {10,20,30,40,50,60,70,80,90,100,110,120};
        System.out.println("Input array is: " + Arrays.toString(arr1));
        int n = arr1.length - 1;

        int key = 70;
        int ret = doIterativeBinarySearch(arr1 ,key, 0, n);
        printOutput(key,ret);

        key = 130;
        ret = doIterativeBinarySearch(arr1 ,key, 0, n);
        printOutput(key,ret);
        
        key = 90;
        ret = doRecursiveBinarySearch(arr1 ,key, 0, n);
        printOutput(key,ret);

        key = 18;
        ret = doRecursiveBinarySearch(arr1 ,key, 0, n);
        printOutput(key,ret);
        
    }
}

/* Output:
 * Input array is: [10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110, 120]
 * Key 70 found at index 6
 * Key 130 not found
 * Key 90 found at index 8
 * Key 18 not found
  */
