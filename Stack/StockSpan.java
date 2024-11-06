package Stack;

import java.util.Stack;

public class StockSpan {

    public static void stockSpan(int Stock[], int span[]) {
        Stack<Integer> stk = new Stack<>();
        span[0] = 1;
        stk.push(0);

        for (int i = 1; i < Stock.length; i++) {
            int curr = Stock[i];
            while (!stk.isEmpty() && curr >= Stock[stk.peek()]) {
                stk.pop();
            }  
            if (stk.isEmpty()) {
                span[i] = i + 1;
            }else{
                int prevHigh = stk.peek();
                span[i] = i-prevHigh;
            }
            stk.push(i);
        }

    }

    public static void main(String[] args) {
        int Stock[] = { 100, 80, 60, 70, 60, 85, 100 };
        int span[] = new int[Stock.length];
        stockSpan(Stock, span);

        for (int i = 0; i < span.length; i++) {
            System.out.println(span[i]);
        }
    }
}
