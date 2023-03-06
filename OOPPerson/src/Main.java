import com.inheritance.base.*;
import com.inheritance.derived.*;
public class Main {
    public static void main(String[] args) {
        //personHandler();
        constructionWorkerHandler();
    }

    static void constructionWorkerHandler() {
        PersonImpl cw1 = new ConstructionWorkerImpl(
                "M", "00007", "Bobby", "Buldur", 46, 97, 190, "Dark", 27, "Higher", "Crane operator", 4700);
        PersonImpl cw2 = new ConstructionWorkerImpl(
                "F", "00008", "Marry", "Jane", 36, 70, 173, "Blonde", 7, "Higher", "Safety instructor", 2300);
        PersonImpl cw3 = new ConstructionWorkerImpl(
                "M", "00009", "Robert", "Sobotka", 52, 111, 180, "Bald", 30, "High school", "Sr. manager", 7000);
        PersonImpl cw4 = new ConstructionWorkerImpl(
                "M", "00010", "Nick", "Norris", 21, 80, 183, "Dark", 1, "High school", "Assistant", 700);
        PersonImpl p1 = new PersonImpl(
                "M", "00003", "John", "Johnson", 21, 80, 180, "brown");
        PersonImpl p2 = new PersonImpl(
                "F", "00004", "Alice", "Brown", 23, 60, 140, "ginger");
        PersonImpl p3 = new PersonImpl(
                "M", "00005", "Muhamed", "Williams", 7, 35, 120, "dark");
        PersonImpl p4 = new PersonImpl(
                "F", "00006", "Mia", "Miller", 76, 80, 172, "blonde");
        PersonImpl[] persons = {cw1, cw2, cw3, cw4, p1, p2, p3, p4};

        int totalPayroll = 0;
        for (PersonImpl person : persons) {
            if (person instanceof ConstructionWorkerImpl) {
                totalPayroll += ((ConstructionWorkerImpl) person).getSalary();
                System.out.println(
                        person.getName()
                        + " "
                        + person.getSurname()
                        + " gets paid "
                        + ((ConstructionWorkerImpl) person).getSalary()
                        + " a month");
                System.out.println("Total payroll of all workers is " + totalPayroll);
            }
        }
    }

    static void personHandler() {
        PersonImpl P1 = new PersonImpl( "M", "00001", "Bob", "Smith", 20, 85, 193, "dark");
        PersonImpl P2 = new PersonImpl( "F", "00002", "Mary", "Wayne", 40, 75, 175, "blonde");
        PersonImpl P3 = new PersonImpl( "M", "00003", "John", "Johnson", 21, 80, 180, "brown");
        PersonImpl P4 = new PersonImpl( "F", "00004", "Alice", "Brown", 23, 60, 140, "ginger");
        PersonImpl P5 = new PersonImpl( "M", "00005", "Muhamed", "Williams", 7, 35, 120, "dark");
        PersonImpl P6 = new PersonImpl( "F", "00006", "Mia", "Miller", 76, 80, 172, "blonde");
        PersonImpl[] persons = {P1, P2, P3, P4, P5, P6};
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

    static void printPersonAttributes(PersonImpl[] persons) {
        for (PersonImpl p : persons) {
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
            String text = String.format(
                    "Person %s: %s %s, %s is %s years old and has a %s hair. %s weight is %s kg and his height is %s cm"
                    , identityCode, name, surname, heOrShe, age, hairColor, hisOrHer, weight, height);
            System.out.println(text);

        }
    }
}