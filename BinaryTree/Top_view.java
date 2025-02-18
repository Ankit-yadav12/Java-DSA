import java.util.*;

public class Top_view {
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info{
        int hd;
        Node node;

        public Info(int hd, Node node){
            this.hd = hd;
            this.node = node;
        }
    } 

    static void tview( Node root){
        HashMap<Integer,Node> map = new HashMap<>();
        Queue<Info> q = new LinkedList<>();

        q.add(new Info(0,root));
        q.add(null);
        int min = 0, max = 0;
        
        //this part of the code keeps the track of the levels of the binary tree
        while(!q.isEmpty()){
            Info curr = q.remove();
            

            if(curr!=null){
                if(!map.containsKey(curr.hd)){
                    map.put(curr.hd, curr.node);
                }
    
                if(curr.node.left!= null){
                    q.add(new Info(curr.hd-1, curr.node.left));
                    min = Math.min(curr.hd-1,min);
                }
    
                if(curr.node.right!= null){
                    q.add(new Info(curr.hd+1,curr.node.right));
                    max = Math.max(curr.hd+1,max);
                }
            }
                       
            
        }

        for(int i = min;i<=max;i++){
            System.out.print(map.get(i).data + " ");
        }
    }



    public static void main(String args[]){
        //creating the binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        //function for finding and printing the top view of the binary tree
        tview(root);
    }
}
