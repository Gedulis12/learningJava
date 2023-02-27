public class Main {
    public static void main(String[] args) {
        personHandler();
        //studentHandler();
    }

    static void personHandler() {
        Person P1 = new Person("M", "00001", "Bob", "Smith", 20, 85, 193, "dark");
        Person P2 = new Person("F", "00002", "Mary", "Wayne", 40, 75, 175, "blonde");
        Person P3 = new Person("M", "00003", "John", "Johnson", 21, 80, 180, "brown");
        Person P4 = new Person("F", "00004", "Alice", "Brown", 23, 60, 140, "ginger");
        Person P5 = new Person("M", "00005", "Muhamed", "Williams", 7, 35, 120, "dark");
        Person P6 = new Person("F", "00006", "Mia", "Miller", 76, 80, 172, "blonde");
        Person[] persons = {P1, P2, P3, P4, P5, P6};
        System.out.println("Once upon a time there were 6 persons:");
        printPersonAttributes(persons);
        System.out.println("--------------------------------------------------------------------");
        System.out.println("Some time has passed and something has changed in each persons life:");
        System.out.println(P1.getName() + " apart from growing older did not change much.");
        P1.setAge(P1.getAge() + 2);
        System.out.println(P2.getName() + " gained some weight");
        P2.setWeight(P2.getWeight() + 12);
        P2.setAge(P2.getAge() + 2);
        System.out.println(P3.getName() + " painted his hair");
        P3.setHairColor("Blonde");
        P3.setAge(P3.getAge() + 2);
        System.out.println(P4.getName() + " got married to " + P3.getName());
        P4.setSurname(P3.getSurname());
        P4.setAge(P4.getAge() + 2);
        System.out.println(P5.getName() + " grew tall and strong");
        P5.setHeight(P5.getHeight() + 25);
        P5.setWeight(P5.getWeight() + 10);
        P5.setAge(P5.getAge() + 2);
        System.out.println(P6.getName() + " shrinked in size");
        P6.setAge(P6.getAge() + 2);
        System.out.println("--------------------------------------------------------------------");
        printPersonAttributes(persons);
    }

    static void printPersonAttributes(Person[] persons) {
        for (Person p : persons) {
            String name = p.getName();
            String surname = p.getSurname();
            String gender = p.getGender();
            String identityCode = p.getIdentityCode();
            int age = p.getAge();
            int height = p.getHeight();
            int weight = p.getWeight();
            String hairColor = p.getHairColor();
            String heOrShe;
            String hisOrHer;
            if (gender.equals("M")) {
                heOrShe = "he";
                hisOrHer = "his";
            } else {
                heOrShe = "she";
                hisOrHer = "his";
            }
            String text = String.format("Person %s: %s %s, %s is %s years old and has a %s hair. %s weight is %s kg and his height is %s cm"
                    , identityCode, name, surname, heOrShe, age, hairColor, hisOrHer, weight, height);
            System.out.println(text);

        }
    }

    static void studentHandler() {
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
        printStudentAttributes(students);
        S1.setName("Robinson");
        S2.setSurname("Martingale");
        S3.setGroup("Python");
        S4.setId(6);
        S5.setName("Petras");
        System.out.println("###############################################################");
        printStudentAttributes(students);

    }

    static void printStudentAttributes(Student[] students) {
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