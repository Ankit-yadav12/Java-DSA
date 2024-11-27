package Greedy_Algorithms;

import java.util.Arrays;
import java.util.Collections;

public class Chocolate {

    public static void main(String args[]) {
        int m = 4, n = 6;
        Integer verticalCut[] = { 2, 1, 3, 1, 4 };
        Integer horizontalCut[] = { 4, 1, 2 };

        Arrays.sort(verticalCut, Collections.reverseOrder());
        Arrays.sort(horizontalCut, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 1, vp = 1;
        int cost = 0;

        while (h < horizontalCut.length && v < verticalCut.length) {
            if (verticalCut[v] <= horizontalCut[h]) {
                cost += (horizontalCut[h] * vp);
                hp++;
                h++;
            } else {
                cost += (verticalCut[v] * hp);
                vp++;
                v++;
            }
        }

        while (h < horizontalCut.length) {
            cost += (horizontalCut[h] * vp);
            hp++;
            h++;
        }
        while (v < verticalCut.length) {
            cost += (verticalCut[v] * hp);
            vp++;
            v++;
        }

        System.out.println("totol cost : " + cost);
    }

}
