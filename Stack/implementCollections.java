package Stack;

import java.util.Stack;

public class implementCollections {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
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
