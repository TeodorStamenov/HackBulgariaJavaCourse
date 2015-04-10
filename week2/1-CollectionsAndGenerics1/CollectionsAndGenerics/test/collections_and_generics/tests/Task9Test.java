package collections_and_generics.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import collections_and_generics.task9.Task;
import collections_and_generics.task9.ToDoList;

public class Task9Test {

	@Test
	public void test() {
		Task task1 = new Task("ExamInUniversity", 10, 8);
		Task task2 = new Task("DrinkBeers", 4, 3.5f);
		Task task3 = new Task("PlayVolleyball", 5, 1.5f);
		Task task4 = new Task("HackBg", 9, 6.5f);
		Task task5 = new Task("Sleep", 6, 6.5f);
		
		ToDoList list = new ToDoList(24);
		list.add(task1);
		list.add(task2);
		list.add(task3);
		list.add(task4);
		list.add(task5);
		assertEquals(task1, list.top()); //Exam in University (Top priority)
		assertEquals(false, list.canFinish());	//28 > 24 (impossible)
		list.markCancelled(task5); //Remove sleep
		assertEquals(true, list.canFinish());	//21.5 < 24 (that's another story)
		
		list.markFinished(task1);
		assertEquals(task4, list.top()); //Hack Bulgaria (Top priority)
	}

}
