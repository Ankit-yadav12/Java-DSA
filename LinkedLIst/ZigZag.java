package LinkedLIst;

public class ZigZag {

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public int length = 0;
    public static Node head;
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
        System.out.println("null" + " length = " + length);
    }

    public void zigzag(Node head) {
        //finding the mid node
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node leftHead = head;
        Node rightHead = slow.next;
        slow.next = null;

        //reversing the right sub list
        Node prev = null;
        Node curr = rightHead;
        Node next;
        while(curr!= null){
            next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next;
        }
        rightHead = prev;
        
        //adding the elements in zigzag fashion
        Node temp = new Node(-1); // Dummy node to start the merged list 
        Node currTemp = temp;
        while (leftHead != null || rightHead != null) { 
            if (leftHead != null) { 
                currTemp.next = leftHead; 
                leftHead = leftHead.next; 
                currTemp = currTemp.next; 
            } if (rightHead != null) { 
                currTemp.next = rightHead; 
                rightHead = rightHead.next; 
                currTemp = currTemp.next; 
            }
        }
        head = temp.next; 
    }

    public static void main(String[] args) {
        ZigZag ll = new ZigZag();

        ll.addEnd(1);
        ll.addEnd(2);
        ll.addEnd(3);
        ll.addEnd(4);
        ll.addEnd(5);
        ll.addEnd(6);

        ll.print();
        ll.zigzag(head);
        ll.print();
    }
}
