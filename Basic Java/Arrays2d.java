// import java.util.*;

public class Arrays2d {

    public static void display(int array[] []){
        // Display array
        for(int i = 0; i<array.length;i++){
            for( int j = 0 ;j<array[0].length;j++){
                System.out.print(array[i] [j] + " ");
            }System.out.println();
        }
    }
    
    public static void maxMin(int array[][]){
        int max = 0, min = 999;
        for(int i = 0; i<array.length;i++){
            for( int j = 0 ;j<array[0].length;j++){
                if(array[i] [j]> max)
                    max = array[i] [j];
                if(array[i] [j]<min)
                    min = array[i] [j];
            }
        }
        System.out.println("Max element : " + max );
        System.out.println("Min element : " + min );
    }

    public static void Dsum(int array[][]){
        int Dsum = 0;
        for(int i = 0; i<array.length;i++){
            // for( int j = 0 ;j<array[0].length;j++){
            //     if ( i == j)
            //         Dsum += array[i][j];
            //     else if( i+j ==array.length-1)
            //         Dsum += array[i][j];
            // }

            Dsum += array[i][i];

            if(i!= array.length-1-i)
                Dsum += array[i][array.length-i-1];
        }
        System.out.println("Sum of Diagonal elements is: "+ Dsum);
    }

    public static void Spiral(int array[][]){
        int rowStart= 0, columnStart= 0;
        int rowEnd = array.length-1, columnend = array[0].length-1;
        System.out.print("Spiral: ");
        while(rowStart<=rowEnd && columnStart<=columnend){
            //top
        for(int i = columnStart;i<=columnend;i++){
            System.out.print(array[rowStart][i]+" ");
        }

        //right
        for(int i = rowStart+1;i<=rowEnd;i++){
            System.out.print(array[i][columnend]+" ");
        }

        //bottom
        for(int j = columnend-1;j>=columnStart;j--){
            System.out.print(array[rowEnd][j]+" ");
        }

        //left
        for(int j = rowEnd-1;j>rowStart;j--){
            System.out.print(array[j][columnStart]+" ");
        }
        

        rowStart++;
        columnStart++;
        rowEnd--;
        columnend--;
        }
    }

    public static void searchStaircase( int array[][],int target){
        int Row = 0;
        int Column = array[0].length-1;
        System.out.println();
        while (Row<array.length &&  Column >= 0){
            if(array[Row][Column]==target){
                System.out.println("Element found at indes : [" + Row + " ," + Column + " ]" );
                return;}
            if(array[Row][Column]<target)
                Row++;
            else
                Column--;
        }
        System.out.println(" Element not found in the array.");
    }

    public static void transpose(int array[][]){
        for(int i = 0;i<array.length;i++){
            for(int j = i;j<array[0].length;j++){
                if( i==j)
                    continue;
                else{
                    int temp = array[i][j];
                    array[i][j] = array[j][i];
                    array[j][i] = temp ;
                }
            }
        }
        display(array);
    }
    

    public static void main(String[] args) {
        
        //Scanner object creation
        // @SuppressWarnings("resource")
        // Scanner input = new Scanner(System.in) ;
        // create a 2- dimensional array
        int array[] [] = {{10, 20, 30, 40},
                          {15, 25, 35, 45},
                          {27, 29, 37, 48},
                          {32, 33, 39, 50}};

        // // entering data in the array
        // System.out.print("Enter 9 elements: ");
        // for(int i = 0; i<array.length;i++){
        //     for( int j = 0 ;j<array[0].length;j++){
        //         array[i] [j] = input.nextInt();
        //     }
        // }

        display(array);
        maxMin(array);
        Dsum(array);
        Spiral(array);
        searchStaircase(array, 48);
        transpose(array);
    }
}
