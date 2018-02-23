
public  class BinaryTree {

	static class BinaryTreeNode {
		int key;
		BinaryTreeNode left, right;
		
		BinaryTreeNode(int value){
			key = value;
			left = right = null;
		}
	}
	
	// Root of Binary Tree
	static BinaryTreeNode root;
 
    // Constructors
	BinaryTree(int key)
    {
        root = new BinaryTreeNode(key);
    }
 
	BinaryTree()
    {
        root = null;
    }
 
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
 
        /*create root*/
        tree.root = new BinaryTreeNode(1);
 
        /* following is the tree after above statement
 
              1
            /   \
          null  null     */
 
        tree.root.left = new BinaryTreeNode(2);
        tree.root.right = new BinaryTreeNode(3);
 
        /* 2 and 3 become left and right children of 1
               1
             /   \
            2      3
          /    \    /  \
        null null null null  */
 
 
        tree.root.left.left = new BinaryTreeNode(4);
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
         */
    }

}


