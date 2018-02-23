package intvw;

public class Node<T> {
	private Node<T> next;
	private T data;

	public  Node(T val, Node<T> n){
		this.next = n;
		this.data = val;
	}
	
	public T getData(){
		return data;
	}
	
	public Node<T> getNext(){
		return next;
	}
	
	public void setData(T val){
		this.data = val;
	}
	
	public void setNext(Node<T> n){
		this.next = n;
	}

}
