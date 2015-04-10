package collections_and_generics.task7;

public class Student {
	private String name;
	private int grade;
	
	public Student (String name, int grade) {
		this.name = name;
		this.grade = grade;
	}
	
	public String getName() {
		return name;
	}
	
	public int getGrade() {
		return grade;
	}
	
	@Override
	public String toString() {
		return "Grade: " + this.grade + " Name: " + this.name + "\n";
	}
	
}
