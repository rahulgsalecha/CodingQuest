
public class MySelectionSort {
	
	public static void main(String[] args){
		int[] arr1 = {5,3,6,7,8,1,-1,-2};
		
		int[] arr2 = doSelectionSort(arr1);
		
		for(int elem : arr2){
			System.out.print(elem);
			System.out.print(", ");
		}
	}
	
	public static int[] doSelectionSort(int[] array){
		
		for(int i = 0; i < array.length - 1; i++){
			int minimum = i;
			for (int j = i + 1; j < array.length; j++){
				
				// check if element is smaller than key
				
				if(array[j] < array[minimum]){
					minimum = j;
				}
			}
				
			//swap elements
				
			int smallerNumber = array[minimum];  
			array[minimum] = array[i];
			array[i] = smallerNumber;
			
		}
		return array;
		
	}

}
