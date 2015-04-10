package collections_and_generics.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import collections_and_generics.task2.MyCollection;

public class Task2Test {

	@Test
	public void test() {
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,1,2,3,4,4,5,5,5,1,100));
		MyCollection<Integer> collection = new MyCollection<Integer>();
		
		collection.addAll(list);
		
		assertEquals(6, collection.size());
	}

}
