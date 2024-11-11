package Queue;

import java.util.Stack;

public class implementWith2stacks {

    static class Queue{
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();
    
        static boolean isEmpty(){
            return s1.isEmpty();    
        }

        static void push(int data){
            while(!s1.isEmpty()) s2.push(s1.pop());
            s1.push(data);
            while(!s2.isEmpty()) s1.push(s2.pop());
        }

        static int remove(){
            if(isEmpty()){
                System.out.println(" Empty queue");
                return -1;
            }
            return s1.pop();
        }

        static int peek(){
            if(isEmpty()){
                System.out.println(" Empty queue");
                return -1;
            }
            while(!s1.isEmpty()) s2.push(s1.pop());
            int front = s2.peek();
            while(!s2.isEmpty()) s1.push(s2.pop());
            return front;
        }
    }

    public static void main(String args[]){
        Queue.remove();
       
        Queue.push(1);
        Queue.push(2);
        Queue.push(3);
        Queue.push(4);
        Queue.push(5);
        
        while(!Queue.isEmpty()){
            System.out.println(Queue.remove());
        }
        Queue.peek();
    }
    
}
