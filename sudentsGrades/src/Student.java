import java.util.Arrays;

public class Student {
    private String name;
    private String surname;
    private int[] grades;
    private double average;

    public Student() {
    }

    public Student(String name, String surname, int[] grades) {
        this.name = name;
        this.surname = surname;
        this.grades = grades;
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public double getAverage() {
        double average = 0;
        int[] grades = getGrades();
        int gradeSum = 0;
        int gradeCount = 0;
        for (int i : grades) {
            gradeSum += i;
            gradeCount += 1;
        }
        average = (double) gradeSum / gradeCount;
        return average;
    }

    public void addGrade(int grade) {
        int[] grades = new int[1];
        int[] grades2 = getGrades();
        if (getGrades() == null) {
            grades[0] = grade;
            this.grades = grades;
        } else {
            int newLen = grades2.length + 1;
            int[] newGradeArray = new int[newLen];
            for (int i = 0; i < getGrades().length; i++) {
                newGradeArray[i] = grades2[i];
            }
            newGradeArray[getGrades().length] = grade;
            this.grades = newGradeArray;
        }
    }

    public String toString(int[] grades) {
        return "grades: " + Arrays.toString(grades);
    }

    public String isDebtor() {
        String text;
        if (getAverage() < 3.5) {
            text = "debtor";
        } else {
            text = "not a debtor";
        }
        return text;
    }
}