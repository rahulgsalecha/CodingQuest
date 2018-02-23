package intvw;

public class Multiply2nosWithoutUsingOperand {
	
	/* function to multiply two numbers x and y*/
	public static int multiply(int x, int y)
	{
	   /* 0  multiplied with anything gives 0 */
	   if(y == 0) {
	     return 0;
	   }
	 
	   /* Add x one by one */
	   if(y > 0 ){
	     return (x + multiply(x, y-1));
	   }
	  
	  /* the case where y is negative */
	   if(y < 0 ){
		   return -multiply(x, -y);
	   }
	   return -1;
	   
	}
	 
	public static void main(String[] args)
	{
	  System.out.println("\n Result for 5*11 : " + multiply(5, 11));
	  System.out.println("\n Result for 4*-11 : " + multiply(4, -11));
	}

}
