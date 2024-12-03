package BinaryTree;

public class IsSubtree {
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

    static Boolean isIdentical(Node node, Node subroot){
        //base code
        if(node==null && subroot==null) return true;

        //trying to find any thing that suggests that both are not identical,
        else if(node==null || subroot==null || node.data!= subroot.data) return false;
        
        //recursively performing the isIdentical function for left and right nodes
        return (isIdentical(node.left, subroot.left) && isIdentical(node.right, subroot.right));
    }

    static Boolean isSubtree(Node root, Node subroot){
        //base case
        if(root == null)  return false;

        //if root and subroot are equal
        else if(root.data==subroot.data){
            return isIdentical(root,subroot);
        }

        //checks for the subroot in left and right subtree of the main binary tree
        return (isSubtree(root.left, subroot) || isSubtree(root.right, subroot));
    }


    public static void main(String args[]){
        //main binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        //subtree
        Node subroot = new Node(2);
        subroot.left = new Node(4);
        subroot.right = new Node(6);

        System.out.println("Is subtree : " + isSubtree(root,subroot));
    }
    
}
