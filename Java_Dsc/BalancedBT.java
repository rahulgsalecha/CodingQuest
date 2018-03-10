import java.lang.Math;

public class BalancedBT {


    public static class BTNode {
        int val;
        BTNode left, right;

        BTNode(int x){
            val = x;
        }
    }

    public static boolean isBalanced(BTNode root) {
        if ( root == null ) {
            return true;
        }

        if( getHeight(root) == -1) {
            return false;
        } 

        return true;
    }

    public  static int getHeight(BTNode root) {
        if ( root == null) {
            return 0;
        }

        int left = getHeight(root.left);
        int right = getHeight(root.right);

        if(left == -1 || right == -1)
            return -1;

        if ( Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left,right) + 1;
    }

    public static boolean isBalancedBTSol2(BTNode root) {
        return (isBalancedBTSol2iUtil(root) >= 0);
    }

    public static int isBalancedBTSol2iUtil(BTNode root) {
        if(root == null) {
            return 0;
        }

        int left = isBalancedBTSol2iUtil(root.left);
        int right = isBalancedBTSol2iUtil(root.right);

        if (left < 0 || right < 0 || Math.abs(left-right) > 1) {
            return -1;
        }

        return Math.max(left,right)+1;
    }



    public static void main(String args[])
    {

        BTNode tree = new BTNode(1);
        /* Constructed binary tree is
         *         1
         *        /   \
         *       2      3
         *      /  \    /
         *     4    5  6
         *    / 
         *    7         
         */
        tree.left = new BTNode(2);
        tree.right = new BTNode(3);
        tree.left.left = new BTNode(4);
        tree.left.right = new BTNode(5);
        tree.right.right = new BTNode(6);
        tree.left.left.left = new BTNode(7);

        BalancedBT tree_bt = new BalancedBT();
        if (tree_bt.isBalanced(tree))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");

        BTNode tree_sol2 = new BTNode(1);
        tree_sol2.left = new BTNode(2);
        tree_sol2.right = new BTNode(3);
        tree_sol2.left.left = new BTNode(4);
        tree_sol2.left.right = new BTNode(5);
        tree_sol2.left.left.left = new BTNode(8);

        BalancedBT tree_bt_sol2 = new BalancedBT();

        if(tree_bt_sol2.isBalancedBTSol2(tree_sol2))
           System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }
}

/* Output
 * Tree is balanced
 * Tree is not balanced
 */
