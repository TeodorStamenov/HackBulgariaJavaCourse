package exceptions.task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public final class ImmutableList<T> implements List<T> {
	private final List<T> immutableList;
	
	public ImmutableList (Collection<? extends T> collection) {
		this.immutableList = new ArrayList<T>();
		for (T c : collection) {
			this.immutableList.add(c);
		}
	}
	
	@SafeVarargs
	public static <T> ImmutableList<T> asList(T... a) {
		List<T> list = Arrays.asList(a);
		ImmutableList<T> newList = new ImmutableList<T>(list);
		return newList;
	}
	
	@Override
	public boolean add(T e) {
		throw new UnsupportedOperationException("List is immutable");
	}
	
	@Override
	public void add(int index, T element) {
		throw new UnsupportedOperationException("List is immutable");
	}
	
	@Override
	public boolean addAll(Collection<? extends T> c) {
		throw new UnsupportedOperationException("List is immutable");
	}
	
	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		throw new UnsupportedOperationException("List is immutable");
	}
	
	@Override
	public T get(int index) {
		return this.immutableList.get(index);
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException("List is immutable");
		
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException("List is immutable");
	}

	@Override
	public T remove(int index) {
		throw new UnsupportedOperationException("List is immutable");
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException("List is immutable");
	}

	@Override
	public T set(int index, T element) {
		throw new UnsupportedOperationException("List is immutable");
	}

	@Override
	public int size() {
		return this.immutableList.size();
	}

	@Override
	public boolean contains(Object o) {
		return this.immutableList.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return this.immutableList.containsAll(c);
	}

	@Override
	public int indexOf(Object o) {
		return this.immutableList.indexOf(o);
	}

	@Override
	public boolean isEmpty() {
		return this.immutableList.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return this.immutableList.iterator();
	}

	@Override
	public int lastIndexOf(Object o) {
		return this.immutableList.lastIndexOf(o);
	}

	@Override
	public ListIterator<T> listIterator() {
		return this.immutableList.listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int index) {
		return this.immutableList.listIterator(index);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException("List is immutable");
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex) {
		return immutableList.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		return immutableList.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return immutableList.toArray(a);
	}
}
