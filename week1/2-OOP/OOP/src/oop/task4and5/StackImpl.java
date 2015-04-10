package oop.task4and5;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class StackImpl<T> implements Stack<T>{
	private final List<T> list = new ArrayList<T>();
	private int count = 0;
	private T popElement;
	
	@Override
	public void push(T element) {
		list.add(element);
		this.count++;
	}
	
	@Override
	public T pop() {
		popElement = list.get(count - 1);
		list.remove(count - 1);
		count--;
		return popElement;
	}

	@Override
	public int size() {
		return count;
	}

	@Override
	public void clearStack() {
		list.clear();
	}

	@Override
	public boolean isStackEmpty() {
		return list.isEmpty();
	}

	@Override
	public T peek() {
		if (count == 0)
			throw new EmptyStackException();
		return list.get(count - 1);
	}
	
	private boolean checkForDuplicateElement(T element) {
		for (int index = 0; index < count; index++) {
			if (element.equals(list.get(index)))
				return true;
		}
		return false;
	}

	@Override
	public boolean addIfNotExist(T element) {
		if (!checkForDuplicateElement(element)) {
			list.add(element);
			this.count++;
			return true;
		} else {
			return false;
		}
	}
}
