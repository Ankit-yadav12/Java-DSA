package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementWithDeque {
    
    static class Stack{
        static Deque<Integer> stk = new ArrayDeque<>();

        public void add(int data){ stk.addLast(data);}
        public int remove(){
            return stk.removeLast();
        }
        public int peek(){
            return stk.peekLast();
        }
        public boolean isEmpty(){
            return stk.isEmpty();
        }
    }

    public static void main(String args[]){
        Stack stack = new Stack();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);

        System.out.println(stack.peek());
        stack.isEmpty();
        while(!stack.isEmpty()) System.out.print(stack.remove() + "  ");
    }
}
