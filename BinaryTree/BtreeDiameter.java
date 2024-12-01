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
    //approach 1
    static int diameter(Node root){
        if(root==null) return 0;
        
        int ld = diameter(root.left);
        int rd = diameter(root.right);
        int lh = height(root.left);
        int rh = height(root.right);

        int selfHeight = lh + rh + 1;
        return Math.max(selfHeight, Math.max(ld,rd));
        
    }

    //Approach 2
    static class Info{
        int diam;
        int ht;

        public Info(int diam,int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }

    static Info diameter2(Node root){
        if(root == null) return new Info(0,0);

        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int dia = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.ht+rightInfo.ht + 1);
        int height  = Math.max(leftInfo.ht, rightInfo.ht) + 1;
        return new Info(dia,height);
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
        System.out.println("Approach 1");
        System.out.println("diameter of the binary tree : " +treeDia); 

        Info temp = diameter2(root);
        System.out.println("Approach 2");
        System.out.println("diameter of binary tree :" + temp.diam);
        System.out.println("Height of binary tree : " + temp.ht);
    }
}
