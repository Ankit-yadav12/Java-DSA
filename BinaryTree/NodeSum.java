package BinaryTree;

public class NodeSum {
    
    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data= data;
            this.left= null;
            this.right=null;
        }
    }
    static int sum= 0;
    static int nodeSum(Node root){
        //function for finding the height of the binary tree
        if(root==null) return 0;

        int ls = nodeSum(root.left);
        int rs = nodeSum (root.right);
        
        return (ls+rs+root.data) ;
    }

    public static void main(String args[]){
        //creating the binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right =new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        int sum = nodeSum(root);
        System.out.println("Node Sum of binary tree :" + sum);
    }

}

