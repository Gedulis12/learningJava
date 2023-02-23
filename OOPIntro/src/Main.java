public class Main {
    public static void main(String[] args) {
        Student S1 = new Student(0, "Alice");
        Student S2 = new Student(1, "Bob");
        Student S3 = new Student(2, "John", "Smith", "Java");
        Student S4 = new Student(3, "Jeff", "Johnson", "Java");
        Student S5 = new Student();
        S1.setSurname("Smith");
        S1.setGroup("Java");
        S2.setSurname("Johnson");
        S2.setGroup("C");
        S5.setId(4);
        S5.setName("Jonas");
        S5.setSurname("Petraitis");
        S5.setGroup("C++");
        Student[] students = {S1, S2, S3, S4, S5};
        printObjectAttributes(students);
        S1.setName("Robinson");
        S2.setSurname("Martingale");
        S3.setGroup("Python");
        S4.setId(6);
        S5.setName("Petras");
        System.out.println("###############################################################");
        printObjectAttributes(students);

    }

    static void printObjectAttributes(Student[] students) {
        for (Student S : students) {
            int id = S.getId();
            String name = S.getName();
            String surname = S.getSurname();
            String group = S.getGroup();
            System.out.println("Introduction of student " + id + ":\n"
                    + "Hi, my name is " + name + " " + surname + ", and i am studying " + group + "\n"
                    + "________________________________________");
        }
    }
}