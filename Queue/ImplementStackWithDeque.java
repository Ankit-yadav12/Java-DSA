package Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementStackWithDeque {

    static class Queue{
        static Deque<Integer> q = new ArrayDeque<>();

        public void add(int data){ q.addLast(data);}
        public int remove(){
            return q.removeFirst();
        }
        public int peek(){
            return q.peekFirst();
        }
        public boolean isEmpty(){
            return q.isEmpty();
        }
    }

    public static void main(String args[]){
        Queue queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println(queue.peek());
        queue.isEmpty();
        while(!queue.isEmpty()) System.out.print(queue.remove() + "  ");
    }
    
}
