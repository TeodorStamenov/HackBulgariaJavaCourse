package collections_and_generics.task10;

import java.util.HashMap;

public class TestTask10 {
	
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("Unt", 90000000);
		map.put("Chelsea", 95000000);
		map.put("City", 120000000);
		map.put("Arsenal", 55000000);
		map.put("Stoke", 32000000);
		
		String st = ConvertHashMap.convert(map);
		System.out.println(st);
	}
}
