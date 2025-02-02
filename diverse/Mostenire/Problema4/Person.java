import java.util.*;

public class Person {
	String name;
	String address;
	
	public Person(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String toString() {
		return name +":" +address;
	}
}

class Student extends Person {
	Vector courses;
	Vector grades;
	
	public Student(String name, String address) {
		super(name,address);
		courses = new Vector();
		grades = new Vector();
	}
	
	void addCourseGrade(String course, int grade) {
		courses.add(course);
		grades.add(grade);
	}
	
	void printGrades() {
		System.out.println(grades.toString());
	}
	
	double getAverageGrade() {
		double sum = 0;
		int i;
		for(i=0;i<grades.size();i++) {
			sum = sum + (double)grades.get(i);
		}
		return sum/grades.size();
	}
	
}

class Teacher extends Person {
	Vector courses;
	public Teacher(String name, String address) {
		super(name,address);
		courses = new Vector();
	}
	boolean addCourse(String course) {
		if(courses.contains(course))
			return false;
		else {
			boolean rez = courses.add(course);
			return rez;	
		}
	}
	
	boolean removeCourse(String course) {
		boolean rez = courses.remove(course);
		return rez;
	}
}

