package Queue;

import java.util.*;

public class Interleave2HalfofQueue {

    public static void interleave(Queue<Integer> orignal){
        Queue<Integer> firstHalf = new ArrayDeque<>();
        int n = orignal.size();

        for(int i = 0;i<n/2;i++){
            firstHalf.add(orignal.remove());
        }

        for(int i = 0;i<n/2;i++){
            orignal.add(firstHalf.remove());
            orignal.add(orignal.remove());
        }
    }

    public static void main(String args[]){
        Queue<Integer> orignal = new ArrayDeque<>();
        orignal.add(1);
        orignal.add(2);
        orignal.add(3);
        orignal.add(4);
        orignal.add(5);
        orignal.add(6);
        orignal.add(7);
        orignal.add(8);
        orignal.add(9);
        orignal.add(10);

        interleave(orignal);

        while(orignal.size()!=0) System.out.print(orignal.remove() + " ");
    }
    
}
