public class trapping_rainwater {

    public static int trappedWater(int arr[])
    {   int n = arr.length;
        int l_bound[] = new int[n], r_bound[] = new int[n], max = 0;

        for(int i = 0; i<n;i++){
            if(arr[i]>max){ max = arr[i];}
            l_bound[i] = max; }
        
        max =0;
        for(int j =n-1;j>=0;j--){
            if(arr[j]>max){max = arr[j];}
            r_bound[j] = max; }

        int sum = 0;
        for (int k =0 ;k<n;k++){
            sum += Math.min(l_bound[k],r_bound[k])- arr[k];
        }
        return sum;
    }

    public static void main(String[] args) {
        int height[]= {4, 2, 0, 6, 3, 2, 5};
        int capacity = trappedWater(height); 
        
        System.out.println("The amount of trapped water : "+ capacity);
    }
}
