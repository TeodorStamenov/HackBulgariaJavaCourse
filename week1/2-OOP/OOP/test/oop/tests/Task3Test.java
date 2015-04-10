package oop.tests;

import static org.junit.Assert.*;
import oop.task3.Pair;

import org.junit.Test;

public class Task3Test {

	@Test
	public void test() {
		Pair pair1 = new Pair("Queen", 10);
		Pair pair2 = new Pair(10, "Queen");
		Pair pair3 = new Pair("King", "Ace");
		assertTrue(true == pair1.equals(pair2));
		assertTrue(false == pair1.equals(pair3));
	}

}
