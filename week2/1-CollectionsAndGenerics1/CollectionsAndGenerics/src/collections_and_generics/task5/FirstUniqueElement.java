package collections_and_generics.task5;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FirstUniqueElement {
	private static Map map;

	public static Integer findFirstUniqueElement(Collection<Integer> collection) {
		map = new LinkedHashMap<Integer, Integer>();
		
		for (Integer element : collection) {
			int cnt = 1;
			if (!map.containsKey(element)) {
				map.put(element, cnt);
			} else {
				cnt = (int) map.get(element);
				map.put(element, ++cnt);
			}
		}
		
		Set<Map.Entry<Integer, Integer>> entry = map.entrySet();
		
		for (Entry<Integer, Integer> e : entry) {
			if (e.getValue() == 1) {
				return e.getKey();
			}
		}
		
		return null;
	}
}
