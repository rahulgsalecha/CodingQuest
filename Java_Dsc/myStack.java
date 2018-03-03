/* Java implemtation of myStack Data Structure */
class myStack
{
    static final int MAX = 1000;
    int top = -1;
    int a[] = new int[MAX];

    boolean isEmpty(){
        return top == -1;
    }

    boolean push(int x){
        if(top >= MAX){
            System.out.println("myStack Underflow");
            return false;
        } else {
            a[++top] = x;
            return true;
        }
    }

    int pop(){
        if(isEmpty()){
             System.out.println("myStack Underflow");
             return 0;
        } else {
            int x = a[top--];
            return x;
        }
    }


    public static void main(String args[])
    {
        myStack s = new myStack();
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
    }

}

/*Output:
 * 30 Popped from stack
 */
