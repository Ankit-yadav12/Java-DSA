package BinaryTree;

public class BtreeDiameter {

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

    static int height(Node root){
        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh,rh)+1;
    }
    
    static int diameter(Node root){
        if(root==null) return 0;
        
        int ld = diameter(root.left);
        int rd = diameter(root.right);
        int lh = height(root.left);
        int rh = height(root.right);

        int selfHeight = lh + rh + 1;
        return Math.max(selfHeight, Math.max(ld,rd));
        
    }

    public static void main ( String args[]){
        //creating the binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right =new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        int treeDia = diameter(root);
        System.out.println("diameter of the binary tree : " +treeDia); 
    }
}
