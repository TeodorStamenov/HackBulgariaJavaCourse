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

import files.task1.FileUtils;

public class Task1Test {

	@Rule
	public TemporaryFolder folder = new TemporaryFolder();
	
	private File test;
	
	@Before
	public void createTestFile() throws IOException {
		test = folder.newFile("methodFromFile");
		BufferedWriter out = new BufferedWriter(new FileWriter(test));
		out.write("George McGregor\n ");
		out.write("from Scotland!\n ");
		out.write("Now he is in Wales!");
		out.close();
	}
	
	@Test
	public void testReadFromFile() throws IOException {
		assertEquals("George McGregor from Scotland! Now he is in Wales!", FileUtils.readFrom(test));
	}
		
	@After
	public void deleteFile() {
		test.delete();
	}

}
