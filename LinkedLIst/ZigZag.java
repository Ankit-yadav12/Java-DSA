package LinkedLIst;
import java.util.Collections;


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
                temp = temp.next; index++; 
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
                temp = temp.next; } 
            System.out.println("null" + " length = " + length);
        }
    public static void main(String[] args) {
        
    }
}
