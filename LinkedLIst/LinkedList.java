package LinkedLIst;
public class LinkedList {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int length = 0;
    public Node head;
    public Node tail;

    public void addStart(int data) {
        length++;
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addEnd(int data) {
        length++;
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void addIndex(int i, int data) {
        length++;
        Node newNode = new Node(data);
        Node temp = head;
        int index = 0;
        while (index < i - 1) {
            temp = temp.next;
            index++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    public void print() {
        Node temp = head;
        if (head == null) {
            System.out.println("Linked list is empty.");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null" + "      length = " + length);
    }

    public void removeStart() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.println("removed: " + head.data);
        head = head.next;
        length--;
    }

    public void removeEnd() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head == tail) {
            System.out.println("Removed: " + tail.data);
            head = tail = null;
            length--;
            return;
        }
        System.out.println("removed: " + tail.data);
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        length--;
    }

    public void iterativeSearch(int target) {
        int index = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == target) {
                System.out.println("element found at index: " + index);
                return;
            }
            temp = temp.next;
            index++;
        }
        System.out.println("element not found in linked list.");
    }

    public void recursiveSearch(int target, Node start, int index) {
        if (start == null) {
            System.out.println("element not found in linked list");
            return;
        }
        if (start.data == target) {
            System.out.println("element found at index: " + index);
            return;
        }
        recursiveSearch(target, start.next, index + 1);
    }

    public void reverse() {
        if (head == null || head.next == null) {
            return;
        }
        Node prev = null;
        Node curr = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node temp = head;
        head = tail;
        tail = temp;
        tail.next = null; // Ensure the new tail points to null
    }

    public void removeNth(int index) {
        if (index < 0 || index >= length) {
            System.out.println("index entered is out of bound");
            return;
        }
        if (index == 0) {
            removeStart();
            return;
        }
        Node prev = head;
        Node curr = head;
        int i = 0;
        while (i < index) {
            prev = curr;
            curr = curr.next;
            i++;
        }
        prev.next = curr.next;
        length--;
        if (curr == tail) {
            tail = prev;
        }
    }

    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        Node midNode = findMid(head);
        Node prev = null;
        Node curr = midNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public boolean checkLoop() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public void fixCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                Node prev = fast;
                while (slow != fast) {
                    prev = fast;
                    slow = slow.next;
                    fast = fast.next;
                }
                prev.next = null;
                System.out.println("cycle removed");
                return;
            }
        }
    }

   
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addStart(1);
        ll.addEnd(2);
        ll.addEnd(3);
        ll.addEnd(2);
        ll.addEnd(1);

    //    System.out.println("palindrome : " + ll.checkPalindrome());
        ll.print();
        // Creating a loop
        Node loopStart = ll.head.next.next; // This should be the node with value 3
        ll.tail.next = loopStart; // Making the tail point to the loop start
        
        // To test if the loop is detected
        System.out.println("Loop detected: " + ll.checkLoop());
        ll.fixCycle();
        System.out.println("Loop fixed, rechecking: " + ll.checkLoop());

        ll.print();
    }
}
