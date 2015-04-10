package collections_and_generics.task7;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByGrade {

	private static void sortByNames(List<Student> students) {
		
		Collections.sort(students, new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		
	}
	
	public static void sortByGrade(List<Student> students) {
		sortByNames(students);
		
		Collections.sort(students, new Comparator<Student>() {
			
			@Override
			public int compare(Student o1, Student o2) {
				Integer a = o1.getGrade();
				Integer b = o2.getGrade();
				return b.compareTo(a);
			}
		});
		
	}
	
}
