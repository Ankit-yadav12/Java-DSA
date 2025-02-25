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

public class deleteNode {
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

    public static Node delNode(Node root, int num) {
        if(root.data<num){
            root.right = delNode(root.right, num);
        }
        else if(root.data>num){
            root.left = delNode(root.left, num);
        }

        else{
            // case1: no child;
            if(root.left==null && root.right== null){
                return null;
            }

            //case2: single child
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.right;
            }

            //case3: both children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right=delNode(root.right, IS.data);
        }

        return root;
    }

    public static Node findInorderSuccessor(Node root){
        while(root.left!= null){
            root= root.left;
        }
        return root;
    }

    public static void main(String args[]) {
        Node root = null;
        int[] arr = { 5, 4, 1, 2, 3, 8, 9, 6, 7 };

        for (int i = 0; i < arr.length; i++) {
            root = buildTree(root, arr[i]);
        }

        printTree(root);

        // calling function to delete a node
        int num = 5;
        root = delNode(root, num);

        printTree(root);
    }
}
