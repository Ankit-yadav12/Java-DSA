package Greedy_Algorithms;

import java.util.Arrays;
import java.util.Comparator;

public class MaxChainLength {

    public static void main(String[] args) {
        //Array declaration and initialization for the pairs
        int pairs[][] = {{5, 24},{39, 60}, {5, 28}, {27, 40}, {50, 90}};

        //sorting the array in ascending order of endtime.
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

        //finding the max chain length.
        int chainLength = 1;
        int chainEnd = pairs[0][1];
        for(int i = 1;i<pairs.length;i++){
            if(pairs[i][0]>chainEnd){
                chainLength++;
                chainEnd = pairs[i][1];
            }
        }

        System.out.println("Max length of the chain is : " + chainLength);
    }
    
}
