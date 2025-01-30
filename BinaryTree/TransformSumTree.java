//defining node class for implementing binary tree;
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

public class TransformSumTree {

    // function for transforming the binary tree into sum tree;
    public static int transform(Node root) {
        if (root == null) {
            return 0;
        }

        int oldValue = root.data;

        int leftSum = transform(root.left);
        int rightSum = transform(root.right);

        root.data = leftSum + rightSum;

        return oldValue + root.data;
    }

    // function for printing the binary tree

    public static void printTree(Node root, String prefix, boolean isTail) {
            if (root.right != null) {
                printTree(root.right, prefix + (isTail ? "│   " : "    "), false);
            }
    
            System.out.println(prefix + (isTail ? "└── " : "┌── ") + root.data);
    
            if (root.left != null) {
                printTree(root.left, prefix + (isTail ? "    " : "│   "), true);
            }
    }

    public static void main(String args[]) {
        // creating the binary tree.
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        // calling the function for transforming to sum tree;
        transform(root);

        // calling function for printing the transformed binary tree;
        printTree(root, "", true);
    }
}
