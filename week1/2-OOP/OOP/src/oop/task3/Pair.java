package oop.task3;

public class Pair {
	private final Object first;
	private final Object second;
	
	public Pair(Object first, Object second) {
		this.first = first;
		this.second = second;
	}
	
	public Object getFirstMember() {
		return first;
	}
	
	public Object getSecondMember() {
		return second;
	}
	
	@Override
	public String toString() {
		return first.toString() + " " + second.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Pair) {		
			
			Pair p = (Pair) obj;
			
			if (first.equals(p.first) && second.equals(p.second)) {
				return true;
			} else if (first.equals(p.second) && second.equals(p.first)) {
				return true;
			} else
				return false;
		}
		
		return false;
	}
	
}
