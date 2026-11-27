public class Student {
    private String name;
    static int numOfSubjects = 3;
    private int[] grades = new int[numOfSubjects];

    public Student(String name, int[] grades) {
        this.name = name;
        for (int i = 0; i < numOfSubjects; i++) {
            this.grades[i] = grades[i];
        }
    }

    public String getName() {
        return name;
    }

    public int getGrade(int i) {
        return grades[i];
    }

    public static boolean checkGrade(int grade) {
        if (grade < 0 || grade > 100) {
            return false;
        }
        return true;
    }

    public boolean passed() {
        for (int i = 0; i < numOfSubjects; i++) {
            if (grades[i] < 50) {
                return false;
            }
        }
        return true;
    }
}
