package threads.bonus;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BlockQueueCustom<T> implements Queue<T> {
	private Queue<T> queue = new LinkedList<T>();
	private int limit = 0;

	public BlockQueueCustom(int limit) {
		this.limit = limit;
	}

	@Override
	public boolean addAll(Collection<? extends T> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return queue.size();
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(T e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean offer(T e) {
		synchronized (this.queue) {
			while (queue.size() >= limit) {
				try {
					queue.wait();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			if (queue.isEmpty()) {
				queue.notifyAll();
			}
			queue.offer(e);
		}
		return true;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T poll() {
		synchronized (this.queue) {
			while (queue.isEmpty()) {
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			if (queue.size() <= limit) {
				queue.notifyAll();
			}
		}
		return queue.poll();
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

}
