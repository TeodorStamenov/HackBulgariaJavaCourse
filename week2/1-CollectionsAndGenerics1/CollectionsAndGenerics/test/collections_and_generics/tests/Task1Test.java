package collections_and_generics.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import collections_and_generics.task1.Reverse;

public class Task1Test {

	@Test
	public void test() {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= 5; i++) {
			list.add(i);
		}
		
		assertTrue(1 == list.get(0));
		assertTrue(2 == list.get(1));
		assertTrue(3 == list.get(2));
		assertTrue(4 == list.get(3));
		assertTrue(5 == list.get(4));
			
		Reverse.reverse(list);
		
		assertTrue(5 == list.get(0));
		assertTrue(4 == list.get(1));
		assertTrue(3 == list.get(2));
		assertTrue(2 == list.get(3));
		assertTrue(1 == list.get(4));	
	}

}
