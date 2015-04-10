package oop.tests;

import static org.junit.Assert.*;
import oop.task4and5.StackImpl;
import org.junit.Test;

public class Task4and5Test {

	@Test
	public void testStackImpl() {
		StackImpl<String> stack = new StackImpl<String>();
		
		stack.push("Germany");
		stack.push("Brazil");
		stack.push("Bulgaria");
		stack.push("France");
		
		assertEquals("France", stack.pop());
		assertEquals("Bulgaria", stack.peek());
		assertEquals(3, stack.size());
		assertTrue(stack.addIfNotExist("Argentina"));
		assertTrue(false == stack.addIfNotExist("Brazil"));
		
		stack.clearStack();
		
		assertEquals(true, stack.isStackEmpty());
	}

}
