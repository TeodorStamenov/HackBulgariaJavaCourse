package collections_and_generics.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import collections_and_generics.task8.MedianQuick;

public class Task8Test {

	@Test
	public void test() {
		MedianQuick test = new MedianQuick();
		test.add(13);
		test.add(18);
		test.add(13);
		test.add(14);
		test.add(13);
		test.add(16);
		test.add(14);
		test.add(21);
		test.add(13);
		
		assertTrue(15 == test.getMean());
		assertTrue(14 == test.getMedian());
		assertEquals(13, test.getMode());
		assertEquals(8, test.getRange());
	}

}
