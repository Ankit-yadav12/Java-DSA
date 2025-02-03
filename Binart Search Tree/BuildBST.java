class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        this.left= null;
        this.right = null;
    }
}
public class BuildBST{

    public static Node buildTree(Node root, int num){
        if(root== null){
            root = new Node(num);
            return root;
        }

        if(root.data==num){
            return root;
        }

        if(root.data<num){
            root.right = buildTree(root.right, num);
        }else{
            root.left= buildTree(root.left, num);
        }
        return root;
    }

    public static void printTree(Node root){
        if(root==null) {
            return;
        }

        printTree(root.left);
        System.out.print(root.data + "  ");
        printTree(root.right);
    }
    public static void main(String args[]){
        Node root=null;
        int[] arr = {5,4,1,2,3,8,9,6,7};
        
        for( int i = 0;i<arr.length;i++){
            root = buildTree(root, arr[i]);
            printTree(root);
            System.out.println();
        }



    }
}