package annotations_reflection.task2;

public class TestClass {
	@After
	public void add() {
		if (10 == MyMath.add(5, 5))
			System.out.println("true");
		else 
			System.out.println("false");
	}
}
