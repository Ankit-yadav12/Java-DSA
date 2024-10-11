package Arraylist;
import java.util.*;

public class mostWater{

// Bruteforce solution time complexity = O(n^2)
    public static void  bruteForce( ArrayList<Integer> list){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<list.size();i++){
            for(int j = list.size()-1;j>= 0 ;j--){
                int capacity = Math.min(list.get(i), list.get(j)) * (j-i);
                if (capacity>max){
                    max = capacity;
                }
            }
        }
        System.out.println("Most water contained is : " + max);
    }

// Optimized solution time complexity = O()
    public static void optimized(ArrayList<Integer> list){
        int max = Integer.MIN_VALUE, start = 0, end = list.size()-1;
        while(start<=end){
            int waterCapacity = Math.min(list.get(start), list.get(end)) * (end - start);
            if(list.get(end)> list.get(start)){
                start++;
            }else{
                end--;
            }

            if(waterCapacity> max)
                max = waterCapacity;
        }
        System.out.println("max water stored is : " + max);

    }


    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);

        bruteForce(list);
        optimized(list);
    }
}