
public class AddBinaryNumbers {
	public static void main(String[] args){
		int[] a = {0,0,0,1};
		int[] b = {0,0,1,0};
		
		int[] c = new int[a.length+1];
		
		int carry = 0;
		
		
		for (int i = a.length -1 ; i >= 0; i--) {
			c[i+1] = (a[i] + b[i] + carry) % 2; // remainder
			carry = (a[i] + b[i] + carry) / 2; // quotient
		}
		
		c[0] = carry;
		
		for (int j = 0; j < c.length; j++){
			System.out.print(c[j]);
		}
		
	}
}
