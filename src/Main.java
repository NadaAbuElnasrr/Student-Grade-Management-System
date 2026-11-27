Scanner scan = new Scanner(System.in);
int numOfStudents = 5;


public Student fillData(int i) {
    System.out.print("Enter student" + (i + 1) + "'s name: ");
    String name = scan.nextLine();
    int[] grades = new int[Student.numOfSubjects];
    for (int j = 0; j < Student.numOfSubjects; j++) {
        System.out.print("Grade" + (j + 1) + " : ");
        grades[j] = scan.nextInt();
        while (!Student.checkGrade(grades[j])) {
            System.out.println("Invalid grade.Try again");
            System.out.print("Grade" + (j + 1) + " : ");
            grades[j] = scan.nextInt();
        }
    }
    scan.nextLine();
    return new Student(name, grades);
}

public void showNames(Student[] s) {
    for (int i = 0; i < numOfStudents; i++) {
        System.out.println(s[i].getName());
    }
}

public void showGrades(Student[] s) {
    for (int i = 0; i < numOfStudents; i++) {
        System.out.println("Student: " + s[i].getName());
        for (int j = 0; j < Student.numOfSubjects; j++) {
            System.out.println("Subject" + (j + 1) + ": " + s[i].getGrade(j));
        }
        System.out.println();
    }
}

public void searchStudentByName(Student[] s, String name) {
    boolean found = false;
    for (int i = 0; i < numOfStudents; i++) {
        if (s[i].getName().equalsIgnoreCase(name)) {
            found = true;
            for (int j = 0; j < Student.numOfSubjects; j++) {
                System.out.println("Grade" + (j + 1) + " : " + s[i].getGrade(j));
            }
            break;
        }
    }
    if (!found) {
        System.out.println("No such student");
    }
}

public int countPassedStudents(Student[] s) {
    int count = 0;
    for (int i = 0; i < numOfStudents; i++) {
        if (s[i].passed()) {
            count++;
        }
    }
    return count;
}

void main() {
    //Filling Data

    System.out.println("Enter the data of the "+numOfStudents+ " students");
    Student[] student = new Student[numOfStudents];
    for (int i = 0; i < numOfStudents; i++) {
        student[i] = fillData(i);
    }
    boolean exit = false;
    do {
        System.out.println("================MENU================");
        System.out.println("1. Show All Students names.\n" + "2. Show all Students grades in each subject.\n" + "3. Search Student by name.\n" + "4. Count Passed Students\n" + "0. Exit");
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                showNames(student);
                break;
            case 2:
                showGrades(student);
                break;
            case 3:
                scan.nextLine();
                System.out.print("Enter student name: ");
                String name = scan.nextLine();
                searchStudentByName(student, name);
                break;
            case 4:
                System.out.println("Passed students: "+countPassedStudents(student));
                break;
            case 0:
                exit = true;
                break;
            default:
                System.out.println("Invalid choice. Try again");
        }
    } while (!exit);
}
