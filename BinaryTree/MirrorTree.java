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

public class MirrorTree {
    // function for mirroring the Binary Tree.
    public static void mirror(Node root) {
        if (root == null) {
            return;
        }
        Node newLeft = root.right;
        Node newRight = root.left;

        root.left = newLeft;
        root.right = newRight;

        mirror(root.left);
        mirror(root.right);
    }

    // function for printing the binary tree.
    public static void printTree(Node root, String spacing, String branch, boolean isRoot) {
        if (root == null) {
            return;
        }
    
        // Print the right subtree with an added line for hierarchy
        printTree(root.right, spacing + (isRoot ? "" : "    "), " /--", false);
    
        // Print the current node with the branch line, except for the root node
        System.out.println(spacing + (isRoot ? "" : branch) + root.data);
    
        // Print the left subtree with an added line for hierarchy
        printTree(root.left, spacing + (isRoot ? "" : "    "), " \\--", false);
    }

    public static void main(String Args[]) {
        // creating the binary tree.
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

       

        // print orignal tree
        // printTree(root, "", "",true);

        // calling the function for mirroring the Binary Tree.
        mirror(root);

        // calling the function for printing the mirrored binary tree.
        printTree(root, "", "", true);
    }
}
