package annotations_reflection.task2;

public class TestClass {
	@After
	public void last() {
		System.out.println("After");
	}
	
	@Before
	public void before1() {
		System.out.println("Before");
	}
	
	@Before
	public void before2() {
		System.out.println("Before");
	}
	
	@Execute
	public void execute1() {
		System.out.println("Execute");
	}
	
	@Execute
	public void execute2() {
		System.out.println("Execute");
	}
	
	@Execute
	public void execute3() {
		System.out.println("Execute");
	}
}
