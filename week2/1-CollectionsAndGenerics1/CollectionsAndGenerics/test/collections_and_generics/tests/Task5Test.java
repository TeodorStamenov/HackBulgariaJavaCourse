package collections_and_generics.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import collections_and_generics.task5.FirstUniqueElement;

public class Task5Test {

	@Test
	public void test() {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,5,4,3,1));
		List<Integer> list2 = new ArrayList<Integer>(Arrays.asList(1,1,4,4,5,4,5,10,555,16,10,16,777));
		
		assertTrue(2 == FirstUniqueElement.findFirstUniqueElement(list));
		assertTrue(555 == FirstUniqueElement.findFirstUniqueElement(list2));
	}

}
