import java.util.Comparator;

public class Student implements Comparable<Student> {
    private String studentId;
    private String surnameName;
    private String birthDate;;
    private String group;
    private double average;

    public Student () {};

    public Student (String studentId, String surnameName, String birthDate, String group, double average) {
       this.studentId = studentId;
       this.surnameName = surnameName;
       this.birthDate = birthDate;
       this.group = group;
       this.average = average;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getSurnameName() {
        return this.surnameName;
    }

    public void setSurnameName(String surnameName) {
        surnameName = this.surnameName;
    }

    public double getAverage() {
        return this.average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getGroup() {
        return this.group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student: " +
                "studentId='" + studentId + '\'' +
                ", surnameName='" + surnameName + '\'' +
                ", birthDate=" + birthDate +
                ", group='" + group + '\'' +
                ", average=" + average;
    }

    @Override
    public int compareTo(Student student) {
        return Comparator
                .comparing(Student::getAverage)
                .reversed()
                .compare(this, student);
    }
}
