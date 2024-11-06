package Stack;
import java.util.Stack;

public class NextGreaterElement {
    
    public static void nextGreaterElement(int numbers[], int nextGreater[]){
        Stack<Integer> stk= new Stack<>();

        for(int j =numbers.length-1;j>=0;j--){
            while(!stk.isEmpty() && stk.peek()<numbers[j]){
                stk.pop();
            }
            if(stk.isEmpty()){
                nextGreater[j] = -1;
            }else{
                nextGreater[j] = stk.peek();
            }

            stk.push(numbers[j]);
        }
    }

    public static void main(String args[]){
        int numbers[] = {6, 8, 0, 1, 3};
        int nextGreater[] = new int[numbers.length];
        nextGreaterElement(numbers, nextGreater);

        for(int i = 0; i<nextGreater.length;i++){
            System.out.print(nextGreater[i] + "  ");
        }
    }
}
