package collections_and_generics.task4;

import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;

public class RotateElementsOfCollection {
	private static Deque deque = new LinkedList();
	
	public static <T> void rotate(Collection<T> collection, int step) {
		deque.addAll(collection);
		collection.clear();
		
		while(step != 0) {
			
			if (step > 0) {
				deque.addFirst(deque.pollLast());
				step--;
			} else {
				deque.addLast(deque.pollFirst());
				step++;
			}
		}
		
		collection.addAll(deque);
		deque.clear();
	}
	
}
