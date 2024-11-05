package Stack;

import java.util.Stack;

public  class pushAtBottom {
    
    public static void pushBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushBottom(s, data);
        s.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        System.out.println(s.isEmpty());

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        pushBottom(s,0);
        
        System.out.println(s);
        
        while(s.isEmpty()!= true){
            System.out.println("removed: " + s.peek());
            s.pop();
        }

        System.out.println(s.isEmpty());
    }
}
