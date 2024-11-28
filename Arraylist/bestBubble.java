package Arraylist;
import java.util.*;

public class bestBubble {
    public static boolean isBeautifulArray(ArrayList<Integer> list) {
        boolean ascending = true;
        boolean descending = true;

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                ascending = false;
            }
            if (list.get(i) > list.get(i - 1)) {
                descending = false;
            }
        }
        return ascending || descending;
    }

    public static int minSwapsToBeautiful(ArrayList<Integer> nums) {
        if (isBeautifulArray(nums)) {
            return 0; // Already beautiful
        }

        // Calculate swaps to ascending order
        ArrayList<Integer> ascendingNums = new ArrayList<>(nums);
        Collections.sort(ascendingNums);
        int ascSwaps = minSwaps(nums, ascendingNums);

        // Calculate swaps to descending order
        ArrayList<Integer> descendingNums = new ArrayList<>(nums);
        descendingNums.sort(Collections.reverseOrder());
        int descSwaps = minSwaps(nums, descendingNums);

        return Math.min(ascSwaps, descSwaps);
    }

    public static int minSwaps(ArrayList<Integer> nums, ArrayList<Integer> target) {
        int n = nums.size();
        boolean[] visited = new boolean[n];
        int swapCount = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || nums.get(i).equals(target.get(i))) {
                continue;
            }

            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                int pos = target.indexOf(nums.get(j));
                j = pos;
                cycleSize++;
            }

            if (cycleSize > 0) {
                swapCount += (cycleSize - 1);
            }
        }

        return swapCount;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(4, 5,3, 2, 1));
        System.out.println("Minimum swaps to beautify the array: " + minSwapsToBeautiful(nums));
    }
}
