
public class SumOfTwoIntegers_PairsExists {
	
	public static void main(String[] args){
		int[] arr1 = {5,3,6,7,8,1,-1,-2};
		int sum = 16;
		
		mergeSort(arr1, 0, arr1.length-1); // O(nlogn)
		
		for(int i=0; i < arr1.length-1; i++){
			if(binarySearch(arr1, sum - arr1[i])){ // O(nlogn)
				System.out.println("Pairs Exist for sum:"+ sum+" and they are : "+ arr1[i]+" & "+ (sum-arr1[i]));
				return;
			}
		}
		
		System.out.println("Pairs Doesn't Exist for sum:"+ sum);
	}
	
	public static void mergeSort(int[] array, int low, int high){
		int temp[] = new int[array.length];
		int middle = (low + high) / 2;
		if(low < high){
			mergeSort(array, low, middle);
			mergeSort(array, middle+1, high);
			merge(array, low, middle, high, temp);
		}
	}
	
	public static void merge(int[] array, int low, int middle, int high, int[] temp){
		
		  int i = low;
	      int j = middle + 1;
	      int k = low;
	      
	      while (i <= middle && j <= high){
	    	  if(array[i]<array[j]){
	    		  temp[k]=array[i];
	    		  i++;
	    	  } else {
	    		  temp[k]=array[j];
	    		  j++;
	    	  }
	    	  k++;
	      }
	      
	      while (i <= middle)
	      {
	         temp[k] = array[i];
	         i++;
	         k++;
	      }

	      while (j <= high)
	      {
	         temp[k] = array[j];
	         j++;
	         k++;
	      }
	      
	      for (k = low; k <= high; k++)
	      {
	         array[k] = temp[k];
	      }
		
	}
	
	public static boolean binarySearch(int[] array, int key){
		int low = 0;
		int high = array.length -1;
		int middle = (low + high) / 2;
		
		while(high >= low) {
			
			if(array[middle] == key) {
				return true;
			} 
			
			if(array[middle] < key) {
				low = middle + 1;
			} 
			
			if(array[middle] > key) {
				high = middle - 1;
			}
			middle = (low + high) / 2;
		}
		
		return false;
	}
	

}
