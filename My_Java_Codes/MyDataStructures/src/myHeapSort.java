
public class myHeapSort {

	// maxheapify
	// buildmaxheap
	// swap
	// sort
	private static int total;
	
	private static void swap(Comparable[] arr, int a, int b)
    {
        Comparable tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
	
	private static void maxHeapify(Comparable arr[], int i){
		int left = 2*i;
		int right = left + 1;
		int largest = i;
		
		if(left <= total && arr[left].compareTo(arr[largest]) > 0){
			largest = left;
		}
		
		if(right <= total && arr[right].compareTo(arr[largest]) > 0){
			largest = right;
		}
		
		if(largest != i){
			swap(arr, i, largest);
			maxHeapify(arr, largest);
		}
	}
	
	public static void buildMaxHeap(Comparable arr[]){
		total = arr.length - 1;
		
		for (int i = total / 2; i >= 0; i--)  // Build max heap
            maxHeapify(arr, i);
	}
	
	public static void sort(Comparable[] arr){
		buildMaxHeap(arr);
		
		for (int i = total; i > 0; i--) {
			swap(arr, 0, i);
			total--;
			maxHeapify(arr, 0);
		}
	}
	public static void main(String[] args){
		//Integer[] arr = new Integer[] { 3, 2, 1, 5, 4 };
		
		Integer[] arr = new Integer[] {9,2,4,7,3,7,10};
		System.out.println(java.util.Arrays.toString(arr));
        sort(arr);
        System.out.println(java.util.Arrays.toString(arr));
	}
}
