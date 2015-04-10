package collections_and_generics.task1;

import java.util.Collection;
import java.util.Stack;

public class Reverse {

	public static <T> void reverse (Collection<T> collection) {
		Stack<T> stack = new Stack<T>();
		
		for (T c : collection) {
			stack.push(c);
		}
		
		collection.clear();
		
		while (!stack.isEmpty()) {
			collection.add(stack.pop());
		}
	}
}
