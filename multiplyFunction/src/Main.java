import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num1;
        int num2;
        int answer;
        printInfo(1);
        Scanner S = new Scanner(System.in);
        printInfo(2);
        num1 = S.nextInt();
        printInfo(3);
        num2 = S.nextInt();
        answer = multiply(num1, num2);
        System.out.println(num1 + "x" + num2 + "=" + answer);
    }

    static int multiply(int x, int y) {
        int answer;
        answer = x * y;
        return answer;
    }

    static void printInfo(int x) {
        if (x == 1) {
            System.out.println("The program will take two numbers. multiply them and return the answer.");
        } else if (x == 2) {
            System.out.println("Enter first number:");
        } else if (x == 3) {
            System.out.println("Enter second number:");
        }
    }
}