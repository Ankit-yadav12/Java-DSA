package Queue;

import java.util.*;

public class FirstNonRepeatingLetter {

    static void firstNonRepeatingLetter(String str) {
        Queue<Character> q = new ArrayDeque<>();
        int frequency[] = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char ch =str.charAt(i);
            q.add(ch);
            frequency[(ch-'a')]+=1;

            while (!q.isEmpty() && frequency[q.peek()-'a'] > 1)
                q.remove();
            if (q.isEmpty())
                System.out.println(-1);
            else 
                System.out.println(q.peek());
           
        }

    }

    public static void main(String args[]) {

        String str = "aabccxb";

        firstNonRepeatingLetter(str);
    }

}
