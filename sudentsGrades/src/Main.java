public class Main {
    public static void main(String[] args) {
        Student S1 = new Student("Tom", "Jefferson", new int[] {10, 9, 5});
        Student S2 = new Student("John", "Smith", new int[] {7, 7, 7});
        Student S3 = new Student("Bob", "Jones", new int[] {5, 4, 3, 5});
        Student S4 = new Student("Warren", "Williams", new int[] {2, 2, 2});
        Student S5 = new Student("Lee", "Taylor", new int[] {10, 10,10});
        Student S6 = new Student("Jackie", "Brown", new int[] {5, 5, 10, 9});
        Student S7 = new Student("Daniel", "Davies", new int[] {4, 4, 4, 2, 3});
        Student S8 = new Student("Robert", "Evans", new int[] {9, 7, 6, 5});
        Student S9 = new Student("Edward", "Thomas", new int[] {2, 4, 2});
        Student S10 = new Student("Jeff", "Lee", new int[] {10, 10, 10});
        Student[] students = {S1, S2, S3, S4, S5, S6, S7, S8, S9, S10};
        showDebtors(students);
    }
        static void showDebtors(Student[] students) {
            for (Student s : students) {
                System.out.println("Student " + s.getName() + " has " + s.toString(s.getGrades()) + " and an average of " + s.getAverage() + " he/she is " + s.isDebtor());
            }
        }
}