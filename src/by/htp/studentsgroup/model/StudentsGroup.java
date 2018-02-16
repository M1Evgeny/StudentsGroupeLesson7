package by.htp.studentsgroup.model;

/*
 методом вставок
 методом выбора
 быстрой сортировкой
 */

public class StudentsGroup {
	private int groupNumber;
	Student[] students;
	private int studentCount;

	public StudentsGroup(int number) {
		groupNumber = number;
	}

	public int getGroupNumber() {
		return groupNumber;
	}

	public int getStudentCount() {
		return studentCount;
	}

	public void addStudent(Student student) {
		if (students != null) {
			if (studentCount < students.length) {
				addNewStudent(student);
			} else {
				if (studentCount < 15) {
					expandTheGroup();
					addNewStudent(student);
				} else {
					System.out.println("The group is full");
				}
			}
		} else {
			students = new Student[5];
			addNewStudent(student);
		}
	}

	private void addNewStudent(Student student) {
		students[studentCount] = student;
		studentCount++;
	}

	private void expandTheGroup() {
		Student[] students = new Student[studentCount + 5];
		for (int i = 0; i < this.students.length; i++) {
			students[i] = this.students[i];
		}
		this.students = students;
	}

	public void countAverageAgeOfStudents() {
		if (studentCount >= 5) {
			int age = 0;
			for (Student s : students) {
				if (s != null) {
					age += s.getStudentsAge();
				}
			}
			int averageAge = age / studentCount;
			System.out.println("Average age of the students in the group " + groupNumber + " is " + averageAge);
		} else {
			System.out.println("There are not enough students in the group");
		}
	}

	public void numberOfEntriesInTheYear(int year) {
		int yearCount = 0;
		if (studentCount >= 5) {
			for (Student s : students) {
				if (s != null) {
					if (year == s.getYearOfAdmission()) {
						yearCount++;
					}
				}
			}
		}
		System.out.println("The number of enrolled students in " + year + " is " + yearCount);
	}

	private int frequentYear() {
		int c = 0;
		int year = 0;
		for (int i = 0; i < students.length; i++) {
			if (c == 0) {
				year = students[i].getYearOfAdmission();
				c++;
			} else {
				if (year == students[i].getYearOfAdmission()) {
					c++;
				} else {
					c--;
				}
			}
		}
		return c > 0 ? year : null;
	}

	public void infoAboutFrequentYear() {
		int year = frequentYear();
		int studentCount = 0;
		if (year != 0) {
			for (Student s : students) {
				if (s != null) {
					if (year == s.getYearOfAdmission()) {
						studentCount++;
					}
				}
			}
		}
		System.out.println(year + " - " + studentCount);
	}

	public void bubbleSortByYearOfAdmission() {
		if (students != null) {
			for (int i = students.length - 1; i > 0; i--) {
				for (int j = 0; j < i; j++) {
					if (students[j] != null & students[j + 1] != null) {
						if (students[j].getYearOfAdmission() > students[j + 1].getYearOfAdmission()) {
							Student s = students[j];
							students[j] = students[j + 1];
							students[j + 1] = s;
						}
					}
				}
			}
		}
	}

	public void groupInfo() {
		if (students != null) {
			System.out.println("Group № " + groupNumber);
			for (Student s : students) {
				if (s != null) {
					System.out.println(s.getStudentName() + " " + s.getStudentsAge() + " " + s.getYearOfAdmission());
				}
			}
		}
	}

	public void bubbleSortByStudentsAge() {
		if (students != null) {
			for (int i = students.length - 1; i > 0; i--) {
				for (int j = 0; j < i; j++) {
					if (students[j] != null & students[j + 1] != null) {
						if (students[j].getStudentsAge() > students[j + 1].getStudentsAge()) {
							Student s = students[j];
							students[j] = students[j + 1];
							students[j + 1] = s;
						}
					}
				}
			}
		}
	}

	public void quickSort() {
		int start = 0;
		int end = students.length - 1;
		doSort(start, end);
	}

	private void doSort(int start, int end) {
		if (start >= end) {
			return;
		}
		int i = start;
		int j = end;
		int mid = (i + j) / 2;
		while (i < j) {
			while (i < mid && students[i].getStudentsAge() <= students[mid].getStudentsAge()) {
				i++;
			}
			while (j > mid && students[mid].getStudentsAge() <= students[j].getStudentsAge()) {
				j--;
			}
			if (i < j) {
				Student temp = students[i];
				students[i] = students[j];
				students[j] = temp;
				if (i == mid) {
					mid = j;
				}
				if (j == mid) {
					mid = i;
				}
			}
		}
		doSort(start, mid);
		doSort(mid + 1, end);
	}

	public void insertIntoSort() {
		Student temp;
		int j = 0;
		for (int i = 0; i < students.length - 1; i++) {
			if (students[i].getStudentsAge() > students[i + 1].getStudentsAge()) {
				temp = students[i + 1];
				students[i + 1] = students[i];
				j = i;
				while (j > 0 && temp.getStudentsAge() < students[j - 1].getStudentsAge()) {
					students[j] = students[j - 1];
					j--;
				}
				students[j] = temp;
			}
		}
	}
}
