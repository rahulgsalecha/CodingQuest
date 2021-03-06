import java.util.Arrays;


public class MyBinarySearch {

	public static void main(String[] args){
		int[] arr1 = {5,3,6,7,8,1,-1,-2};
		int key = -11;
		
		Arrays.sort(arr1);
		if(binarySearch(arr1, key)){
			System.out.println("Key "+key+" found in the array");
		} else {
			System.out.println("Key "+key+" not found in the array");
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
