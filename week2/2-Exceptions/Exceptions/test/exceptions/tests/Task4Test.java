package exceptions.tests;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exceptions.task4.MyHashMap;
import exceptions.task4.NullKeyException;

public class Task4Test {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void test() {
		expectedEx.expect(NullKeyException.class);
		expectedEx.expectMessage("Null is not allow");
		
		MyHashMap<Integer, Integer> map = new MyHashMap<Integer, Integer>();
		map.put(null,null);
	}

}
