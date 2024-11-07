public class recursion {
    
    public static void printAscending(int num){
        if(num>1){
            printAscending(num -1);
        }
        System.out.print(num + " ");
    }

    public static int factorial(int num){
        
        if(num==1){
            return 1;
        }
        int fact= num * factorial(num-1);
        return fact;

    }

    public static int nsum(int num){
        if(num==1){
            return 1;
        }
        int sum = num + nsum(num-1);
        return sum;
    }

    public static int nthFibbonaci(int num){
        if(num==0 || num==1){
            return num;
        }
        int fib1 = nthFibbonaci(num -1);
        int fib2 = nthFibbonaci(num-2);
        int fib = fib1+ fib2;
        return fib;  
    }

    public static Boolean isSorted(int array[], int i){
        if(i == array.length -1){
            return true;
        }
        if(array[i]>array[i+1]){
            return false;
        }
        isSorted(array, i+1);
        return isSorted(array, i+1);
    }

    public static int firstOccurence(int array[], int key, int i){
        if(array[i] == key){
            return i;
        }
        if(i == array.length-1){
            return -1;
        }
        return firstOccurence(array, key, i+1);
    }

    public static int lastOccurence(int array[], int key , int i){
        if(array[i] == key){
            return i;
        }
        if(i == 0){
            return -1;
        }
        return lastOccurence(array, key, i-1);
    }

    public static int expo(int base, int power){
        if(power == 0){
            return 1;
        }
        
        int result = expo(base, power/2) * expo(base, power/2);
        
        
        if(power%2!=0){
            result = base * result;
        }
        return result;
    }
 
    public static int tilling(int n){
        if(n==0 || n==1){
            return 1;
        }
        int ways = tilling(n-1)+ tilling(n -2);
        return ways;
    }
 
    public static int nFriends(int n){
        //base case 
        if (n==1 || n==2){
            return n;
        }
        int single = nFriends(n-1);
        int pair = nFriends(n-2);
        int totalWays = pair * (n-1);

        int finalResult = single + totalWays;
        return finalResult;
    }

    public static void binarySequence(int n, int lastDigit, String str){
        if(n==0){
            System.out.println(str);
            return;
        }
        binarySequence(n-1,0,str+"0");
        if(lastDigit==0){
            binarySequence(n-1, 1, str+"1");
        }

    }

    public static void main(String[] args){
        //print ascending numbers
        printAscending(10);
        System.out.println();

        //print factorial of a number
        System.out.println("factorial : " +factorial(5));

        // Print sum of n natural numbers.
        System.out.println("sum : " + nsum(55));

        // Pring nth fibbonacci number
        System.out.println("nth fibbonacci number : "+ nthFibbonaci(7));

        // find is array is sorted or not
        int array[] = { 1,1, 2, 3, 4, 5, 1};
        System.out.println(isSorted(array, 0));

        // first occurence of a element in array;
        System.out.println("first occurence : " + firstOccurence(array, 1, 0));

        //last occurence of a element in array.
        System.out.println("last occurence : " + lastOccurence(array, 1, array.length-1));

        //print x to power n.
        System.out.println("result : " + expo(2,10));

        //tilling problem
        System.out.println("max ways of tilling: " + tilling(5));

        //n friends problem
        System.out.println("total ways of n friend :" + nFriends(3));
        
        // binary numbers of size n without consecutive 1's
        String str="";
        binarySequence(3,0,str);
    }
}
