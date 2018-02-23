
public class MyInsertionSort {
	
	public static void main(String[] args){
		int[] arr1 = {10,34,2,56,7,67,88,42};
		
		int[] arr2 = doInsertionSort(arr1);
		
		System.out.println("Insertion sort is: ");
        for(int i:arr2){
            System.out.print(i);
            System.out.print(", ");
        }
        
        
        int[] arr3 = doReverseInsertionSort(arr1);
        System.out.println("\nReverse Insertion sort is: ");
        
        for(int j:arr3){
            System.out.print(j);
            System.out.print(", ");
        }
        
        
        int[] arr4 = doRecursiveInsertionSort(arr1, arr1.length);
        System.out.println("\nRecursive Insertion sort is: ");
        
        for(int j:arr4){
            System.out.print(j);
            System.out.print(", ");
        }
        
	}
	
	public static int[] doInsertionSort(int[] input){
		int temp; // Constant O(1) memory
		for(int i = 1; i< input.length; i++){
			for(int j=i; j>0; j--){					// O(n^2) time
				if(input[j] < input[j-1]){
					temp = input[j];
					input[j] = input[j-1];
					input[j-1] = temp;
				}
			}
		}
		return input;
		
	}
	
	public static int[] doRecursiveInsertionSort(int[] array, int n){
		int i;
	     if (n > 1) {
	    	doRecursiveInsertionSort(array, n - 1);
	        int k = array[n-1];
	        i = n - 2;
	        while (i >= 0  &&  array[i] > k) {
	            array[i + 1] = array[i];
	            i = i - 1;
	        }
	        array[i + 1] = k;
	    }
	    return array;
		
	}
	
	public static int[] doReverseInsertionSort(int[] input){
		int temp; // Constant O(1) memory
		for(int i = 1; i< input.length; i++){
			for(int j=i; j>0; j--){					// O(n^2) time
				if(input[j] > input[j-1]){
					temp = input[j];
					input[j] = input[j-1];
					input[j-1] = temp;
				}
			}
		}
		return input;
		
	}

}
