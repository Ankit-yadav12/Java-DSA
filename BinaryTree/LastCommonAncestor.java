import java.util.ArrayList;
public class LastCommonAncestor {

    // defining the structure of the Binary Tree.
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


//Approach 1;
    // defining find path for finding the path of the node.
    public static boolean findPath(int num, ArrayList<Node> path, Node root) {
        if(root == null){
            return false;
        }
        path.add(root);

        if (root.data == num){
            return true;
        }
            
        boolean left = findPath(num, path, root.left);
        boolean right = findPath(num, path, root.right);

        if (left || right) {
            return true;
        }

        path.remove(path.size()-1);
        return false;

    }

    // function for finding the LCA.
    public static Node findLCA(int num1, int num2, Node root) {
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        findPath(num1, path1, root);
        findPath(num2, path2, root);

        // Last Common Ancestor
        int i = 0;
        Node lca = null;
        for(;i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
            lca= path1.get(i);
        }

        return lca;
    }


//Approach 2;
    public static Node lca2(Node root, int num1, int num2){
        //checks if the root is null, base case
        if(root==null || root.data == num1 || root.data == num2){
            return root;
        }

        //finding the elements in left and right subtree
        Node left = lca2(root.left, num1, num2);
        Node right = lca2(root.right, num1, num2);

        //generating a conclusion from left and right values above
        if(right== null){
            return left;
        }if(left == null){
            return right;
        }

        return root;
    }

    public static void main(String args[]) {
        // creating the tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right = new Node(3);
        root.right.right = new Node(6);

// calling the function for finding the last common ancestor
        //Approach 1
        Node lca = findLCA(4, 5, root);
        if(lca == null) System.out.println("no common ancestor found");
        else System.out.println("last common ancestor of 4 and 5 is : " + lca.data);

        //Approach 2.
        lca = lca2(root, 4, 6);
        if(lca == null) System.out.println("no common ancestor found");
        else System.out.println("last common ancestor of 4 and 6 is : " + lca.data);

    }
}
