package collections_and_generics.task3;

import java.util.LinkedList;
import java.util.Queue;

public class BoundedQueue<T> extends AbstractBoundedQueue<T> implements Queue<T>{
	private int limit;
	
	Queue<T> boundedQueue = new LinkedList<T>();
	
	public BoundedQueue(int limit) {
		this.limit = limit;
	}
	
	@Override
	public void clear() {
		boundedQueue.clear();
	}

	@Override
	public boolean isEmpty() {
		if (!boundedQueue.isEmpty())
			return false;
		return true;
	}

	@Override
	public int size() {
		return boundedQueue.size();
	}

	@Override
	public boolean add(T e) {
		if (offer(e))
			return true;
		else
			throw new IllegalStateException("Queue is full");
	}

	@Override
	public boolean offer(T e) {
		if (limit <= boundedQueue.size()) {
			boundedQueue.poll();
			boundedQueue.offer(e);
			return true;
		} else if (limit > boundedQueue.size()){
			boundedQueue.offer(e);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public T peek() {
		return boundedQueue.peek();
	}

	@Override
	public T poll() {
		if (!boundedQueue.isEmpty())
			return boundedQueue.poll();
		else 
			return null;
	}

	@Override
	public T remove() {
		if (!boundedQueue.isEmpty())
			return boundedQueue.poll();
		else
			throw new IllegalStateException("Queue is empty");
	}
	
	@Override
	public String toString() {
		StringBuilder build = new StringBuilder();
		
		while(!boundedQueue.isEmpty()) {
			build.append(boundedQueue.poll());
			
			if (!boundedQueue.isEmpty())
				build.append(", ");
		}
		return build.toString();
	}
	
}
