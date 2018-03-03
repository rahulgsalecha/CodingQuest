import java.io.*;
import java.util.*;

class QueueUsingTwoStacks {
    
    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>(); 

    public void enqueue(int item) {
        stack1.push(item);
    }

    public int dequeue() {

        if(stack1.isEmpty() && stack2.isEmpty()) {
            System.out.println("Q is empty");
            System.exit(0);
        }
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        } 
        
        int x = stack2.pop();
        return x;
    }

    public static void main(String[] args){
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeue : " + queue.dequeue());
        System.out.println("Dequeue : " + queue.dequeue());
    }
}
/*
 * Output:
 * Dequeue : 10
 * Dequeue : 20
 */
