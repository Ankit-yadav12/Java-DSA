package Arraylist;
import java.util.*;

public class rotated2sum {
    
    public static void findPairs(ArrayList<Integer> list, int target){
        int i = 0, end = list.size() -1, pivot;
        while(i<end){
            if(list.get(i)< list.get(i+1)) i++;
            else {
                pivot = i;
                break;
            }
        }
    }

    public static void main(String[] args) {
        
    }
}
