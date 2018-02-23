package datastructures;

public class DLNode {
	
	protected int data;
	protected DLNode next,prev;
	
	public DLNode(){
		next = null;
		prev = null;
		data = 0;
	}
	
	public DLNode(int d, DLNode n, DLNode p){
		next = n;
		prev = p;
		data = d;
	}
	
	/* Function to set link to next node */
	public void setLinkNext(DLNode n){
		next = n;
	}
	
	/* Function to get link to next node */
	public DLNode getLinkNext(){
		return next;
	}
	
	/* Function to set link to prev node */
	public void setLinkPrev(DLNode p){
		prev = p;
	}
	
	/* Function to get link to prev node */
	public DLNode getLinkPrev(){
		return prev;
	}
	
	/* Function to set data to  node */
	public void setData(int d){
		data = d;
	}
	
	/* Function to get link to prev node */
	public int getData(){
		return data;
	}
	

}
