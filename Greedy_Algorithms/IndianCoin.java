package Greedy_Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class IndianCoin {
    static final int currency[] = {2000, 500, 100, 50, 20, 10, 5, 2, 1};

    static void findCoin(int amount, ArrayList<Integer> coins) {
        int remainingAmount = amount;
        
        for(int i : currency){
            if(remainingAmount>=i){
                remainingAmount  -= i;
                coins.add(i);
            }
            if(remainingAmount==0) break;
        }
    }

    //fuction for printing the arraylist
    static void print(ArrayList<Integer> coins) {
        int length = coins.size();
        if (length <= 0)
            System.out.println("Amount should be greater than Zero ");
        for (int i = 0; i < length; i++) {
            System.out.print(coins.get(i)+" ");
        }
    }

    public static void main(String args[]) {
        ArrayList<Integer> coins = new ArrayList<>();
        Scanner input = new Scanner(System.in); // creating the scanner object
        System.out.print("Enter the amount :");
        int amount = input.nextInt();
        input.close();

        findCoin(amount, coins);// finding the coins to be given
        print(coins); // printing the result
    }
}
