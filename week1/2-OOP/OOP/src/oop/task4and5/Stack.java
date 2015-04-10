package oop.task4and5;

public interface Stack<T> {
	public void push(T element);
	public T pop();
	public T peek();
	public int size();
	public void clearStack();
	public boolean isStackEmpty();
	public boolean addIfNotExist(T element);
}
