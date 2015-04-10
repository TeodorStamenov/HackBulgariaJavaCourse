package collections_and_generics.task9;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ToDoList implements Iterable<Task>{
	private int hoursRemaining;
	private LinkedList<Task> tasks;
	private int index;
	private float timeNeeded;
	
	public ToDoList(int hoursRemaining) {
		this.hoursRemaining = hoursRemaining;
		this.tasks = new LinkedList<Task>();
	}
	
	public void add(Task task) {
		tasks.add(task);
		sortByPriority(tasks);
		timeNeeded = timeNeeded + task.getTimeRequired();
	}
	
	public void markFinished(Task task) {
		task.isFinished();
		sortByPriority(tasks);
	}
	
	public void markCancelled(Task task) {
		this.timeNeeded = timeNeeded - task.getTimeRequired();
		task.isCancelled();
	}
	
	public float getTimeRemaining() {
		return hoursRemaining - getTimeNeeded();
	}
	
	public Task top() {
		index = 0;
		while (index < tasks.size())
			if (!tasks.get(index).getStatusTask())
				return tasks.get(index);
			else
				index++;
		throw new IllegalArgumentException("List of tasks is empty!");
	}
	
	public boolean canFinish() {
		if (getTimeRemaining() > 0) 
			return true;
		else
			return false;
	}
	
	public float getTimeNeeded() {
		return timeNeeded;
	}
	
	private static void sortByPriority (List<Task> list) {
		Collections.sort(list, new Comparator<Task>() {

			@Override
			public int compare(Task o1, Task o2) {
				return o2.getPriority() - o1.getPriority();
			}
		});
	}

	@Override
	public Iterator<Task> iterator() {
		return tasks.iterator();
	}
}
