package collections_and_generics.tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import collections_and_generics.task6.DuplicateElement;

public class Task6Test {

	@Test
	public void test() {
		Set<String> A = new HashSet<String>();
		Set<String> B = new HashSet<String>();
		Set<String> C = new HashSet<String>();
		Set<String> D = new HashSet<String>();
		
		A.add("Sofia");
		A.add("Varna");
		A.add("Sofia");
		B.add("Varna");
		B.add("Vidin");
		B.add("Sofia");
		C.add("Varna");
		C.add("Sofia");
		D.add("Pernik");
		D.add("Varna");
		D.add("Sofia");
		
		Set<String> F = DuplicateElement.findDuplicateElement(A, B, C, D);
		
		Set<String> expected = new HashSet<String>();
		expected.add("Sofia");
		expected.add("Varna");
		
		assertEquals(expected, F);
	}

}
