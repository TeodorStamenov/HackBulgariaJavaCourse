package oop.task6;

public class ListNode<T> {
	private int index;
	private T data;
	
	ListNode<T> nextNode;
	ListNode<T> previousNode;
	
	public ListNode(T data, int index) {
		this.data = data;
		this.index = index;
	}
	
	public T getData() {
		return data;
	}
	
	public int getIndex() {
		return index;
	}
	
	public void setIndex(int index) {
		this.index = index;
	}
}
