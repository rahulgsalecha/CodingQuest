public class LeastCommonAncestor {

    Node root;


    public static class Node{
        int val;
        Node left;
        Node right;

        Node(int x) {
            val = x;
            left = right= null;
        }
    }

    public Node findLCA(Node node, int a, int b) {
        if(node==null) {
            return null;
        }

        if(node.val > a && node.val > b) {
            return findLCA(node.left, a,b);
        }

        if(node.val < a && node.val < b) {
            return findLCA(node.right, a ,b);
        }

        return node;
    }


   public static void main(String args[]) 
   {

       LeastCommonAncestor tree = new LeastCommonAncestor();
       tree.root = new Node(20);
       tree.root.left = new Node(8);
       tree.root.right = new Node(22);
       tree.root.left.left = new Node(4);
       tree.root.left.right = new Node(12);
       tree.root.left.right.left = new Node(10);
       tree.root.left.right.right = new Node(14);

       int n1 = 10, n2 = 14;
       Node t = tree.findLCA(tree.root, n1, n2);
       System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.val);

       n1 = 14;
       n2 = 8;
       t = tree.findLCA(tree.root, n1, n2);
       System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.val);

       n1 = 10;
       n2 = 22;
       t = tree.findLCA(tree.root, n1, n2);
       System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.val);

   }                                                                                            

}
