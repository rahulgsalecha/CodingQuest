/* Java implemtation of Stack Data Structure */
class Stack
{
    static final int MAX = 1000;
    int top;
    int a[] = new int[MAX];

    boolean isEmpty(){
        return (top < 0);
    }

    boolean push(int x){
        if(top >= MAX){
            System.out.println("Stack Underflow");
            return false;
        } else {
            a[++top] = x;
            return true;
        }
    }

    int pop(){
        if(top<0){
             System.out.println("Stack Underflow");
             return 0;
        } else {
            int x = a[top--];
            return x;
        }
    }


    public static void main(String args[])
    {
        Stack s = new Stack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
    }

}

/*Output:
 * 30 Popped from stack
 */
