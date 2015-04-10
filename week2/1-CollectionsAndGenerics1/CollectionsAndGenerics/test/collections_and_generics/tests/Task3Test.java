package collections_and_generics.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import collections_and_generics.task3.BoundedQueue;

public class Task3Test {

	@Test
	public void test() {
		BoundedQueue<Integer> test = new BoundedQueue<Integer>(3);
		for (int i = 1; i <= 5; i++) {
			test.offer(i);
		}
		
		assertEquals(3, test.size());
		
		assertTrue(3 == test.poll());
		assertTrue(4 == test.poll());
		assertTrue(5 == test.poll());
	}

}
