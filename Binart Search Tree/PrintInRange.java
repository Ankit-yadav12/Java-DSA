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

public class PrintInRange {
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

    public static void printRange(Node root, int num1, int num2){
        if(root==null){
            return;
        }
        if(root.data>=num1 && root.data<= num2){
            printRange(root.left, num1, num2);
            System.out.print(root.data+ " ");
            printRange(root.right, num1, num2);
        }else if(root.data<num1){
            printRange(root.right, num1, num2);
        }else{
            printRange(root.left, num1, num2);
        }
    }

    public static void main(String Args[]){
        Node root = null;
        int[] arr = { 5, 4, 1, 2, 3, 8, 9, 6, 7 };

        for (int i = 0; i < arr.length; i++) {
            root = buildTree(root, arr[i]);
        }

        printTree(root);
        System.err.println();

        printRange(root, 2,7);

    }
}
