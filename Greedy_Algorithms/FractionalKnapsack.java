package Greedy_Algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

    public static void main(String args[]){
        int val[] = {60, 100, 120};
        int weight[] = {10, 20, 30};
        int W = 30;

        //new 2d array for storing the indexex and the weight:profit ratio.
        double ratio[][] = new double[val.length][2];

        //Storing the values in ratio table
        for ( int i = 0; i<val.length;i++){
            ratio[i][0]=i;
            ratio[i][1]=val[i]/(double)weight[i];
        }

        //sorting the ratio's in ascending order.
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

        int capacity =W;
        int profit = 0;
        //filling the weights
        for(int i = ratio.length-1;i>0;i--){
            int index = (int)ratio[i][0];
            if(capacity>=weight[index]){
                profit += val[index];
                capacity -= weight[index];
            }else{
                profit += ((ratio[index][1])*capacity);
                capacity = 0;
                break;
            }
        }

        System.out.println("Maximum obtainable profit : " + profit);
    }
    
}
