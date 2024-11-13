package Queue;
import java.util.ArrayDeque;
import java.util.Deque;

public class DoubleEndedQueue {

    public static void main(String[] args) {
        Deque<Integer> d  = new ArrayDeque<>();
        d.addFirst(2 );
        d.addFirst(1);
        d.addLast(3);
        d.addLast(4);

        System.out.println(d.removeLast());
        while(!d.isEmpty()) System.out.println(d.removeFirst());
    }
    
}
