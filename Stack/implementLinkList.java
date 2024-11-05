package Stack;

public class implementLinkList {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    
    static class stack{
        Node head = null;

        public boolean isEmpty(){
            return head == null;
        }

        public void push(int data){
            Node newNode = new Node(data);

            if(isEmpty()){
                head = newNode;
                return;
            }

            newNode.next = head;
            head = newNode;
        }

        public int pop(){
            if(isEmpty()){
                return -1;
            }

            int top = head.data;
            head =  head.next;
            return top;
        }

        public int peek(){
            return head.data;
        }


        public static void main(String[] args) {
            stack s = new stack();
            System.out.println(s.isEmpty());

            s.push(1);
            s.push(2);
            s.push(3);
            s.push(4);
            s.push(5);

            while(s.isEmpty()!= true){
                System.out.println("removed: " + s.peek());
                s.pop();
            }
    
            System.out.println(s.isEmpty());
        }
    }
    
}
