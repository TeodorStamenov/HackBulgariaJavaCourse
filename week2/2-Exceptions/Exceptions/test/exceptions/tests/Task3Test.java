package exceptions.tests;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import exceptions.task1.Database;
import exceptions.task3.TimeDate;

public class Task3Test {

	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@Test
	public void shouldThrowRuntimeExceptionWhenUserNameIsEmpty() {
		expectedEx.expect(IllegalArgumentException.class);
		expectedEx.expectMessage("Invalid hour");
		
		int hour = 44;
		TimeDate time = new TimeDate(hour);
	}

}
