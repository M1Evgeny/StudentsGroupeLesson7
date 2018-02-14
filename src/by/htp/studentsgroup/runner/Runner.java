package by.htp.studentsgroup.runner;

import by.htp.studentsgroup.model.Student;
import by.htp.studentsgroup.model.StudentsGroup;

public class Runner {

	public static void main(String[] args) {
		Student s1 = new Student("Tom", 2007, 29);
		Student s2 = new Student("John", 2006, 17);
		Student s3 = new Student("Sam", 2008, 27);
		Student s4 = new Student("Nick", 2009, 19);
		Student s5 = new Student("Mike", 2007, 18);

		StudentsGroup sg = new StudentsGroup(1);
		sg.addStudent(s1);
		sg.addStudent(s2);
		sg.addStudent(s3);
		sg.addStudent(s4);
		sg.addStudent(s5);

		sg.addStudent(s1);
		sg.addStudent(s2);
		sg.addStudent(s3);
		sg.addStudent(s4);
		sg.addStudent(s5);

		sg.addStudent(s1);
		sg.addStudent(s2);
		sg.addStudent(s3);
		sg.addStudent(s4);
		sg.addStudent(s5);

		sg.countAverageAgeOfStudents();

		sg.addStudent(s5);

		sg.numberOfEntriesInTheYear(2007);

		sg.infoAboutFrequentYear();

		sg.groupInfo();

		sg.bubbleSortByYearOfAdmission();

		System.out.println("____");

		sg.groupInfo();

		sg.bubbleSortByStudentsAge();

		System.out.println("____");
		sg.groupInfo();

	}

}
