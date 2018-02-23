
public class MaxSubArraySum {
	
	/* Below is a O(1) dynamic programming solution ( keep in mind)
	 * public int maxSubArray(int[] A) {
       int newsum=A[0];
       int max=A[0];
       for(int i=1;i<A.length;i++){
           newsum=Math.max(newsum+A[i],A[i]);
           max= Math.max(max, newsum);
       }
       return max;
    	}
	 */
	
	public class MaxSubArrayTuple{
		int sum;
		int right;
		int left;
		
		MaxSubArrayTuple(int s, int l, int r){
			sum = s;
			left = l;
			right= r;
		}
	}
	
	public static int max(int a, int b, int c) { 
		return Math.max(Math.max(a, b), c); 
	}
	
	public static MaxSubArrayTuple maxCrossingSum(int arr[], int l, int m, int h){
		
		MaxSubArrayTuple msat = null;
		//Include elements on left of mid
		int sum = 0;
		int left_sum = -1;
		int max_left = 0;
		for(int i = m; i>=l; i--){
			sum = sum + arr[i];
			if(sum > left_sum){
				left_sum = sum;
				max_left = i;
			}
		}
		
		//Include elements on right of mid
		sum = 0;
		int right_sum = -1;
		int max_right = 0;
		
		for(int j = m+1; j<=h; j++){
			sum = sum + arr[j];
			if(sum > right_sum){
				right_sum = sum;
				max_right = j;
			}
		}
		
		msat.left = max_left;
		msat.right = max_right;
		msat.sum = left_sum + right_sum;
		
		return msat;
	}
	
	public static MaxSubArrayTuple maxSubArraySum(int arr[], int l, int h){
		
		//Base Case : Only one element
		if(l==h) {
			MaxSubArrayTuple msat = null;
			msat.left = l;
			msat.right = h;
			msat.sum = arr[l];
			return msat;
		}
		
		// Find middle point
		int m = (l+h) /2;
		
		/* Return maximum of following three possible cases
	      a) Maximum subarray sum in left half
	      b) Maximum subarray sum in right half
	      c) Maximum subarray sum such that the subarray crosses the midpoint */
		
		MaxSubArrayTuple msat_left = maxSubArraySum(arr, l, m);
		MaxSubArrayTuple msat_right = maxSubArraySum(arr, m+1, h);
		MaxSubArrayTuple msat_cross = maxCrossingSum(arr, l, m, h);
		
		
		if ((msat_left.sum >= msat_right.sum) && (msat_left.sum >= msat_cross.sum)){
			return msat_left;
		} else if ((msat_right.sum >= msat_left.sum) && (msat_right.sum >= msat_cross.sum)){
			return msat_right;
		} else {
			return msat_cross;
		}
		
		
	}
	
	public static void main(String args[]){
		int arr[] = {-2, 3, -4, 5, 7};
		MaxSubArrayTuple max_sub_aaray_sequence = maxSubArraySum(arr, 0, arr.length-1);
		
		System.out.println("Maximum contiguous subsequence is: ");
		for(int i = max_sub_aaray_sequence.left; i < max_sub_aaray_sequence.right; i++ ){
			System.out.print(arr[i] +" ");
		}
		System.out.println("Maximum contiguous sum is: "+ max_sub_aaray_sequence.sum);
	}

}
