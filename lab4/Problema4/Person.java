import java.util.*;

class Person {
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
		return name + ": " + address;
	}
}

class Student extends Person {
	Vector courses;
	Vector grades;
	
	public Student(String address, String name) {
		super(name, address);
		courses = new Vector();
		grades = new Vector();
	}
	
	public String toString() {
		return super.toString()+"\n"+courses.toString();
	}
	
	public void addCourseGrade(String course, int grade) {
		courses.add(course);
		grades.add(grade);
	}
	
	public void printGrades() {
		System.out.println(grades.toString());
	}
	
	public double getAverageGrade() {
		double sum = 0;
		int i;
		for(i=0;i<grades.size();i++) {
			sum = sum + (double)grades.get(i);
		}
		return sum/grades.size();
	}
}

class Teacher extends Person {
	Vector courses ;
	public Teacher(String name, String address) {
		super(name, address);
		courses = new Vector();
	}
	
	public String toString() {
		return super.toString()+"\n"+courses.toString();
	}
	
	public boolean addCourse(String course) {
		return courses.add(course);
	}
	
	public boolean removeCourse(String course) {
		return courses.remove(course);
	}
	
}