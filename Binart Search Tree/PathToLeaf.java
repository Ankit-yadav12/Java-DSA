import java.util.ArrayList;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.right = null;
    }
}

public class PathToLeaf {
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

    public static void printPath(Node root, ArrayList<Integer> path){
        if(root==null){
            return;

        }

        path.add(root.data);

        if(root.left==null && root.right== null){
            printThisPath(path);
        }

        printPath(root.left, path);
        printPath(root.right, path);
        path.remove(path.size()-1);
    }

    public static void printThisPath( ArrayList<Integer> path){
        for(int i = 0;i<(path.size());i++){
            System.out.print(path.get(i) + "->");
        }System.out.println("null");
    }


    public static void main(String Args[]){
        Node root = null;
        int[] arr = { 5, 4, 1, 2, 3, 8, 9, 6, 7 };

        for (int i = 0; i < arr.length; i++) {
            root = buildTree(root, arr[i]);
        }

        printTree(root);
        System.err.println();

        ArrayList<Integer> path= new ArrayList<>();
        printPath(root, path);

    }
}
