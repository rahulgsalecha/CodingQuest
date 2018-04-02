import java.util.Queue;
import java.util.LinkedList;

class levelOrderTraversalOfTree {

    public Node root;

    public static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static void printLevelOrderTraversalofTree(Node root){
        if(root == null) {
            System.out.println("Tree is Null");
            return;
        }
        
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.println(node.val + " ");
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right !=null) {
                queue.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        levelOrderTraversalOfTree tree = new levelOrderTraversalOfTree();

        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        printLevelOrderTraversalofTree(tree.root);

    }
}
