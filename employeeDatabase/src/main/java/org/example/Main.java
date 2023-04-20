package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Jonas", "Jonaitis", 2000);
        Employee e2 = new Employee("Petras", "Petraitis", 1000);
        Employee e3 = new Employee("Antanas", "Antanaitis", 3000);
        Employee e4 = new Employee("Jonas", "Jonaitis", 4000);

        // for updating
        Employee e5 = new Employee(3,"Antanas", "Antanaitis", 3400);

        // EmployeeDAO.create(e1);
        //  EmployeeDAO.create(e2);
        //  EmployeeDAO.create(e3);
        //  EmployeeDAO.create(e4);

        printAllEmployees();
        System.out.println("--------------");
        String search = "Jo";
        searchByName(search);
        System.out.println("--------------");
        EmployeeDAO.update(e5);
        printAllEmployees();
        System.out.println("--------------");
        String countSearch = "Jon";
        int nameCount = EmployeeDAO.countEntriesByName(countSearch);
        System.out.println("total entries when searching for employees name '" + countSearch + "': "  + nameCount);
    }
    static void searchByName(String search) {
        ArrayList<Employee> employees1 = EmployeeDAO.searchByEmployeeName(search);
        for (Employee e : employees1) {
            System.out.println(e.toString());
        }
    }
    static void printAllEmployees() {
        ArrayList<Employee> employees = EmployeeDAO.showAllEntries();
        for (Employee e : employees) {
            System.out.println(e);
        }
    }

}

/*
. KURIAMAS NAUJAS PROJEKTAS
2.1. Sukurti db 'employee' lentelę:

    id;
    name;
    surname;
    salary.

2.2. Sukurti Employee klasę.
2.3. Pridėti sql-connector-java failą į projektą.
2.4. Parašyti kodą, kurio pagalba sukurtumėte naują įrašą db.
2.5. Parašyti kodą, kurio pagalba atspausdintumėte į terminalą visus įrašus iš db.
2.6. Atlikti paiešką pagal darbuotojo vardą.
2.7. Paredaguoti esamą įrašą.
2.8. Ištrinti esamą įrašą pagal įrašo id.
2.9. Paskaičiuoti kiek yra įrašų, kurių vardas yra "Jonas".
2.10. Parašyti JUnit CRUD testus DAO klasei.
 */