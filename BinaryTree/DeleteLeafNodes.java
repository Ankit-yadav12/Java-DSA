class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class DeleteLeafNodes {

    //creating the function for delelting the leaf Nodes;
    public static Node deleteLeaf(Node root, int num){
        if(root==null) return null;
        
        
        root.left= deleteLeaf(root.left, num);
        root.right= deleteLeaf(root.right, num);
        
        if(root.data == num&& root.left==null && root.right==null) return null;

        return root;
    }

    //Creating the function for printing the binary tree
    public static void printTree(Node root, String spacing, String branch, Boolean isRoot){
        if(root==null) return;

        printTree(root.right, spacing+"    ", "/---", false);
        System.out.println(spacing + (isRoot ? "" : branch)+ root.data);
        printTree(root.left , spacing+"    ", "\\---", false);

    }
    
    public static void main(String args[]){
        // creating the binary tree.
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(3);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        
       

        // print orignal tree
        System.out.println("Orignal tree:"+ "\n");
        printTree(root, "", "",true);

        // calling the function for mirroring the Binary Tree.
        int num = 3;
        root = deleteLeaf(root, num);

        // calling the function for printing the mirrored binary tree.
        System.out.println("\n"+ "Binary tree after deletion: " + "\n");
        printTree(root, "", "", true);
    }
}
