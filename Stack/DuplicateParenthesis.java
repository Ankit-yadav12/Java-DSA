package Stack;

import java.util.Stack;

public class DuplicateParenthesis {

    public static String checkDuplicate(String str) {
        Stack<Character> stk = new Stack<>();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ')') {

                while (!stk.isEmpty() && stk.peek() != '(') {
                    stk.pop();
                    count++;
                }
                if (count < 1)
                    return "Duplicate Parenthesis found";
                stk.pop();
                count = 0;
            } else
                stk.push(ch);
        }
        return "No Duplicate Parenthesis found";
    }

    public static void main(String agrs[]) {
        String str = "(((a+b)+(c)))";
        String result = checkDuplicate(str);
        System.out.println(result);
    }

}
