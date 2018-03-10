/*Java implementation of Stack using 2 Queues*/
import java.util.*;

class StackUsingTwoQueues {
    LinkedList<Integer> q1 = new  LinkedList<Integer>();
    LinkedList<Integer> q2 = new  LinkedList<Integer>();

    /* Push Element x onto stack */
    public void push(int x) {
        if(q1.isEmpty() & q2.isEmpty()) {
            q1.offer(x);
        } else {
            if(q1.size() > 0) {
                /* Q1 already has some elements */
                /* First add this element to Q2 and then move Q1 elements into Q2 */
                q2.offer(x);
                int size = q1.size();
                while(size > 0) {
                    q2.offer(q1.poll());
                    size--;
                }
            } else if (q2.size() > 0) {
                /* Q1 already has some elements */
                /* First add this element to Q1 and then move Q2 elements into Q1 */
                q1.offer(x);
                int size = q2.size();
                while(size > 0) {
                    q1.offer(q2.poll());
                    size--;
                }
            }
        }
    }
    
    public int pop() {
        int x = -1;
        if(q1.size() > 0) {
            x = q1.poll();
        } else if (q2.size() > 0) {
            x = q2.poll();
        }

        return x; 
    }

    public static void main(String[] args) {
        StackUsingTwoQueues stack = new StackUsingTwoQueues();
        stack.push(10);
        stack.push(100);
        stack.push(1000);
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
    }
}
/* Output :
 *
 * Pop: 1000
 * Pop: 100
 *
 */
