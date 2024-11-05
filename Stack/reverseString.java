package Stack;

import java.util.Stack;

public class reverseString {

    public static void reverse(String str,Stack<Character> stk){
        int index = 0;
        while(index<str.length()){
            stk.push(str.charAt(index));
            index++;
        }
        StringBuilder sb = new StringBuilder("");
        while(!stk.isEmpty()){
            sb = sb.append(stk.pop());
        }
        System.out.println("reversed String = " + sb);
    }

    public static void main(String[] args) {
        Stack<Character> stk = new Stack<>();
        String name = "ankit";
        reverse(name, stk);
    }
}
