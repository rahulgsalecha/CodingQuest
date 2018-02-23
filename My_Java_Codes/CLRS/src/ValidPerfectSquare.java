
public class ValidPerfectSquare {
	
	public static boolean hasIntegerSquareRoot(int n) {
	    // implementation here
	    int temp = 1;

	    while(n > 0 ) {
	        n -= temp;
	        temp += 2;
	    }

	    if ( n == 0 ) {
	        return true;
	    } else {
	        return false;
	    }

	}

	public static void main(String args[]){
		for(int i=0; i<= 25; i++){
			boolean isValidSquareRoot = hasIntegerSquareRoot(i);
			if(isValidSquareRoot) {
				System.out.println(" " + i + " is a valid square root");
			} else {
				System.out.println(" " + i + " is not a valid square root");
			}
		}
	}

}
