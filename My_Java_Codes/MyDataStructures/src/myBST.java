
public class myBST {
	// Insert function
	// Delete function
	// Search function
	class BST_Node{
		int val;
		BST_Node left, right;
		
		public BST_Node(int item){
			val = item;
			left = right = null;
		}
	}
	
	//BST entries
	public static BST_Node root;
	
	public myBST(){
		this.root = null;
	}
	
	// Insert an element into the BST
	public void insert(int key){
		
		BST_Node newNode = new BST_Node(key);
		if(root == null){
			root = newNode;
			return;
		}
		
		BST_Node current = root;
		BST_Node parent = null;
		
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
	
	public BST_Node getSuccessor(BST_Node deleteNode){
		
		BST_Node successor = null;
		BST_Node successorParent = null;
		BST_Node current = deleteNode.right;
		
		while(current!=null){
			successorParent = successor;
			successor = current;
			current = current.left;
		}
		
		//check if successor has the right child, it cannot have left child for sure (it is already leftmost)
		// if it does have the right child, add it to the left of successorParent.
		if(successor!=deleteNode.right){
			successorParent.left = successor.right;
			successor.right = deleteNode.right; 
		}
		return successor;
		
	}
	
	public boolean delete(int key){
		// 4 cases : Delete a note with no children,  with Either 1 of left / right children, or with 2 children (left & right)
		BST_Node current = root;
		BST_Node parent = null;
		
		boolean isLeftChild = false;
		
		while(current.val != key)
		{
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
		if(current.left != null && current.right == null){
			if(current == root){
				root = current.left;
			} else if(isLeftChild){
				parent.left = current.left;
			} else {
				parent.right = current.left;
			}	
		}
		
		//Case 3 : if node to be deleted has only one child // right
		if(current.left == null && current.right != null){
			if(current == root){
				root = current.right;
			} else if(isLeftChild){
				parent.left = current.right;
			} else {
				parent.right = current.right;
			}	
		}
		
		//Case 4 : now we have to found the minimum element in the right sub tree
		if(current.left != null && current.right != null){
			BST_Node successor = getSuccessor(current);
			if(current == root){
				root = successor;
			} else if(isLeftChild){
				parent.left = successor;
			} else {
				parent.right = successor;
			}	
			successor.left = current.left;
		}
		
		return true;
	}
	
	
	public  boolean find(int key){
		BST_Node current = root;
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
	
	public void display(BST_Node root){
		if(root!=null){
			display(root.left);
			System.out.print(" " + root.val);
			display(root.right);
		}
	}
	
	public static void main(String args[]){
		myBST b = new myBST();
		
		b.insert(3);b.insert(8);
		b.insert(1);b.insert(4);b.insert(6);b.insert(2);b.insert(10);b.insert(9);
		b.insert(20);b.insert(25);b.insert(15);b.insert(16);
		
		System.out.println("Original Tree : ");
		b.display(b.root);		
		System.out.println("");
		
		System.out.println("Check whether Node with value 20 exists : " + b.find(20));
		System.out.println("Check whether Node with value 30 exists : " + b.find(30));
		System.out.println("Delete Node with no children (2) : " + b.delete(2));		
		b.display(root);
		System.out.println("\n Delete Node with one child (4) : " + b.delete(4));		
		b.display(root);
		System.out.println("\n Delete Node with Two children (10) : " + b.delete(10));		
		b.display(root);
		
	}
	

}
