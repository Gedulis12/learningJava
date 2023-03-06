import com.inheritance.base.PersonImpl;

public class Main {
    public static void main(String[] args) {
        personHandler();
    }

    static void personHandler() {
        PersonImpl P1 = new PersonImpl("M", "00001", "Bob", "Smith", 20, 85, 193, "dark");
        PersonImpl P2 = new PersonImpl("F", "00002", "Mary", "Wayne", 40, 75, 175, "blonde");
        PersonImpl P3 = new PersonImpl("M", "00003", "John", "Johnson", 21, 80, 180, "brown");
        PersonImpl P4 = new PersonImpl("F", "00004", "Alice", "Brown", 23, 60, 140, "ginger");
        PersonImpl P5 = new PersonImpl("M", "00005", "Muhamed", "Williams", 7, 35, 120, "dark");
        PersonImpl P6 = new PersonImpl("F", "00006", "Mia", "Miller", 76, 80, 172, "blonde");
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
            String text = String.format("Person %s: %s %s, %s is %s years old and has a %s hair. %s weight is %s kg and his height is %s cm"
                    , identityCode, name, surname, heOrShe, age, hairColor, hisOrHer, weight, height);
            System.out.println(text);

        }
    }
}

/*
1.2. Pervadinti 'Zmogus' klasę į 'ZmogusImpl'.
1.3. Sukurti interface 'Zmogus' (su 'Zmogus' klasės get'erių ir set'erių antraštėmis);
1.4. Klasė 'ZmogusImpl' turi realizuoti interface 'Zmogus'.
 */

/*
2. Statybininkas.
2.1. Sukurti interface 'Statybininkas' pakete 'com.paveldejimas.isvestine';
2.2. Sukurti klasę 'StatybininkasImpl', realizuojančią interface 'Statybininkas', pakete 'com.paveldejimas.isvestine':
	stažas;
	išsilavinimas;
	specializacija;
	atlyginimas.
 */