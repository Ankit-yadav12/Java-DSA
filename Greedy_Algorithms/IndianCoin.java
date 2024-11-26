package Greedy_Algorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class IndianCoin {
    static final int currency[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };

    static void findCoin(int amount, ArrayList<Integer> coins) {
        int remainingAmount = amount;
        
        int length = currency.length-1;
        while (remainingAmount != 0) {
            if (currency[length] > remainingAmount)
                length--;
            else {
                remainingAmount -= currency[length];
                coins.add(currency[length]);
            }
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
