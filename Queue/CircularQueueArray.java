package Queue;

public class CircularQueueArray {

    static class Queue {
        static int queue[];
        static int rear;
        static int front;
        static int size;

        Queue(int n) {
            queue = new int[n];
            size = n;
            front= -1;
            rear = -1;
        }

        public boolean isEmpty() {
            return rear == -1;
        }

        public void enque(int data) {
            if(isfull()) {
                System.out.println("queue is full");
                return;
            }
            else {
                if(front == -1) front=0;
                
                rear = (rear+1)%size;
                queue[rear] = data;
            }
        }

        public int dequeue() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            } else { 
                if(rear==front) {
                    int temp =  queue[front];
                    rear=front=-1;
                    return temp;
                }

                int temp = queue[front];
                front = (front+1)%size;

                return temp;
            }
        }
        
        public boolean isfull(){
            return front==(rear+1)%size;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return queue[front];
        }

        public void print() {
            if (isEmpty()) { 
                System.out.println("Queue is empty"); 
                return; 
            }
            int temp = front;
            while(true){
                System.out.print(queue[temp] + " ");
                if(temp == rear) break;
                temp = (temp+1)%size;
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue(5);
        q.dequeue();
        q.peek();
        q.enque(1);
        q.enque(2);
        q.enque(3);
        q.enque(4);
        q.enque(5);
        q.enque(6);

        q.print();

        System.out.println("element removed : " + q.dequeue());
        System.out.println("top element is : " + q.peek());
        ;

    }

}
