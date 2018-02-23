
public class BST {
	
	// Implement a BST and its functions such as insert, delete, find
	
	class BSTNode {
		int val;
		BSTNode left;
		BSTNode right;
		
		public BSTNode(int item){
			val = item;
			left = right = null;
		}
	}
	
	public static BSTNode root;
	
	public BST(){
		this.root = null;
	}
	
	public void insert(int key) {
		
		BSTNode newNode = new BSTNode(key);
		if(root == null){
			root = newNode;
			return;
		}
		
		BSTNode current = root;
		BSTNode parent = null;
		
		while(true){
			parent = current;
			
			if(current.val > key){
				current = current.left;
				if(current == null){
					parent.left = newNode;
					return;
				}
			} else {
				current = current.right;
				if(current == null){
					parent.right = newNode;
					return;
				}
			}
		}
	}
	
	public BSTNode getSuccessor(BSTNode deleteNode){
		BSTNode successor = null;
		BSTNode successsorParent =null;
		BSTNode current = deleteNode.right;
		
		while(current!=null){
			successsorParent = successor;
			successor = current;
			current = current.left;
		}
		
		//check if successor has the right child, it cannot have left child for sure (it is already leftmost)
		// if it does have the right child, add it to the left of successorParent.
		if(successor!=deleteNode.right){
			successsorParent.left = successor.right;
			successor.right = deleteNode.right; 
		}
		return successor;
		
	}
	
	
	public  boolean delete(int key){
		// 4 cases : Delete a note with no children,  with Either 1 of left / right children, or with 2 children (left & right)
		
		BSTNode current = root;
		BSTNode parent = root;
		boolean isLeftChild = false;
		
		while(current.val != key){
			parent = current;
			if(key < current.val)  { //It's in Left sub tree
				current = current.left;
				isLeftChild = true;
			} else {
				current = current.right; //It's in Right sub tree
				isLeftChild = false;
			}
			
			if(current == null){ // Node not found
				return false;
			}
		}
		
		//if we are here that means we have found the node
		//Case 1: if node to be deleted has no children
		if(current.left == null && current.right == null){
			if(current == root){
				root = null; 
			}
			if(isLeftChild){
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		
		//Case 2 : if node to be deleted has only one child // left
		else if(current.left != null && current.right == null){
			if(current == root){
				root = current.left;
			} else if(isLeftChild){
				parent.left = current.left;
			}else{
				parent.right = current.left;
			}
		} 
		
		//Case 3 : if node to be deleted has only one child // right
		else if (current.left == null && current.right != null) { 
			if(current == root){
				root = current.right;
			} else if(isLeftChild){
				parent.left = current.right;
			}else{
				parent.right = current.right;
			}
		}
		
		//Case 4 : now we have to found the minimum element in the right sub tree
		else if(current.left!=null && current.right!=null){
			BSTNode successor = getSuccessor(current);
			if(current==root){
				root = successor;
			}else if(isLeftChild){
				parent.left = successor;
			}else{
				parent.right = successor;
			}			
			successor.left = current.left;
		}		
		
		return true;		
	}
	
	public  boolean find(int key){
		BSTNode current = root;
		while(current !=null){
			if(current.val == key){
				return true;
			} else if (current.val > key){
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}
	
	public void display(BSTNode root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.val);
			display(root.right);
		}
	}
	
	public static void main(String args[]){
		BST b = new BST();
		
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		
		System.out.println("Original Tree : ");
		b.display(b.root);		
		System.out.println("");
		
		System.out.println("Check whether Node with value 20 exists : " + b.find(20));
		System.out.println("Delete Node with no children (2) : " + b.delete(2));		
		b.display(root);
		System.out.println("\n Delete Node with one child (4) : " + b.delete(4));		
		b.display(root);
		System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));		
		b.display(root);
		
	}
	
	

}
