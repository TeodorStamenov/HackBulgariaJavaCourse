package collections_and_generics.task11;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountWords {

	public static Map<String, Integer> countWords(String text) {
		HashMap<String, Integer> wordsInText = new HashMap<String, Integer>();
		String[] arrText = text.replaceAll("[.!?',]", " ").trim().replace("\\s", " ").split(" ");
		
		for (int i = 0; i < arrText.length; i++) {
			int cnt = 1;
			if (arrText[i].isEmpty()) {
				continue;
			} else if (!wordsInText.containsKey(arrText[i])) {
				wordsInText.put(arrText[i], cnt);
			} else {
				cnt = wordsInText.get(arrText[i]);
				wordsInText.put(arrText[i], ++cnt);
			}
		}

		return wordsInText;
	}

}
