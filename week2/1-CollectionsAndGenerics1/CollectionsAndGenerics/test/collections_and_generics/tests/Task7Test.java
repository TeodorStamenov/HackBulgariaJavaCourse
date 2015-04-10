package collections_and_generics.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import collections_and_generics.task7.SortByGrade;
import collections_and_generics.task7.Student;

public class Task7Test {

	@Test
	public void test() {
		Student st1 = new Student("Gosho", 2);
		Student st2 = new Student("Asen", 2);
		Student st3 = new Student("Ivo", 3);
		Student st4 = new Student("Asen", 2);
		Student st5 = new Student("Billy", 2);
		Student st6 = new Student("Asen", 3);
		
		ArrayList<Student> students = new ArrayList<Student>();
		
		students.add(st1);
		students.add(st2);
		students.add(st3);
		students.add(st4);
		students.add(st5);
		students.add(st6);
		
		SortByGrade.sortByGrade(students);
		
		assertEquals(st6, students.get(0)); //Asen, 3
		assertEquals(st3, students.get(1)); //Ivo, 3
		assertEquals(st2, students.get(2)); //Asen, 2
		assertEquals(st4, students.get(3)); //Asen, 2
		assertEquals(st5, students.get(4)); //Billy, 2
		assertEquals(st1, students.get(5)); //Gosho, 2
	}

}
