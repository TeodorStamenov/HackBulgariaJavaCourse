package com.hackbulgaria.corejava2;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.hackbulgaria.corejava2.data.Gender;
import com.hackbulgaria.corejava2.data.Student;

public class StudentsOperationsImplement implements StudentOperations {
	private List<Student> students;
	
	public StudentsOperationsImplement(List<Student> students) {
		this.students = students;
	}
	
	@Override
	public double getAverageMark() {
		return students.stream().mapToDouble(s -> s.getGrade()).average().getAsDouble();
	}

	@Override
	public List<Student> getAllPassing() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllFailing() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Boolean, List<Student>> splitStudentsByMarks(float splitMark) {
		return students.stream().collect(Collectors.partitioningBy(s -> s.getGrade() >= 3.5));
	}

	@Override
	public List<Student> orderByMarkDescending() {
		return students.stream().sorted((s1,s2) -> Double.compare(s2.getGrade(), s1.getGrade())).collect(Collectors.toList());
	}

	@Override
	public List<Student> orderByMarkAscending() {
		return students.stream().sorted((s1,s2) -> Double.compare(s1.getGrade(), s2.getGrade())).collect(Collectors.toList());
	}

	@Override
	public List<Student> getStudentsWithLowestMarks() {
		return students.stream().filter(s -> s.getGrade() == 2).collect(Collectors.toList());
	}

	@Override
	public List<Student> getStudentsWithHighestMarks() {
		return students.stream().filter(s -> s.getGrade() == 6).collect(Collectors.toList());
	}

	@Override
	public Map<Integer, List<Double>> getMarksDistributionByAge() {
		 Map<Integer, List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getAge));	
		 Map<Integer, List<Double>> result = map.entrySet().stream().collect(Collectors.<Entry<Integer, List<Student>>, Integer, List<Double>> toMap(e -> e.getKey(), e->e.getValue().stream().map(Student::getGrade).collect(Collectors.toList())));
		 return result;
	}
	
	@Override
	public Map<Gender, Double> getAverageMarkByGender() {
		
		return null;
	}

	@Override
	public Map<Double, Integer> getMarksDistribution() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmailToHeader() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Gender, Map<Integer, List<Student>>> splitStudentMarksByGenderAndThenByAge() {
//		 Map<Integer, List<Double>> totalByDept
//         = students.stream().collect(Collectors.groupingBy(Student::getAge(),Collectors.summingInt(Student::getGrade())));	
		return null;
	}

}
