package collections_and_generics.task2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

public class MyCollection<T> implements Collection<T>{

	Stack<T> myStack = new Stack<T>();
	
	@Override
	public boolean add(T e) {
		if (!myStack.contains(e)) {
			myStack.push(e);
			return true;
		}
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		for (T t : c) {
			if(!myStack.contains(t))
				myStack.push(t);
		}
		return true;
	}

	@Override
	public void clear() {
		myStack.clear();
	}

	@Override
	public boolean contains(Object o) {
		return myStack.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return myStack.containsAll(c);
	}

	@Override
	public boolean isEmpty() {
		return myStack.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return myStack.iterator();
	}

	@Override
	public boolean remove(Object o) {
		return myStack.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return myStack.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return myStack.retainAll(c);
	}

	@Override
	public int size() {
		return myStack.size();
	}

	@Override
	public Object[] toArray() {
		return myStack.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return myStack.toArray(a);
	}
	
}
