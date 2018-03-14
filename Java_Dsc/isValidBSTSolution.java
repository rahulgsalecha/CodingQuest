/*Java implementation for checking if a binary tree is a BST */

public class isValidBSTSolution {

    Node root;

    public static class Node {
        int val;
        Node left, right;

        Node(int x) {
            val = x;
            left = right = null;
        }
    }

    public static boolean isValidBST(Node root) {
        return isValidBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isValidBSTUtil(Node node, int min, int max){ 
        if(node == null) {
            return true;
        }


        if(node.val < min || node.val > max) {
            return false;
        }

        return (isValidBSTUtil(node.left, min, node.val) && isValidBSTUtil(node.right,node.val, max));
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        isValidBSTSolution tree = new isValidBSTSolution();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        //tree.root.left.right = new Node(5); // is not a bst

        if (tree.isValidBST(tree.root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }
}
