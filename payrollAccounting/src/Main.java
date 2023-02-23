import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner S2 = new Scanner(System.in);
        String name;
        String askDone;
        System.out.println("Please enter your name. (or don't, it's up to you)");
        name = S2.nextLine();
        if (name.isEmpty()) {
            printGreeting();
        } else {
            printGreeting(name);
        }
        boolean done = false;
        while (!done) {
            System.out.println(getPayroll());
            System.out.println("would you like to calculate again? enter y for yes, anything else for no:");
            askDone = S2.nextLine();
            if (askDone.toLowerCase().equals("y")) {
                done = false;
            } else done = true;
        }
    }

    static String getPayroll() {
        double baseSalary;
        int rating;
        double calculatedSalary;
        String returnString;
        baseSalary = getBaseSalary();
        rating = getSalaryRating();
        calculatedSalary = calculateSalary(baseSalary, rating);
        returnString = "calculated salary is: " + calculatedSalary;
        return returnString;
    }
    static int getSalaryRating() {
        int rating;
        while (true) {
            Scanner S = new Scanner(System.in);
            System.out.println("Please enter the rating of the worker:"
                    + "\n" + "1. Below expectations"
                    + "\n" + "2. In line with expectations"
                    + "\n" + "3. Exceeded expectations");
            rating = S.nextInt();
            if (rating >= 1 && rating <= 3) {
                break;
            } else {
                System.out.println("invalid input, try again.");
            }
        }
        return rating;
    }
    static double getBaseSalary() {
        double baseSalary;
        Scanner S = new Scanner(System.in);
        System.out.println("enter base salary:");
        baseSalary = S.nextDouble();
        return baseSalary;
    }

    static double calculateSalary(double base, int rating) {
        double rate = 0;
        double calculated;
        if (rating == 1) {
            rate = 0.5;
        } else if (rating == 2) {
            rate = (double) 1;
        } else if (rating == 3) {
            rate = 1.5;
        } else System.out.println("invalid selection.");
        calculated = base * rate;
        return calculated;
    }

    static void printGreeting() {
        System.out.println("This is a program that helps calculate payroll based on base salary and employee performance");
    }

    static void printGreeting(String name) {
        System.out.println("Welcome " + name + ", this is a program that helps calculate payroll based on base salary and employee performance");
    }
}