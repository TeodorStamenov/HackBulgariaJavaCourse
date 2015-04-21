package files.tests;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import files.task2.Properties;

public class Task2Test {


	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	
	private File test;
	
	@Before
	public void createTestFile() throws IOException {
		test = folder.newFile("testMethod");
		BufferedWriter w = new BufferedWriter(new FileWriter(test));
		w.write("# this=coment\n");
		w.write("a1=b1\n");
		w.write("a2 =b2\n");
		w.write("a3     =     b3\n");
		w.write("      a4 = b4\n");
		w.write("a5=b6=b7=b8\n");
		w.write("a6=b9 #coment\n");
		w.write("a7==b10");
		w.close();
	}
	
	@Test
	public void test() throws IOException {
		Map<String, String> expectingHashMap = new HashMap<String, String>();
		expectingHashMap.put("a1", "b1");
		expectingHashMap.put("a2", "b2");
		expectingHashMap.put("a3", "b3");
		expectingHashMap.put("a4", "b4");
		expectingHashMap.put("a5", "b6=b7=b8");
		expectingHashMap.put("a6", "b9#coment");
		expectingHashMap.put("a7", "=b10");
		
		assertEquals(expectingHashMap, Properties.parseProperties(test));
	}
	
	@After
	public void delteFile() {
		test.delete();
	}
}
