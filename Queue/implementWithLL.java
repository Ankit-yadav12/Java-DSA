package Queue;

public class implementWithLL {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head;
        static Node tail;

        public static boolean isEmpty() {
            return head == null & tail == null;
        }

        public static void enque(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        public static int deque() {
            if (isEmpty()) {
                System.out.println("The queue is empty");
                return -1;
            }
            int temp = head.data;
            if (head == tail) {
                head = tail = null;
                return temp;
            }

            head = head.next;
            return temp;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("The queue is empty");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue();
        q.enque(1);
        q.enque(2);
        q.enque(3);
        q.enque(4);

        System.out.println("front element: " + q.peek());
        while (!q.isEmpty()) {
            System.out.println("removed : " + q.deque());
        }

    }
}
