//defining the node class for implementing binary tree
class Node{
    int data;
    Node left;
    Node right;
    
    public Node(int data){
        this.data = data;
        this.left = null;
        this.right= null;
    }
}

public class kthAncestorOfNode {
    
    //function for finding the kth ancestor of a given node;
    public static int kthAncestor(Node root, int num, int k ){
        if(root==null){
            return -1;
        }
        if(root.data==num){
            return 0;
        }


        int left = kthAncestor(root.left, num, k);
        int right = kthAncestor(root.right, num, k);

    
        if(left==-1 && right == -1 ){
            return -1;
        }

        int max = Math.max(left,right);
        if(max+1 ==k){
            System.out.println("The " + k + "-th ancestor of node " + num + " is: " + root.data);
            return -1;
        }
        return max+1;
    }

    public static void main(String args[]){
        //creating the binary tree.
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        //function call;
        kthAncestor(root, 7, 2);
    }
}
