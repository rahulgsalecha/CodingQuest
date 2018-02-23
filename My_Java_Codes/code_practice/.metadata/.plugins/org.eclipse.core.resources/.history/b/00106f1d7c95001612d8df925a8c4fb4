import java.util.Scanner;


public class MyLinearSearch {
	/*
	public static void main(String[] args){
		int[] arr1 = {10,34,2,56,7,67,88,42};
		int key = 11;
		boolean isPresent = doLinearSearch(arr1, key);
		
		if(isPresent){
			System.out.println("Key is present");
		} else {
			System.out.println("Key is not present");
		}
        
	}
	
	public static boolean doLinearSearch(int[] array, int key){
		for(int i:array){
			if(i == key){
				return true;
			}
		}	
		return false;
	}
	*/
	
	public static void main(String args[])
	  {
	    int c, n, search, array[];
	 
	    Scanner in = new Scanner(System.in);
	    System.out.println("Enter number of elements");
	    n = in.nextInt(); 
	    array = new int[n];
	 
	    System.out.println("Enter " + n + " integers");
	 
	    for (c = 0; c < n; c++)
	      array[c] = in.nextInt();
	 
	    System.out.println("Enter value to find");
	    search = in.nextInt();
	 
	    for (c = 0; c < n; c++)
	    {
	      if (array[c] == search)     /* Searching element is present */
	      {
	         System.out.println(search + " is present at location " + (c + 1) + ".");
	          break;
	      }
	   }
	   if (c == n)  /* Searching element is absent */
	      System.out.println(search + " is not present in array.");
	  }

	

}
