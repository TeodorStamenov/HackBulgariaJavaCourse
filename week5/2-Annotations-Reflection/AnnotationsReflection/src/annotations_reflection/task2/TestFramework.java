package annotations_reflection.task2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestFramework {
	private Class testClass;
	private List<Method> before = new ArrayList<Method>();
	private List<Method> execute = new ArrayList<Method>();
	private List<Method> after = new ArrayList<Method>();
	
	public <T> TestFramework(Class<T> classForTest) {
		this.testClass = classForTest;
	}
	
	public void test() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		setListsAnnotations();
		executeMethods();
	}
	
	private void executeMethods() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (Method m : after) {
			Object obj = testClass.newInstance();
			m.invoke(obj);
		}
		
	}

	private <T> void setListsAnnotations() {
		Method[] listOfMethods = testClass.getMethods();
		for (Method m : listOfMethods) {
			Annotation a = m.getAnnotation(Before.class);
			if(a != null) {
				before.add(m);
				continue;
			}
			
			Annotation a2 = m.getAnnotation(Execute.class);
			if(a2 != null) {
				execute.add(m);
				continue;
			}
			
			Annotation a3 = m.getAnnotation(After.class);
			if(a3 != null) {
				after.add(m);
				continue;
			}
		}
	}
	
	
}
