package Queue;

public class ImplementWithArray {

    static class Queue{
        static int queue[];
        static int rear;
        static int size;

        Queue(int n){
            queue = new int[n];
            size = n;
            rear = -1;
        }

        public boolean isEmpty(){
            return rear==-1;
        }

        public void enque(int data){
            if(rear==size-1) System.out.println("Queue is full");
            else {
                rear +=1;
                queue[rear] = data;
            }
        }

        public int dequeue(){
            if(isEmpty()){
                System.out.println("queue is empty");
                return -1;
            }else{
                int front = queue[0];
                for(int i = 0 ;i<rear;i++){
                    queue[i] = queue[i+1];
                }
                rear -=1;
                return front;
            }
        }

        public int peek(){
            return queue[0];
        }

        public void print(){
            for(int i = 0;i<=rear;i++){
                System.out.print(queue[i] + "  ");
            }
            System.out.println();
        }
    }


    public static void main(String args[]){
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
        System.out.println("top element is : " + q.peek());;

        


    }
    
}
