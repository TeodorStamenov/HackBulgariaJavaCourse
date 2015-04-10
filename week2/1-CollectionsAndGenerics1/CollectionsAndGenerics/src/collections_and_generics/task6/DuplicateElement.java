package collections_and_generics.task6;

import java.util.Set;

public class DuplicateElement {
	
	public static <T> Set findDuplicateElement(Set<T>... set){
		Set<T> firstSet = set[0];
		
		for (int i = 1; i < set.length; i++) {
			firstSet.retainAll(set[i]);
		}
		
		return firstSet;
	}
}
