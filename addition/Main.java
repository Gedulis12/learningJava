import java.util.Scanner;

// addition calculation
public class Main{
    public static void main (String[] args) {
        // Declare variables
        int sk1, sk2, sk3;
        int addition;

        System.out.println("Subtraction");
        System.out.println("Enter first number:");
        Scanner S = new Scanner(System.in); // Create a scanner object
        sk1 = S.nextInt(); // Read user input for sk1
        System.out.println("\nEnter second number:\n");
        sk2 = S.nextInt(); // Read user input for sk2
        System.out.println("\nEnter third number:\n");
        sk3 = S.nextInt(); // Read user input for sk3
        addition = sk1 + sk2 + sk3;
        System.out.println("\naddition: \n" + sk1 + " + " + sk2 + " + " + sk3 + " = " + addition); // Output addition
    }
}
