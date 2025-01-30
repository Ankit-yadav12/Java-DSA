import java.util.ArrayList;

class Node{
    int data;
    Node left;
    Node right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}


public class DistanceBtwNodes {
    //function for finding the path of the numbers;
    public static boolean findPath(Node root, int num, ArrayList<Node> path){
        if(root == null  ){
            return false;
        }
        path.add(root);

        if(root.data == num){
            return true;
        }

        boolean left = findPath(root.left, num, path);
        boolean right = findPath(root.right, num, path);

        if(left || right){
            return true;
        }

        path.remove(root);
        return false;

    }
    
    //function for finding the Last Common Ancestor.
    public static Node findLca(Node root, int num1, int num2){
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        findPath(root, num1, path1);
        findPath(root, num2, path2);

        // for(int j = 0;j<path1.size();j++){
        //     System.out.println(path1.get(j).data);
        // }


        int i = 0;
        Node lca = null;
        for(; i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
            lca = path1.get(i);
        }
        return lca;
    }

    //function for calculating distance from lca to node.
    public static int calcDistance(Node lca, int num){
        if(lca == null){
            return -1;
        }if(lca.data==num){
            return 0;
        }

        int left = calcDistance(lca.left, num);
        int right = calcDistance(lca.right, num);

        if(left== -1 && right == -1){
            return -1;
        }else if(left== -1){
            return right+1;
        }else{
            return left+1;
        }
    }
    
    //function for finding the shortest path between the nodes.
    public static int Distance( Node root, int num1,  int num2){
        
        Node lca =findLca(root, num1, num2) ;
        int lDistance = calcDistance(lca, num1);
        int rDistance = calcDistance(lca, num2);

        return  lDistance + rDistance ;
    }

    public static void main(String[] args) {
        //creating the binary tree.
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        //calling the function for calcultating the distance between two nodes.
        int distance = Distance(root, 4, 7);
        System.out.println("Minimum distance between the two nodes is : " + distance);
    }
}
