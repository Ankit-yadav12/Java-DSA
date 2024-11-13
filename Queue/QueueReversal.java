package Queue;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Stack;

public class QueueReversal {

    static void reverse(Queue<Integer> queue){
        Stack<Integer> stk = new Stack<>();
        while(queue.size()!= 0) stk.push(queue.remove());
        while(!stk.isEmpty()) queue.add(stk.pop());

    } 

    public static void main(String args[]){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);

        reverse(queue);

        while(!queue.isEmpty()) System.out.println(queue.remove() + " ");
    }
    
}
