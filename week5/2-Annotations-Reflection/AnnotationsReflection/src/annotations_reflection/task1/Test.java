package annotations_reflection.task1;

public class Test {

	public static void main(String[] args) {
		ClassInfoTest obj = new ClassInfoTest();
		System.out.println(obj.getClass().getAnnotations());
		System.out.println(obj.getClass().getAnnotation(ClassInfo.class));
	}

}
