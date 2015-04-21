package files.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import files.task5.ReduceFilePath;

public class Task5Test {

	@Test
	public void test() {
		String input1 = "/home//radorado/code/./hackbulgaria/week0/../";
		assertEquals("/home/radorado/code/hackbulgaria",ReduceFilePath.reduceFilePath(input1));
		
		String input2 = "/srv/./././././";
		assertEquals("/srv", ReduceFilePath.reduceFilePath(input2));
		
		String input3 = "/srv/../";
		assertEquals("/", ReduceFilePath.reduceFilePath(input3));
		
		String input4 = "//////////////";
		assertEquals("/", ReduceFilePath.reduceFilePath(input4));
		
		String input5 = "/../";
		assertEquals("/", ReduceFilePath.reduceFilePath(input5));
	}
}
