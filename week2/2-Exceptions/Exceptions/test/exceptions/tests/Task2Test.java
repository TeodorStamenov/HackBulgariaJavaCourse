package exceptions.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.task2.Service;
import exceptions.task2.ServiceNotAvailableAtTheMoment;

public class Task2Test {

	@Test
	public void test() {
		boolean flag = false;
		try {
			Service.userService();
		} catch (ServiceNotAvailableAtTheMoment e) {
			flag = true;
		}
		
		assertTrue(true == flag);
	}

}
