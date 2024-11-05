package Stack;

import java.util.ArrayList;

public class implementArrayList {
    
    static class stack{
        static ArrayList<Integer> stk = new ArrayList<>();
        static int top= -1;
        public boolean isEmpty(){
            return (stk.size()==0);
        }

        public void push(int data){
            stk.add(data);
            top++;
        }

        public int pop(){
            int temp = stk.get(top);
            stk.remove(stk.get(top));
            top--;
            return temp;
            
        }

        public int peek(){
            return stk.get(top);
        }
    }
    public static void main(String[] args) {
        stack s = new stack();

        System.out.println(s.isEmpty());
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);

        while(s.isEmpty()!= true){
            System.out.println("removed: " + s.peek());
            s.pop();
        }

        System.out.println(s.isEmpty());


    }
}
