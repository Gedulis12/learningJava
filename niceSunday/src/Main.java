import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String weekday;
        Scanner S = new Scanner(System.in);
        List<String> daysOfWeek = Arrays.asList("monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday");

        while (true) {
            System.out.println("Please enter a day of the week:");
            weekday = S.nextLine().toLowerCase();
            if (!daysOfWeek.contains(weekday)) {
                System.out.println("Please enter a valid day of the week.");
                weekday = S.nextLine();
            } else {
                System.out.println("You have entered '"+ weekday +"'");
                if (weekday.equals("sunday")){
                    System.out.println("Are You planning to go to church? ('y' for yes, anything else for no):");
                    String churchGoing = S.nextLine().toLowerCase();
                    if (churchGoing.equals("y")) {
                        System.out.println("When does the Mass begin?");
                        String askTime = S.nextLine();
                        System.out.println("Have a nice Mass!");
                        break;
                    } else {
                        System.out.println("Have a nice Sunday!");
                        break;
                    }
                }
            }
        }
    }
}