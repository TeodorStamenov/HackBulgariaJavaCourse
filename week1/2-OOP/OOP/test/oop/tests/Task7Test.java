package oop.tests;

import static org.junit.Assert.*;
import oop.task7.MyStack;

import org.junit.Test;

public class Task7Test {

	@Test
	public void test() {
		MyStack<Integer> stack = new MyStack<Integer>();
		for (int i = 1; i < 11; i++) {
			stack.push(i);
		}
		
		assertTrue(10 == stack.pop());
		assertTrue(9 == stack.peek());
		assertTrue(false == stack.addIfNotExist(5));
		assertTrue(9 == stack.size());
		
		stack.clearStack();
		
		assertTrue(true == stack.isStackEmpty());
	}

}
