import java.util.*;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("001", "Jonaitis Jonas", "1998-01-02", "Java", 10);
        Student s2 = new Student("002", "Petraitis Petras", "1997-02-03", "Python", 9);
        Student s3 = new Student("003", "Antanavicius Antanas", "1996-03-05", ".NET", 8);
        Student s4 = new Student("004", "Zuokas Arturas", "1995-04-07", "C", 5);
        Student s5 = new Student("005", "Paksas Rolandas", "1994-05-09", "C", 2);
        Student s6 = new Student("006", "Krabas Visvaldas", "1993-06-11", "Lua", 1);
        Student s7 = new Student("007", "Lukevicius Lukas", "1992-07-17", "Java", 6);
        Student s8 = new Student("008", "Mantaitis Mantas", "1991-08-22", "C", 7);
        Student s9 = new Student("009", "Tuminas Tomas", "1990-09-30", "Go", 9);
        Student s10 = new Student("010", "Algirdaitis Algirdas", "1989-10-20", "Lua", 8);

        ArrayList<Student> students = new ArrayList<>();
        Collections.addAll(students, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10);

        // print all students
        printLine();
        printAllStudents(students);
        printLine();

        // get faculty students
        printLine();
        System.out.println("Get faculty students:");
        getFacultyStudents(students);
        printLine();

        // sorting the list
        printLine();
        System.out.println("Sorting the list:");
        Collections.sort(students);
        System.out.println("SORTED:");
        printAllStudents(students);
        printLine();

        // deleting the worst students
        printLine();
        System.out.println("Deleting the worst students:");
        deleteBelowMinimum(students);
        printAllStudents(students);
        printLine();

        // swapping best and worst averages:
        printLine();
        System.out.println("Swapping best and worst averages:");
        swapBestWithWorstAverages(students);
        printAllStudents(students);
        printLine();

        // search for students by surname or birthdate
        printLine();
        System.out.println("Searching for students:");
        searchForStudents(students);
        printLine();
    }

    static void searchForStudents(ArrayList<Student> students) {
        System.out.println("Search for students either by surname or birth date (date format is yyyy-mm-dd)");
        Scanner sc = new Scanner(System.in);
        String search = sc.nextLine().toLowerCase();
        int total = 0;
        for (Student s : students) {
            if (s.getSurnameName().toLowerCase().contains(search) || s.getBirthDate().contains(search)) {
                System.out.println(s);
                total ++;
            }
        }
        System.out.println("Total students found: " + total);
    }

    static void swapBestWithWorstAverages(ArrayList<Student> students) {
        Student max = students.stream().max(Comparator.comparing(Student::getAverage)).get();
        Student min = students.stream().min(Comparator.comparing(Student::getAverage)).get();
        double temp;
        temp = max.getAverage();
        max.setAverage(min.getAverage());
        min.setAverage(temp);
    }

    static void deleteBelowMinimum(ArrayList<Student> students) {
        Iterator<Student> i = students.iterator();
        while (i.hasNext()) {
            Student s = i.next();
            if (s.getAverage() < 5) {
                i.remove();
            }
        }
    }

    static void printAllStudents(ArrayList<Student> students) {
        for (Student s : students) {
            System.out.println(s);
        }
    }

    static void getFacultyStudents(ArrayList<Student> students) {
        Set<String> groups = new HashSet<>();
        int idx = 1;
        int groupCount = 0;
        Scanner sc = new Scanner(System.in);
        for (Student s : students) {
            groups.add(s.getGroup());
        }
        for (String group : groups) {
            System.out.println(idx + ") " + group);
            idx++;
        }
        System.out.println("Which group would you like to list? (enter group name)");
        String selection = sc.nextLine();
        System.out.println("Students in group " + selection + ":");
        for (Student s : students) {
            if (groups.contains(selection) && s.getGroup().equals(selection)) {
                System.out.println(s);
                groupCount++;
            }
        }
        System.out.println("total: " + groupCount);
    }

    static void printLine() {
        System.out.println("--------------------");
    }
}