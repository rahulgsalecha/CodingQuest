class PowerFunction {
    public static float power(float x, int y) {
        float temp;
        if ( y == 0) return 1;
        if ( y == 1) return x;

        temp = power(x, y/2);

        if(y%2 == 0){
            return temp * temp;
        } else {
            if(y > 0) {
                return x*temp*temp;
            } else {
                return (temp * temp) / x;
            }
        }
    }


    public static void main(String[] args){
        float x = 2;
        int y = -3;

        System.out.printf("\nPower of x = 2 and y = -3 is : %.2f\n" , power(x, y));

        x = 2;
        y = 3;

        System.out.printf("\nPower of x = 2 and y = 3 is : %.2f\n" , power(x, y));
    }
}
