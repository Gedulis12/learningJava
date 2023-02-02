import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double height, weight;
        double bmi;
        Scanner S = new Scanner(System.in);
        System.out.println("Please enter your height (in meters):");
        height = S.nextDouble();
        System.out.println("Please enter your weight (in in kilograms):");
        weight = S.nextDouble();
        bmi = calculateBmi(height, weight);
        printOutput(bmi);
    }

    static double calculateBmi(double h, double w) {
        double bmi;
        bmi = w / Math.pow(h, 2);
        return bmi;
    }
    static void printOutput(double bmi) {
        String rating = "";
        DecimalFormat df = new DecimalFormat("##.##");
        if (bmi < 18.5) {
            rating = "insufficient weight";
        } else if (bmi >= 18.5 && bmi < 25) {
            rating = "normal weight";
        } else if (bmi >= 25 && bmi < 30) {
            rating = "overweight";
        } else if (bmi > 30) {
            rating = "obesity";
        }
        System.out.println("Body Mass Index is: " + df.format(bmi) + " which indicates " + rating);
    }
}