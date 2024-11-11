package Stack;

import java.util.ArrayDeque;
import java.util.Queue;

public class implementWith2queue {
    static class StackA{
        static Queue<Integer> q1 = new ArrayDeque<>();
        static Queue<Integer> q2 = new ArrayDeque<>();

        public boolean isEmpty(){
            return q1.isEmpty();
        }

        public void push(int data){
            while(!q1.isEmpty()) q2.add(q1.remove());
            q1.add(data);
            while(!q2.isEmpty()) q1.add(q2.remove());
        }

        public int pop(){
            if (isEmpty()) { 
                System.out.println("Stack is empty"); 
                return -1; 
            }
            return q1.remove();
        }

        public int peek(){
            if (isEmpty()) { 
                System.out.println("Stack is empty"); 
                return -1; 
            }
            return q1.peek();
        }

    }

    public static void main(String[] args) {
        StackA s = new StackA();
        System.out.println(s.isEmpty());

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println(s);
        
        while(s.isEmpty()!= true){
            System.out.println("removed: " + s.peek());
            s.pop();
        }

        System.out.println(s.isEmpty());
    }
}
