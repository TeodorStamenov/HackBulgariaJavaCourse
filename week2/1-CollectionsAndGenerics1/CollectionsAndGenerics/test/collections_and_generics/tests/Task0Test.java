package collections_and_generics.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import collections_and_generics.task0.CheckBrackets;

public class Task0Test {

	@Test
	public void test() {
		assertEquals(true, CheckBrackets.check("()()()"));
		assertEquals(false, CheckBrackets.check("()()("));
		assertEquals(false, CheckBrackets.check("()()())))((())("));
		assertEquals(false, CheckBrackets.check("())(()"));
	}

}
