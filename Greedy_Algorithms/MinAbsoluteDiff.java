package Greedy_Algorithms;

import java.util.Arrays;

public class MinAbsoluteDiff {

    public static void main(String args[]) {
        int a[] = { 1, 2, 3 };
        int b[] = { 4, 1, 3 };

        Arrays.sort(a);
        Arrays.sort(b);

        int mindiff;
        mindiff = 0;
        for (int i = 0; i < a.length; i++) {
            mindiff += Math.abs(a[i] - b[i]);
        }

        System.out.println("Minimum absolute difference is : "+ mindiff);
    }

}
