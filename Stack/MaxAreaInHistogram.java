package Stack;

import java.util.Stack;

public class MaxAreaInHistogram {

    public static int maxAreaRectangle(int height[]) {
        Stack<Integer> stk = new Stack<>();
        int maxArea = 0, i;

        // Left smallest bar
        int lsr[] = new int[height.length];
        for (i = 0; i < height.length; i++) {
            while (!stk.isEmpty() && height[stk.peek()] >= height[i]) {
                stk.pop();
            }
            if (stk.isEmpty())
                lsr[i] = -1;
            else
                lsr[i] = stk.peek();
            stk.push(i);
        }

        // Right smallest bar
        stk = new Stack<>();
        int rsr[] = new int[height.length];
        for (i = height.length - 1; i >= 0; i--) {
            while (!stk.isEmpty() && height[stk.peek()] >= height[i]) {
                stk.pop();
            }
            if (stk.isEmpty())
                rsr[i] = height.length;
            else
                rsr[i] = stk.peek();
            stk.push(i);
        }

         // Max Area
        for (i = 0; i < height.length; i++) {
            int width = rsr[i] - lsr[i] - 1;
            int area = height[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    public static void main(String args[]) {
        int height[] = { 2, 1, 5, 6, 2, 3 };
        int maxArea = maxAreaRectangle(height);
        System.out.println(" Max area is : " + maxArea);
    }

}
