package oop.task6;

public class MyDoublyLinkedList<T> {
	private ListNode<T> head;
	private ListNode<T> tail;
	private ListNode<T> current;
	private ListNode<T> temp;
	private int index = 0;
	
	// add element in the beginning
	public void add(T data) {
		ListNode<T> newNode = new ListNode<T>(data, index);
		
		if(isEmpty()) {
			head = newNode;
			tail = newNode;
		} else {
			tail.nextNode = newNode;
			newNode.previousNode = tail;
			tail = newNode;
		}
		
		index++;
	}
	
	
	// add element in the index
	public boolean add(int index, T data) {
		ListNode<T> newNode = new ListNode<T>(data, index);
		
		current = head;
			
		while (current.getIndex() != index) {
			current = current.nextNode;
				
			if (current == null)
				return false;
		}
		
		if (current.equals(head)) {
			newNode.nextNode = current;
			current.previousNode = newNode;
			head = newNode;
		} 
		else if (current.equals(tail)) {
			tail.nextNode = newNode;
			newNode.previousNode = tail;
			tail = newNode;
		} else {	
			current.previousNode.nextNode = newNode;
			newNode.nextNode = current;
			newNode.previousNode = current.previousNode;
			current.previousNode = newNode;
		}
		redefineIndexes(newNode);
		return true;
	}
	
	
	// redefIndex
	private void redefineIndexes(ListNode<T> current) {
		
		if (current.equals(tail) && current.equals(head))
			current.setIndex(0);
		else if (current.equals(tail))
			current.setIndex(index);
		
		while(current.nextNode != null) {
			
			current.nextNode.setIndex(current.getIndex() + 1);
			current = current.nextNode;
			
		}
		
		tail.setIndex(current.getIndex());
		
	}

	
	// print linkedList
	public void print() {
		current = head;
		while (current != null) {
			System.out.print(String.format("%d ", current.getData()));
			current = current.nextNode;
		}
		System.out.println();
	}
	
	
	// check for elements in the linkedList
	public boolean isEmpty() {
		return tail == null;
	}
	
	// get element from index
	public T get(int index) {
		current = head;
		for (int i = 0; i < length(); i++) {
			if (current.getIndex() == index) 
				return current.getData();
			current = current.nextNode;
		}
		throw new IndexOutOfBoundsException("Wrong index!");
	}
	
	// number of nodes in the linkedList
	public int length() {
		return tail.getIndex() + 1;
	}
	
	// remove element from index
	public boolean remove(int index) {
		
		if (index == 0 && head.equals(tail)) {
			head = null;
			tail = null;
			this.index = 0;
			return true;
		} else if(head.getIndex() == index) {
			head = head.nextNode;
			head.previousNode = null;
			head.setIndex(0);
			redefineIndexes(head);
			return true;
		} else if (tail.getIndex() == index) {
			tail = tail.previousNode;
			tail.nextNode = null;
			return true;
		} else if (index < 0) {
			throw new NullPointerException("Stack is empty!");
		}
		
		current = head.nextNode;
		
		while (current.getIndex() != index) {
			current = current.nextNode;
			
			if (current.nextNode == null)
				return false;
		}
		
		current.previousNode.nextNode = current.nextNode;
		current.nextNode.previousNode = current.previousNode;
		redefineIndexes(current.previousNode);
		
		return true;
	}
	
	// remove all nodes
	public void clear() {
		current = head.nextNode;
		temp = current;
		head = null;
		while (current.nextNode != null) {
			temp = current.nextNode;
			current = current.nextNode;
			temp = null;
		}
		current = null;
		temp = null;
		tail = null;
		index = 0;
	}
	
	// get first element
	public T getHead() {
		if (head == null)
			throw new NullPointerException("Empty linkedList");
		return head.getData();
	}
	
	// get last element
	public T getTail() {
		if (tail == null)
			throw new NullPointerException("Empty linkedList");
		return tail.getData();
	}
}
