package Greedy_Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ActivitySelection {
    public static void main(String args[]){
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};
        ArrayList<Integer> result = new ArrayList<>();

        int mapping[][]  = new int[start.length][3];

        for(int i = 0; i<start.length;i++){
            mapping[i][0] = i;
            mapping[i][1] = start[i];
            mapping[i][2] = end[i];
        }
        
        Arrays.sort(mapping,Comparator.comparingDouble(o -> o[2]));

        //printing orignal inputs
        System.out.println("Activities");
        for(int i = 0; i<start.length;i++){
            System.out.println( mapping[i][0] + " "+ mapping[i][1]+ " "+ mapping[i][2]);
        }

        int prevEndTime = 0;
        for(int i = 0;i<start.length;i++){
            if(mapping[i][1]>prevEndTime){
                result.add( mapping[i][0]);
            }
        }

        //printing selected activities
        System.out.println("Selected Activities : ");
        for(int i = 0;i<result.size();i++){
            System.out.println("A" + result.get(i));
        }


    }
}
