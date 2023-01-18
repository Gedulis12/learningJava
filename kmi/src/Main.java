import java.text.DecimalFormat;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        double height, weight;
        double bmi;
        String rating;

        Scanner S = new Scanner(System.in);
        System.out.println("Please enter your height (in meters):");
        height = S.nextDouble();
        System.out.println("Please enter your weight (in in kilograms):");
        weight = S.nextDouble();
        bmi = weight / Math.pow(height, 2);
        DecimalFormat df = new DecimalFormat("##.##");

        if (bmi < 18.5) {
            rating = "insufficient weight";
            System.out.println("Your Body Mass Index is: " + df.format(bmi) + " which indicates " + rating);
        } else if (bmi >= 18.5 && bmi < 25) {
            rating = "normal weight";
            System.out.println("Your Body Mass Index is: " + df.format(bmi) + " which indicates " + rating);
        } else if (bmi >= 25 && bmi < 30) {
            rating = "overweight";
            System.out.println("Your Body Mass Index is: " + df.format(bmi) + " which indicates " + rating);
        } else if (bmi > 30) {
            rating = "obesity";
            System.out.println("Your Body Mass Index is: " + df.format(bmi) + " which indicates " + rating);
    /* cia klausimas, jei if blokuose tik deklaruoju 'rating' variable ir pabaigoje darau sout, gaunu klaida, ar yra budas nekartoti system.out kiekviename IF clause?, pvz:
        if (bmi < 18.5) {
            rating = "insufficient weight";
        } else if (bmi >= 18.5 && bmi < 25) {
            rating = "normal weight";
        } else if (bmi >= 25 && bmi < 30) {
            rating = "overweight";
        } else if (bmi > 30) {
            rating = "obesity";
        }
        System.out.println("Your Body Mass Index is: " + df.format(bmi) + " which indicates " + rating);
     */
        }
    }
}