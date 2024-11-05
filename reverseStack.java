import java.util.Stack;

public class reverseStack {

    public static void pushBottom(Stack<Integer> s, int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushBottom(s, data);
        s.push(top);
    }

    public static void reverse(Stack<Integer> stk){
        if(stk.isEmpty()) return;
        int top = stk.pop();
        reverse(stk);
        pushBottom(stk, top);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        System.out.println(s.isEmpty());

        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);

        System.out.println(s);
        
        reverse(s);

        System.out.println(s);
    }
    
}
