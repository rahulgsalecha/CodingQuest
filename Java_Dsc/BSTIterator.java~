import java.util.*;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BSTIterator {

    static Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public static boolean hasNext() {
        return !stack.isEmpty();
    }

    public static int next() {
        TreeNode node = stack.pop();
        int ret = node.val;
        if(node.right != null) {
            node = node.right;
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        return ret;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        BSTIterator i = new BSTIterator(root);
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
