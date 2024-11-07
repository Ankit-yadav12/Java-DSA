public class sorting {
    //print array
    public static void print(int array[]){
        for(int i = 0 ; i<array.length;i++){
            System.out.print(array[i]+ "  ");
        }System.out.println();
    }
    //bubble sort
    public static void BubbleSort(int array[]){
        int n = array.length;
        for (int i = 0; i <= n-1;i++){
            for (int j = 0 ;j< n-1-i;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j]= temp;
                }
            }
        }
        print(array);
    }
    //insertion sort
    public static void insertionSort( int array[]){
        int n = array.length;
        for(int i = 1;i<n;i++){
            int curr =array[i] ;
            int prev = i-1;
            while (prev>=0 && array[prev]>curr) {
                array[prev+1] = array[prev];
                prev--;
            }

           array[prev+1] = curr;
        }
        print(array);
    }

    // function for performing linear seach
    public static int ls(int arr[], int target){
        if (arr.length==0)
            return -1;

        for (int i = 0; i<arr.length;i++){
            int element = arr[i];
            if (element == target)
                return i;
        }
        return -1;
    }

    //selection sort
    public static void selectionSort(int array[]){
        int n = array.length;
        for(int i = 0;i<= n-1;i++){
            int smallestIndex= 0;
            int smallest = Integer.MAX_VALUE;
            for(int j = i;j<=n-1;j++){
                if ( array[j]< smallest){
                    smallest = array[j];
                    smallestIndex = j;
                }
            }int temp = array[i];
            array[i]=array[smallestIndex];
            array[smallestIndex]= temp;
        }
        print(array);
    }

    //mergesort
    public static void mergesort(int array[], int si, int ei){
        //base case
        if(si>=ei){
            return;
        }
        int mid = si + (ei - si)/2;
        mergesort(array,si,mid); //left sub array
        mergesort(array, mid+1, ei); // right sub array

        merge(array,si,mid, ei);
    }

    public static void merge(int array[], int si, int mid, int ei){
        int temp[] = new int[ei -si +1];
        int i = si;
        int j = mid+1;
        int k = 0;

        while(i<=mid && j<=ei){
            if(array[i]<array[j]){
                temp[k] = array[i];
                i++;
            }else{
                temp[k] = array[j];
                j++;
            }
            k++;
        }

        while(i<= mid){
            temp[k++] = array[i++];
        }

        while(j<= ei){
            temp[k++] = array[j++];
        }

        for(k = 0; k<temp.length; k++ ){
            array[si +k] = temp[k];
        } 
    }

    public static void quicksort(int array[], int si, int ei){
        //base case
        if(si>=ei){
            return;
        }
        int partitionIndex= partition(array,si,ei);
        quicksort(array, si, partitionIndex -1);
        quicksort(array, partitionIndex+1,ei);
        }
    
    public static int partition(int array[], int si, int ei){
        int pivot = array[ei];
        int i = si-1;
        for(int j = si;j<ei;j++){
            if(array[j]<= pivot){
                i++;

                int temp = array[j];
                array[j] = array[i];
                array[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        array[ei] = array[i];
        array[i] = temp;
        return i;
        
    }
    //main function
    public static void main(String[] args) {
        
        //bubblesort
        System.out.println("bubble sort");
        int array[] = { 5, 4, 1, 3, 2};
        BubbleSort(array);
        

        // insertion sort
        System.out.println("insertion sort");
        int array1[] = { 5, 4, 1, 3, 2, 6, 9};
        insertionSort(array1);
        

        // linear search
        System.out.println("linear search");
        int array2[] = { 5, 4, 1, 3, 2, 6, 9, 8, 7};
        System.out.println("target found at index : " + ls(array2,3));

        // selection sort
        System.out.println("selection sort");
        selectionSort(array2);
        

        // mergesort
        System.out.println("merge sort");
        int array3[] = {99, 5, 4, 1, 3, 2, 6, 9, 8, 7};
        mergesort(array3, 0,array3.length-1);
        print(array3);

        // Quicksort 
        System.out.println("Quicksort");
        int array4[] = {99, 5, 4, 1, 3, 2, 6,101, 9, 8, 7};
        quicksort(array4, 0, array4.length - 1);
        print(array4);
    }

}
