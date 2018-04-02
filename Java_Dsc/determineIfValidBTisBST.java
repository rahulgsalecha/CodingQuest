public static boolean determineIfValidBTisBST(Node root) {
    return determineIfValidBTisBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

public static boolean determineIfValidBTisBSTUtil(Node node, int min, int max){
    if(node == null) {
        return true;
    }

    if(node.val < min || node.val > max) 
        return false;

    return determineIfValidBTisBSTUtil(node.left, min, node.val) &&
        determineIfValidBTisBSTUtil(node.right, node.val, max);
}
