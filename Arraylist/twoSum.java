package Arraylist;
import java.util.*;

public class twoSum {
    
    public static void findPairs(ArrayList<Integer> list, int target){
        int start = 0, end = list.size() -1;
        while (start<end) {
            int currSum = list.get(start) + list.get(end);
            if(currSum == target){
                System.out.println(list.get(start) + " " + list.get(end));
                return;
            }

            if(currSum<target)
                start++;
            else    
                end--;
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        int target = 4;

        findPairs(list, target);
    }
}
