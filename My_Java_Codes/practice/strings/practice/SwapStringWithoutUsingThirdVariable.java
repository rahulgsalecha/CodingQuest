package practice;

public class SwapStringWithoutUsingThirdVariable {
	
	public static void main(String[] args) {
        String a = "test";
        String b = "paper";

        a = a + b;
        b = a.substring(0, a.length()  - b.length());
        a = a.substring(b.length(), a.length());

        System.out.println(a + " " + b);
    }


}
