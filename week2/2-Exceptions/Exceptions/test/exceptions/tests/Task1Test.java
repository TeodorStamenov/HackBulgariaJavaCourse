package exceptions.tests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exceptions.task1.Database;

public class Task1Test {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void shouldThrowRuntimeExceptionWhenUserNameIsEmpty() {
		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Empty user name");
		
		Database base = new Database();
		base.addUser("");
	}

}
