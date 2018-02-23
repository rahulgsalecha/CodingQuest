


public class MyPriorityQueue{
	
	private static void swap(int[] arr, int a, int b)
    {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
	
	private static void maxHeapify (int Arr[ ], int i, int N)
	{
		int largest = i;
	    int left = 2*i;                  //left child
	    int right = 2*i +1  ;         //right child
	    if(left<= N && Arr[left] > Arr[i] )
	          largest = left;
	    else
	         largest = i;
	    if(right <= N && Arr[right] > Arr[largest] )
	        largest = right;
	    if(largest != i )
	    {
	        swap (Arr, i , largest);
	        maxHeapify (Arr, largest,N);
	    } 
	 }
	
	public static int maximum(int Arr[ ])
    {
		System.out.println("\n Maximum is : " + Arr[1]);
        return Arr[ 1 ];  //as the maximum element is the root element in the max heap.
    }
	
	public static int extract_maximum (int Arr[ ])
	{
		
		if (Arr.length == 0) {
			System.out.println("\n Heap UnderFlow : Can’t remove element as queue is empty");
			return -1;
		}
		int max = Arr[1];
		Arr[1] = Arr[Arr.length-1];
		
		maxHeapify(Arr,1, Arr.length-1);
		System.out.println("\n Extracted Maximum is : " + max);
		return max;
		
	}
	
	public static int[] increase_value (int Arr[ ], int i, int val)
	{
		System.out.println("Before insert: " + java.util.Arrays.toString(Arr));
		
		
		if(val < Arr[i]){
			System.out.println("\n New value is less than current value, can’t be inserted");
			return Arr;
		}
		
		Arr[i] = val;
		
		while ( (i > 1) && (Arr[i/2] < Arr[i])){
			
			swap(Arr, i/2, i);
			
	        i = i/2;
		}
		
		System.out.println("After insert: " + java.util.Arrays.toString(Arr));
		
		return Arr;
	}
	
	public static int[] insert_value (int Arr[], int val)
	{
		// create the array 
		int newArray[] = new int[Arr.length + 1]; 

		// copy 
		System.arraycopy(Arr, 0, newArray, 0, Arr.length);
		
		newArray[ newArray.length - 1] = -1;  //assuming all the numbers greater than 0 are to be inserted in queue.
	    Arr = increase_value(newArray, newArray.length - 1, val);
	    
	    return Arr;
	}
	
	public static void main(String[] args){
		//Integer[] arr = new Integer[] { 3, 2, 1, 5, 4 };
		MyPriorityQueue mpq = new MyPriorityQueue();
		
		int arr[] = {8,7,4,3,1};
		
        arr = mpq.insert_value(arr, 6);
        arr = mpq.insert_value(arr, 3);
        arr = mpq.insert_value(arr, 12);
        
        mpq.extract_maximum(arr);
        mpq.maximum(arr);
        
	}

}
