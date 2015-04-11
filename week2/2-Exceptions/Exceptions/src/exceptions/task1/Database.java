package exceptions.task1;

import java.util.ArrayList;

public class Database {
	
	private ArrayList<String> list = new ArrayList<String>();
	
	public void addUser (String name) {
		if (name.isEmpty())
			throw new DatabaseCorruptedException().exception;
		else 
			this.list.add(name);
	}
	
	public void getUserNames() {
		System.out.println(list.toString());
	}
}
