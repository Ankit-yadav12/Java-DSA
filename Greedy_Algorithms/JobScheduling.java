package Greedy_Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class JobScheduling {

    static class Jobs {
        int id;
        int profit;
        int deadline;

        public Jobs(int id, int p, int d) {
            this.id = id;
            this.profit = p;
            this.deadline = d;
        }
    }

    public static void main(String args[]) {
        int jobsInfo[][] = { { 4, 20 }, { 1, 20 }, { 1, 30 }, { 1, 40 } }; // given array
        // method
        // 1////////////////////////////////////////////////////////////////////////////////////
        ArrayList<ArrayList<Integer>> sortedjobsInfo = new ArrayList<>();

        // transferring the info to arraylist
        for (int i = 0; i < jobsInfo.length; i++) {
            ArrayList<Integer> job = new ArrayList<>(Arrays.asList(i, jobsInfo[i][0], jobsInfo[i][1]));
            sortedjobsInfo.add(job);
        }

        sortedjobsInfo.sort((job1, job2) -> job2.get(2) - job1.get(2)); // sorting the info based on the profit
        int time = 0;

        System.out.println("selected jobs: "); // selecting and displaying the jobs
        for (ArrayList<Integer> curr : sortedjobsInfo) {
            if (time < curr.get(1)) {
                time++;
                System.out.print(" Job" + curr.get(0));
            }
        }

        // method 2 using object and
        // classes//////////////////////////////////////////////////////////////////
        ArrayList<Jobs> sortedJobs = new ArrayList<>();
        for (int i = 0; i < jobsInfo.length; i++) {
            sortedJobs.add(new Jobs(i, jobsInfo[i][1], jobsInfo[i][0]));
        }

        Collections.sort(sortedJobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        time = 0;
        System.out.println();
        System.out.println("Selected Jobs : ");
        for (Jobs curr : sortedJobs) {
            if (time < curr.deadline) {
                time++;
                seq.add(curr.id);
                System.out.print(" Job" + curr.id);
            }
        }
    }

}
