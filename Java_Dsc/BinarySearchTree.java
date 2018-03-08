/* Java implementation of Binary Search Tree */

class BST {

    class BSTNode {
        int val;
        BSTNode left, right;

        public BSTNode(int item) {
            val = item;
            right = left = null;
        }
    }

    public static BSTNode root;

    BST() {
        root = null;
    }

    public boolean search(int key) {
        BSTNode current = root;
        while(current != null) {
            if(current.val == key) {
                return true;
            } else if (current.val > key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return false;
    }

    public void insert(int key) {
        BSTNode node = new BSTNode(key);
        if(root == null){
            root = node;
            return;
        }

        BSTNode current = root;
        BSTNode parent = null;

        while(true){
            parent = current;
            if(current.val < key) {
                current = current.left;
                if(current == null) {
                    parent.left = node;
                    return;
                }
            } else {
                current = current.right;
                if(current == null) {
                    parent.right = node;
                        return;
                }
            }
        }
    }

    public boolean delete(int key) {
        BSTNode current = root;
        BSTNode parent = root;
        boolean isLeftChild = false;

        while(current.val != key) {
            parent = current;
            if(current.val < key) {
                current = current.right;
                isLeftChild = false;
            } else {
                current = current.right;
                isLeftChild = true;
            }

            if(current == null) {
                return false;
            }
        }

        BSTNode delete_node = null;
        
        if(current.left == null && current.right == null) {
            delete_node = null;
        } else if(current.left != null && current.right == null) {
            delete_node = current.left;
        } else if(current.left == null && current.right != null) {
            delete_node = current.right;
        } else {
            delete_node = getSuccessor(current);
            delete_node.left = current.left;
        }

        if(current == root) {
            root = delete_node;
        } else if(isLeftChild) {
            parent.left = delete_node;
        } else {
            parent.right = delete_node;
        }

        return true;
    }

    public BSTNode getSuccessor(BSTNode deleleNode){
        BSTNode successsor =null;
        BSTNode successsorParent =null;
        BSTNode current = deleleNode.right;
        while(current!=null){
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        /*
         * check if successor has the right child, it cannot have left child for sure
         * if it does have the right child, add it to the left of successorParent.
         * successsorParent
         * */
        if(successsor!=deleleNode.right){
            successsorParent.left = successsor.right;
            successsor.right = deleleNode.right;
        }
        return successsor;
    }

    public void display(BSTNode root){
        if(root!=null){
            display(root.left);
            System.out.print(" " + root.val);
            display(root.right);
        }
    }
    public static void main(String arg[]){
        BST b = new BST();
        b.insert(3);b.insert(8);
        b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
        b.insert(20);b.insert(25);b.insert(15);b.insert(16);
        System.out.println("Original Tree : ");
        b.display(b.root);      
        System.out.println("");
        System.out.println("Check whether Node with value 4 exists : " + b.search(4));
        System.out.println("Delete Node with no children (2) : " + b.delete(2));        
        b.display(root);
        System.out.println("\n Delete Node with one child (4) : " + b.delete(4));       
        b.display(root);
        System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));      
        b.display(root);
    }

}




