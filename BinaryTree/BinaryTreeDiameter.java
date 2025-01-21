//Node class for implementing the binary tree.
class Node{
    int data;
    Node left;
    Node right;

    //constructor for Node class.
    public Node (int data){
        this.data = data;
        left = null;
        right = null;
    }
}

public class BinaryTreeDiameter {
    Node root = null;

    static class Info{
        int diameter;
        int height;

        public Info(int diameter, int height){
            this.diameter = diameter;
            this.height = height;
        }
    }

    public Info diameter(Node root){
        if(root== null){
            return new Info(0,0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diameter = Math.max(leftInfo.diameter,Math.max(rightInfo.diameter, leftInfo.height+rightInfo.height+1));
        int height = Math.max(leftInfo.height, rightInfo.height) +1;

        return new Info(diameter,height);
    }

    public static void main(String args[]){
        //creating the binary tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right =new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        BinaryTreeDiameter b1 = new BinaryTreeDiameter();
        Info result = b1.diameter(root);
        System.out.println(" Height of binary tree is : "+ result.height);
        System.out.println("Diameter of the Binary Tree :" + result.diameter);
    }
}
