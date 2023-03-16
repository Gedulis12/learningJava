import com.inheritance.base.*;
import com.inheritance.derived.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //personHandler();
        //constructionWorkerHandler();
        PersonImpl cw1 = new ConstructionWorkerImpl(
                "M", "00001", "Bobby", "Buldur", 46, 97, 190, "Dark", 27, "Higher", "Crane operator", 4700);
        PersonImpl cw2 = new ConstructionWorkerImpl(
                "F", "00002", "Marry", "Jane", 36, 70, 173, "Blonde", 7, "Higher", "Safety instructor", 2300);
        PersonImpl cw3 = new ConstructionWorkerImpl(
                "M", "00003", "Robert", "Sobotka", 52, 111, 180, "Bald", 30, "High school", "Sr. manager", 7000);
        PersonImpl cw4 = new ConstructionWorkerImpl(
                "M", "00004", "Nick", "Norris", 21, 80, 183, "Dark", 1, "High school", "Assistant", 700);
        PersonImpl cw5 = new ConstructionWorkerImpl(
                "M", "00005", "Johny", "Johnson", 47, 92, 181, "Dark", 32, "Higher", "Regular Worker", 2000);
        PersonImpl cw6 = new ConstructionWorkerImpl(
                "M", "00006", "Mary", "Marryson", 46, 81, 172, "Dark", 29, "Higher", "Regular Worker", 2100);
        PersonImpl cw7 = new ConstructionWorkerImpl(
                "M", "00007", "Larry", "Larryson", 37, 22, 171, "Dark", 32, "Higher", "Regular Worker", 2200);
        PersonImpl cw8 = new ConstructionWorkerImpl(
                "M", "00008", "Matt", "Mattson", 55, 98, 189, "Dark", 33, "Higher", "Regular Worker", 2300);
        PersonImpl cw9 = new ConstructionWorkerImpl(
                "M", "00009", "Saul", "Goodman", 42, 87, 183, "Dark", 12, "Middle", "Regular Worker", 6000);
        PersonImpl cw10 = new ConstructionWorkerImpl(
                "M", "00010", "Anthony", "Hopkins", 47, 55, 189, "Dark", 11, "Higher", "Regular Worker", 2400);
        List<ConstructionWorkerImpl> consWorkers = new ArrayList<>();
        consWorkers.add((ConstructionWorkerImpl) cw1);
        consWorkers.add((ConstructionWorkerImpl) cw2);
        consWorkers.add((ConstructionWorkerImpl) cw3);
        consWorkers.add((ConstructionWorkerImpl) cw4);
        consWorkers.add((ConstructionWorkerImpl) cw5);
        consWorkers.add((ConstructionWorkerImpl) cw6);
        consWorkers.add((ConstructionWorkerImpl) cw7);
        consWorkers.add((ConstructionWorkerImpl) cw8);
        consWorkers.add((ConstructionWorkerImpl) cw9);
        consWorkers.add((ConstructionWorkerImpl) cw10);

        // print all objects using iterator
        Iterator i = consWorkers.iterator();
        // print all objects with iterator
        while (i.hasNext()) {
            System.out.println(i.next());
        }

        // print all objects using lambda function
        consWorkers.forEach(a -> {
            System.out.println(a);
        });
        System.out.println("-----");
        Iterator<ConstructionWorkerImpl> n = consWorkers.iterator();
        while (n.hasNext()) {
            ConstructionWorkerImpl c = n.next();
            if (c.getTotalWorkRecord() < 4) {
                n.remove();
            }
        }
        System.out.println("-----");

        consWorkers.forEach(a -> {
            System.out.println(a);
        });

        System.out.println("Sorted objects by salary and education: \n");
        Collections.sort(consWorkers);
        System.out.println("-----");

        consWorkers.forEach(a -> {
            System.out.println(a);
        });
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