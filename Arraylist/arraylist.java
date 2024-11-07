package Arraylist;
import java.util.*;

public class arraylist{

    public static void print(ArrayList<Integer> list){
        System.out.print("array : ");
        for(int i = 0 ;i<list.size();i++){
            System.out.print(list.get(i));
            System.out.print(" ");
        }System.out.println();
    }

    public static void printReverse(ArrayList<Integer> list){
        System.out.print("Reversed array : ");
        for(int i = list.size()-1;i>=0;i--){
            System.out.print(list.get(i));
            System.out.print(" ");
        }System.out.println();
    }

    public static void printMax(ArrayList<Integer> list){
        int max = Integer.MIN_VALUE;
        for(int i = 0 ;i<list.size();i++){
            if(list.get(i)>max){
                max = list.get(i);
            }
        }
        System.out.println("max element : " + max);
    }

    public static void swapElement(ArrayList<Integer> list, int i, int j){
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j,temp);

        System.out.println("swapped arraylist : " + list);
    }
    
    public static void print2dAl(ArrayList<ArrayList<Integer>> list){
        for(int i = 0; i<list.size(); i++){
            ArrayList<Integer> temp = list.get(i);
            for(int j = 0; j< temp.size();j++){
                System.out.print(temp.get(j) + " ");
            }System.out.println();
        }
    }
    
    public static void main(String[] args) {
        ArrayList <Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(10);
        list.add(4);
        list.add(8);
// print arraylist
        print(list);
// print reverse arraylist
        printReverse(list);
// max element in an array
        printMax(list);
// swap two numbers
        swapElement(list, 2, 4);

        list.add(3);
        list.add(5);
// Collections sort
        Collections.sort(list);
        System.out.println(list);

// multi-dimensional array
        ArrayList<ArrayList<Integer>> list2= new ArrayList<>();

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(5);
        list3.add(9);
        list2.add(list3);

        ArrayList<Integer> list4 = new ArrayList<>();
        list4.add(1);
        list4.add(7);
        list2.add(list4);

        // System.out.println(list2);
        print2dAl(list2);
    }
}