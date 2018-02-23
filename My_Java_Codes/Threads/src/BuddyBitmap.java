import java.lang.reflect.Array;
import java.util.Arrays;

/* 	buddy system bitmap problem:
 * 
 
    Given a complete binary tree with nodes of values of either 1 or 0, the following rules always hold:
    (1) a node's value is 1 if and only if all its subtree nodes' values are 1
    (2) a leaf node can have value either 1 or 0
    Implement the following 2 APIs:
    set_bit(offset, length), set the bits at range from offset to offset+length-1
    clear_bit(offset, length), clear the bits at range from offset to offset+length-1
    
    i.e. The tree is like:
                 0
              /     \
             0        1
           /  \      /  \
          1    0    1    1
         /\   / \   / 
        1  1 1   0 1
        Since it's complete binary tree, the nodes can be stored in an array:
        [0,0,1,1,0,1,1,1,1,1,0,1] 
        
*/
public class BuddyBitmap {
	
	public static int[] getRange(int start, int length) {
	    int[] range = new int[length - start + 1];
	    for (int i = start; i <= length; i++) {
	        range[i - start] = i;
	    }
	    return range;
	}
	
	public static int[] set_bit_down(int[] A, int x, int n){
		if (x>=n)
	        return A;
		
	    if (2*x+1<=n && A[2*x+1]==0){
	        A[2*x+1]=1;
	        set_bit_down(A,2*x+1,n);
	    }
	    if (2*x+2<=n && A[2*x+2]==0){
	        A[2*x+2]=1;
	        set_bit_down(A,2*x+2,n);
	    }
	    return A;
		
	}
	
	public static int[] set_bit(int[] A, int pos, int length){
		int x = 0;
		
		if(A.length == 0 || pos < 0 || length <= 0) {
			return A;
		}
		
		int n = A.length -1; //last index of A
		int[] range = getRange(pos, Math.min(n+1,Math.min(pos+length, 2*pos+1)));
		//System.out.println("Set Range : "+Arrays.toString(range));
		for (int i=0; i < range.length; i++) {
			
			x = range[i];
			
			//Set Self
			if (A[x] == 1)
	            continue;
	        A[x]=1;
	        
	       //Set Descendants
	        A = set_bit_down(A,x,n);
	       
	      //Set Ancestors
	        while (x>0){
	            // make sure its sibling is 1, if its sibling is 0, cannot set ancestors
	        	// check left or right child by using % key and then check content of that child
	            if ((x%2==0 && A[x-1]==1) || (x%2==1 && x<n && A[x+1]==1)){
	                A[(x-1)/2] = 1;
	            }
	            x = (x-1)/2;
	        }
		
		}
		return A;

	}
	
	public static int[] clear_bit(int[] A, int pos, int length){
		int x = 0;
		
		if(A.length == 0 || pos < 0 || length <= 0) {
			return A;
		}
		
		int n = A.length -1; //last index of A
		int[] range = getRange(pos, Math.min(n+1, pos+length));
		//System.out.println("Clear Range : "+Arrays.toString(range));
		
		for (int i=0; i < range.length; i++) {
			
			x = range[i];
			
			//Clear Self
			if (A[x] == 0)
	            continue;
	        A[x]=0;
	        
	       //Set Descendants
	        while (2*x+1<=n){
	            A[2*x+1] = 0;
	            x=2*x+1;
	        }
	       
	      //Set Ancestors
	        while (x>0){
	            if (A[(x-1)/2]==0)
	                break;
	            
	            A[(x-1)/2] = 0;
	            x = (x-1)/2;
	        }
		
		}
		return A;
		
	}
	
	public static void main(String args[]){
		int pos = 0, length = 0;
		pos = 0;
		length = 8;
		
		
		int[] A = new int[]{0,0,1,1,0,1,1,1,1,1,0,1};
		A = set_bit(A,pos, length);
		System.out.println("After setting bit from "+ pos + " for " + length + ", A is: " + Arrays.toString(A));
		
		int[] B = new int[]{0,0,1,1,0,1,1,1,1,1,0,1};
		B = clear_bit(B,pos, length);
		System.out.println("After clearing bit from "+ pos + " for " + length + ", B is: " + Arrays.toString(B));
	}

}

// Output
/* Python Code
 def setbit_down(A, x, n):
    if x>=n:
        return
    if 2*x+1<=n and A[2*x+1]==0:
        A[2*x+1]=1
        setbit_down(A,2*x+1,n)
    if 2*x+2<=n and A[2*x+2]==0:
        A[2*x+2]=1
        setbit_down(A,2*x+2,n)
    

def set_bit(A, pos, length):
    if not A or pos<0 or length<=0:
        return
    n = len(A)-1    #last index of A
    for x in range(pos, min(n+1,min(pos+length, 2*pos+1))):
        # set self
        if A[x] == 1:
            continue
        A[x]=1
        # set descendants
        setbit_down(A,x,n)
        # set ancestors
        while x>0:
            # make sure its sibling is 1, if its sibling is 0, cannot set ancestors
            if (x%2==0 and A[x-1]==1) or (x%2==1 and x<n and A[x+1]==1):
                A[(x-1)/2] = 1
            x = (x-1)/2

def clear_bit(A, pos, length):
    if not A or pos<0 or length<=0:
        return
    n = len(A)-1    #last index of A
    for x in range(pos, min(n+1, pos+length)):
        # clear self
        if A[x]==0:
            continue
        A[x]=0
        # clear descendants
        while 2*x+1<=n:
            A[2*x+1] = 0
            x=2*x+1
        # clear ancestors
        while x>0:
            if A[(x-1)/2]==0:
                break
            A[(x-1)/2] = 0
            x = (x-1)/2
                
if __name__=='__main__':
    A=[0,0,1,1,0,1,1,1,1,1,0,1]
    test_cases = [(x,y) for x in range(len(A)) for y in range(1,len(A)-x+1)]
    
    for each_test_case in test_cases:
        pos, length = each_test_case        
        A=[0,0,1,1,0,1,1,1,1,1,0,1]
        set_bit(A,pos, length)
        print 'after setting bit from ', pos, 'for ', length,'A is: ', A
        A=[0,0,1,1,0,1,1,1,1,1,0,1]
        clear_bit(A,pos, length)
        print 'after clearing bit from ', pos, 'for ', length,'A is: ', A
 */
/*
after setting bit from  0 for  1 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  0 for  2 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  0 for  3 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  0 for  4 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  0 for  5 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  0 for  6 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  0 for  7 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  0 for  8 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  0 for  9 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  0 for  10 A is: [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                             
after setting bit from  0 for  11 A is: [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                             
after setting bit from  0 for  12 A is: [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                             
after setting bit from  1 for  1 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  1 for  2 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  1 for  3 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  1 for  4 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  1 for  5 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  1 for  6 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  1 for  7 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  1 for  8 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  1 for  9 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  1 for  10 A is: [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                             
after setting bit from  1 for  11 A is: [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                             
after setting bit from  2 for  1 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]                                                                                              
after setting bit from  2 for  2 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]                                                                                              
after setting bit from  2 for  3 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  2 for  4 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  2 for  5 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  2 for  6 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  2 for  7 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  2 for  8 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  2 for  9 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  2 for  10 A is: [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                             
after setting bit from  3 for  1 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]                                                                                              
after setting bit from  3 for  2 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  3 for  3 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  3 for  4 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  3 for  5 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  3 for  6 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  3 for  7 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1] 
after setting bit from  4 for  1 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  4 for  2 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  4 for  3 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  4 for  4 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  4 for  5 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  4 for  6 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  4 for  7 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  4 for  8 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  5 for  1 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]                                                                                              
after setting bit from  5 for  2 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]                                                                                              
after setting bit from  5 for  3 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]                                                                                              
after setting bit from  5 for  4 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]                                                                                              
after setting bit from  5 for  5 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]                                                                                              
after setting bit from  5 for  6 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  5 for  7 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  6 for  1 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]                                                                                              
after setting bit from  6 for  2 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]                                                                                              
after setting bit from  6 for  3 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]                                                                                              
after setting bit from  6 for  4 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]                                                                                              
after setting bit from  6 for  5 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  6 for  6 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  7 for  1 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]                                                                                              
after setting bit from  7 for  2 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]                                                                                              
after setting bit from  7 for  3 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]                                                                                              
after setting bit from  7 for  4 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  7 for  5 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  8 for  1 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]                                                                                              
after setting bit from  8 for  2 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]                                                                                              
after setting bit from  8 for  3 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  8 for  4 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  9 for  1 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]                                                                                              
after setting bit from  9 for  2 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]            
after setting bit from  9 for  3 A is:  [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                              
after setting bit from  10 for  1 A is: [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                             
after setting bit from  10 for  2 A is: [1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]                                                                                             
after setting bit from  11 for  1 A is: [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]
*/

/*
after clearing bit from  0 for  1 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]
after clearing bit from  0 for  2 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]
after clearing bit from  0 for  3 A is:  [0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0]
after clearing bit from  0 for  4 A is:  [0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0]
after clearing bit from  0 for  5 A is:  [0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0]
after clearing bit from  0 for  6 A is:  [0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0]
after clearing bit from  0 for  7 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0]
after clearing bit from  0 for  8 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0]
after clearing bit from  0 for  9 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0]
after clearing bit from  0 for  10 A is: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
after clearing bit from  0 for  11 A is: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
after clearing bit from  0 for  12 A is: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
after clearing bit from  1 for  1 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]
after clearing bit from  1 for  2 A is:  [0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0]
after clearing bit from  1 for  3 A is:  [0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0]
after clearing bit from  1 for  4 A is:  [0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0]
after clearing bit from  1 for  5 A is:  [0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0]
after clearing bit from  1 for  6 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0]
after clearing bit from  1 for  7 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0]
after clearing bit from  1 for  8 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0]
after clearing bit from  1 for  9 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
after clearing bit from  1 for  10 A is: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
after clearing bit from  1 for  11 A is: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
after clearing bit from  2 for  1 A is:  [0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0]
after clearing bit from  2 for  2 A is:  [0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0]
after clearing bit from  2 for  3 A is:  [0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0]
after clearing bit from  2 for  4 A is:  [0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0]
after clearing bit from  2 for  5 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0]
after clearing bit from  2 for  6 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0]
after clearing bit from  2 for  7 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0]
after clearing bit from  2 for  8 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
after clearing bit from  2 for  9 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
after clearing bit from  2 for  10 A is: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
after clearing bit from  3 for  1 A is:  [0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1]
after clearing bit from  3 for  2 A is:  [0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1]
after clearing bit from  3 for  3 A is:  [0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 0, 0]
after clearing bit from  3 for  4 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0]
after clearing bit from  3 for  5 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0]
after clearing bit from  3 for  6 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0]
after clearing bit from  3 for  7 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
after clearing bit from  3 for  8 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
after clearing bit from  3 for  9 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
after clearing bit from  4 for  1 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]
after clearing bit from  4 for  2 A is:  [0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0]
after clearing bit from  4 for  3 A is:  [0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0]
after clearing bit from  4 for  4 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0]
after clearing bit from  4 for  5 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0]
after clearing bit from  4 for  6 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
after clearing bit from  4 for  7 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
after clearing bit from  4 for  8 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
after clearing bit from  5 for  1 A is:  [0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0]
after clearing bit from  5 for  2 A is:  [0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0, 0]
after clearing bit from  5 for  3 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0]
after clearing bit from  5 for  4 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0]
after clearing bit from  5 for  5 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
after clearing bit from  5 for  6 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
after clearing bit from  5 for  7 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
after clearing bit from  6 for  1 A is:  [0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1]
after clearing bit from  6 for  2 A is:  [0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1]
after clearing bit from  6 for  3 A is:  [0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1]
after clearing bit from  6 for  4 A is:  [0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1]
after clearing bit from  6 for  5 A is:  [0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1]
after clearing bit from  6 for  6 A is:  [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
after clearing bit from  7 for  1 A is:  [0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1]
after clearing bit from  7 for  2 A is:  [0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1]
after clearing bit from  7 for  3 A is:  [0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1]
after clearing bit from  7 for  4 A is:  [0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1]
after clearing bit from  7 for  5 A is:  [0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0]
after clearing bit from  8 for  1 A is:  [0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1]
after clearing bit from  8 for  2 A is:  [0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1]
after clearing bit from  8 for  3 A is:  [0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1]
after clearing bit from  8 for  4 A is:  [0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0]
after clearing bit from  9 for  1 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1]
after clearing bit from  9 for  2 A is:  [0, 0, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1]
after clearing bit from  9 for  3 A is:  [0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0]
after clearing bit from  10 for  1 A is: [0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]
after clearing bit from  10 for  2 A is: [0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0]
after clearing bit from  11 for  1 A is: [0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0]
*/