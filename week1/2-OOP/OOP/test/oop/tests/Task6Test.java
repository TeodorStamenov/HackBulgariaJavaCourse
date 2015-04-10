package oop.tests;

import static org.junit.Assert.*;
import oop.task6.MyDoublyLinkedList;

import org.junit.Test;

public class Task6Test {

	@Test
	public void test() {
		MyDoublyLinkedList<String> linkedList = new MyDoublyLinkedList<String>();
		
		linkedList.add("London");
		linkedList.add("Paris");
		linkedList.add("Berlin");
		linkedList.add("Rome");
		linkedList.add("Madrid");
		
		assertEquals("London", linkedList.getHead());
		assertEquals("Madrid", linkedList.getTail());
		assertEquals(5, linkedList.length());
		
		linkedList.add(2, "Sofia");
		
		assertEquals(6, linkedList.length());
		assertEquals("Berlin", linkedList.get(3));
		
		linkedList.remove(4);
		
		assertEquals(5, linkedList.length());
		
		linkedList.clear();
		
		assertEquals(true, linkedList.isEmpty());
	}

}
