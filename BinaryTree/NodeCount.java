package BinaryTree;

public class NodeCount {
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

    static int nodeCount(Node root){
        //function for finding the height of the binary tree
        if(root==null) return 0;

        int lc = nodeCount(root.left);
        int rc = nodeCount(root.right);

        return (lc + rc + 1);
    }

    public static void main(String args[]){
        //creating the binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right =new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        int count = nodeCount(root);
        System.out.println("Node count of binary tree :" + count);
    }

}
