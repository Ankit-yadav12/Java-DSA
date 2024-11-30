package BinaryTree;

public class BinaryTreeHeight {
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

    static int FindHeight(Node root){
        //function for finding the height of the binary tree
        if(root==null) return 0;

        int lh = FindHeight(root.left);
        int rh = FindHeight(root.right);

        return Math.max(lh,rh) + 1;
    }

    public static void main(String args[]){
        //creating the binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right =new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        int height = FindHeight(root);
        System.out.println("Height of the binary tree :" + height);
    }

}