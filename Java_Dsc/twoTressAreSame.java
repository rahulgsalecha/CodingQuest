class twoTreesAreSame {

    public static class Node 
    {
        int val;
        Node left, right;

        Node(int item) 
        {
            val = item;
            left = right = null;
        }
    }

    Node root1, root2;
    
    public static boolean twoTreesAreIdentical ( Node n1, Node n2) {
        if(n1 == null && n2 == null) {
            return true;
        }

        if(n1 != null &&  n2 != null) {
            return (n1.val == n2.val && 
                    twoTreesAreIdentical(n1.left, n2.left) && 
                    twoTreesAreIdentical(n1.right,n2.right));
        } else {
            return false;
        }
    }

    public static void main(String[] args) 
    {
        twoTreesAreSame tree = new twoTreesAreSame();

        tree.root1 = new Node(1);
        tree.root1.left = new Node(2);
        tree.root1.right = new Node(3);
        tree.root1.left.left = new Node(4);
        tree.root1.left.right = new Node(5);
        tree.root1.left.right.right = new Node(6);

        tree.root2 = new Node(1);
        tree.root2.left = new Node(2);
        tree.root2.right = new Node(3);
        tree.root2.left.left = new Node(4);
        tree.root2.left.right = new Node(5);
        tree.root2.left.right.right = new Node(6);

        if (tree.twoTreesAreIdentical(tree.root1, tree.root2))
            System.out.println("Both trees are identical");
        else
            System.out.println("Trees are not identical");

    }
}
