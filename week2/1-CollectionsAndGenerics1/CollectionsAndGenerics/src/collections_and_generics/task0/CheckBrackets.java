package collections_and_generics.task0;

import java.util.Stack;

public class CheckBrackets {

	public static boolean check(String str) {
		Stack<Character> expression = new Stack<Character>();
		int count = 0;
		char[] arr = str.toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				expression.push(arr[i]);
				count++;
			} else if (arr[i] == ')') { 
				count--;
					if(count < 0) {
						return false;
					}
				expression.pop();
			}
			else 
				continue;
		}
		
		if (count > 0)
			return false;
		else
			return true;
	}
}
