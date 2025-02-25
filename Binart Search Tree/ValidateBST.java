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

public class ValidateBST {
    public static Node buildTree(Node root, int num) {
        if (root == null)
            return root = new Node(num);
        if (root.data == num)
            return root;

        if (root.data < num)
            root.right = buildTree(root.right, num);
        else
            root.left = buildTree(root.left, num);
        return root;
    }

    public static void printTree(Node root) {
        if (root == null)
            return;

        printTree(root.left);
        System.out.print(root.data + "  ");
        printTree(root.right);
    }

    public static boolean validate(Node root, Node min , Node max){
        if (root == null) {
            return true;
        }

        if ((min != null && root.data <= min.data) || (max != null && root.data >= max.data)) {
            return false;
        }

        return validate(root.left, min, root) && validate(root.right, root, max);
    }


    public static void main(String Args[]){
        Node root = null;
        int[] arr = {4,3,6,1,2,5,7};

        for (int i = 0; i < arr.length; i++) {
            root = buildTree(root, arr[i]);
        }

        printTree(root);
        System.err.println();

        boolean isBST = validate(root,null,null);
        System.out.println("BST is valid:" + isBST);
        
    }
}
