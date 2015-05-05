package annotations_reflection.task2;

import java.lang.reflect.InvocationTargetException;

public class Program {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		TestFramework t = new TestFramework(TestClass.class);
		t.test();
	}
}
