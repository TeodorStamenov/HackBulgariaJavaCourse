package files.tests;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import files.task3.WordCountResult;

public class Task3Test {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	
	private File testFile;
	
	@Before
	public void createTestFile() throws IOException {
		testFile = folder.newFile("testMethod");
		BufferedWriter w = new BufferedWriter(new FileWriter(testFile));
		w.write("line one\n");
		w.write("line two\n");
		w.write("line 3");
		w.close();
	}
	
	@Test
	public void test() throws IOException {
		WordCountResult i = WordCountResult.wordCount(testFile);
		assertEquals(3, i.countLines);
		assertEquals(19, i.countChars);
		assertEquals(6, i.countWords);
	}
	
	@After
	public void delteFile() {
		testFile.delete();
	}

}
