class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right= null;
    }
}
public class IsUnivalued{

    //defining the function
    public static boolean checkUnivalue(Node root,int data){
        if(root==null){
            return true;
        }
        if(root.data!= data){
            return false;
        }

        return checkUnivalue(root.left, data) && checkUnivalue(root.right, data);
    }


    public static void main(String args[]){

        //creating the binary tree.
        Node root = new Node(1);
        root.left = new Node(1);
        root.right = new Node(1);
        root.left.left = new Node(4);
        root.left.right = new Node(1);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7);

        //function call;
        boolean status = checkUnivalue(root, 1);
        if(status){
            System.out.println("The binary tree is UNIVALUED");
        }else{
            System.out.println("The binary tree is NOT UNIVALUED");
        }
    }
}