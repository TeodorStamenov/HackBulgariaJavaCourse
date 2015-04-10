package collections_and_generics.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import collections_and_generics.task4.RotateElementsOfCollection;

public class Task4Test {

	@Test
	public void test() {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		List<Integer> listExpected1 = new ArrayList<Integer>(Arrays.asList(4,5,1,2,3));
		List<Integer> listExpected2 = new ArrayList<Integer>(Arrays.asList(3,4,5,1,2));
		
		RotateElementsOfCollection.rotate(list, 2);
		assertEquals(listExpected1, list);
		
		RotateElementsOfCollection.rotate(list, -4);
		assertEquals(listExpected2, list);
	}
}
