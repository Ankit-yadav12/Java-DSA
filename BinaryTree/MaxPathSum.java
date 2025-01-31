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

public class MaxPathSum {

    //creating the function for finding maximum path sum.
    public static int maxSum(Node root, int max){
        if(root==null){
            return 0;
        }

        int leftSum = maxSum(root.left, max);
        int rightSum= maxSum(root.right,max);

        max = Math.max(max, Math.max((leftSum+rightSum+root.data), Math.max(leftSum,rightSum)));
        return max;
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
        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);
        
       

        // print orignal tree
        System.out.println("Orignal tree:"+ "\n");
        printTree(root, "", "",true);

        // calling the function for mirroring the Binary Tree.
        int max = maxSum(root, Integer.MIN_VALUE);      
        System.out.println("Max path sum : " + max);
        
    }
}
