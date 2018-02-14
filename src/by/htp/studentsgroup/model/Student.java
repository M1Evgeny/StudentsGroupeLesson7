package by.htp.studentsgroup.model;

public class Student {
	private String studentName;
	private int yearOfAdmission;
	private int studentAge;

	public Student(String name, int year, int age) {
		studentName = name;
		yearOfAdmission = year;
		studentAge = age;
	}

	public String getStudentName() {
		return studentName;
	}

	public int getYearOfAdmission() {
		return yearOfAdmission;
	}

	public int getStudentsAge() {
		return studentAge;
	}
}
