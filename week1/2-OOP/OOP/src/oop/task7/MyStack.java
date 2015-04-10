package oop.task7;

import oop.task4and5.Stack;
import oop.task6.MyDoublyLinkedList;

public class MyStack<T> implements Stack<T>{
	
	private final MyDoublyLinkedList<T> linkedList = new MyDoublyLinkedList<T>();
	private T popElement;
	
	@Override
	public void push(T element) {
		linkedList.add(element);
	}

	@Override
	public T pop() {
		if (linkedList.isEmpty())
			throw new NullPointerException("Stack is Empty!!!!!!!");
		popElement = linkedList.getTail();
		linkedList.remove(linkedList.length() - 1);
		return popElement;
	}

	@Override
	public T peek() {
		return linkedList.getTail();
	}

	@Override
	public int size() {
		return linkedList.length();
	}

	@Override
	public void clearStack() {
		linkedList.clear();
	}

	@Override
	public boolean isStackEmpty() {
		return linkedList.isEmpty();
	}

	@Override
	public boolean addIfNotExist(T element) {
		if(!checkForDuplicateElement(element)) {
			linkedList.add(element);
			return true;
		} else {
			return false;
		}
		
	}
	
	private boolean checkForDuplicateElement(T element) {
		for (int index = 0; index < linkedList.length(); index++) {
			if (element.equals(linkedList.get(index)))
				return true;
		}
		return false;
	}
	
	
}