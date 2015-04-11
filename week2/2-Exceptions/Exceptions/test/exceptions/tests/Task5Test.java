package exceptions.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exceptions.task5.ImmutableList;

public class Task5Test {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void test() {
		expectedEx.expect(UnsupportedOperationException.class);
		expectedEx.expectMessage("List is immutable");
		
		List<Integer> list = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		ImmutableList<Integer> immutableList = new ImmutableList<Integer>(list);
		
		immutableList.add(555);
	}

}
