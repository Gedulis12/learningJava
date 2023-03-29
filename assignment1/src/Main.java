import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    // class name must be passed when creating a logger
    static Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        Scanner T = new Scanner(System.in);
        String userAnswer;
        boolean tryAgain = true;
        while (tryAgain) {
            try {
                String operation = getOperation();
                ArrayList<Integer> numbers = getNumbers();
                double num1 = numbers.get(0);
                double num2 = numbers.get(1);
                if (operation.equals("#")) {
                    for (int i = 13; i < 26; i++) {
                        double answer = 0;
                        answer = (num1 * num2 + ((num2 - num1) / num1 * i));
                        if (answer < 6) {
                            System.out.println(num1 + " * " + num2 + " + (" + num2 + " - " + num1 + ")" + " / " + num1 + " * " + i + " = " + (double) answer + " < 6");
                        } else if (answer == 6) {
                            System.out.println(num1 + " * " + num2 + " + (" + num2 + " - " + num1 + ")" + " / " + num1 + " * " + i + " = " + (double) answer + " == 6");
                        } else if (answer > 6) {
                            System.out.println(num1 + " * " + num2 + " + (" + num2 + " - " + num1 + ")" + " / " + num1 + " * " + i + " = " + (double) answer + " > 6");
                        }
                    }
                } else {
                    if (operation.equals("/") && num2 == 0) {
                        System.out.println("Division by zero is impossible, please try again");
                        continue;
                    }
                    double answer = 0;
                    answer = calculate(num1, num2, operation);
                    System.out.println(num1 + operation + num2 + "=" + answer);
                }
            } catch (InputMismatchException e) {
                System.out.println("Calculations can only be performed on numbers, please try again");
                continue;
            }
            System.out.println("would you like to do more calculations? (enter Y for 'yes', anything else for 'no)");
            userAnswer = T.nextLine();
            if (userAnswer.equals("y") || userAnswer.equals("Y")) {
                tryAgain = true;
            } else {
                tryAgain = false;
            }
        }
    }

    static String getOperation() {
        String operation;
        List<String> validInputs = Arrays.asList("+", "-", "*", "/", "#");
        while (true) {
            Scanner O = new Scanner(System.in);
            System.out.println("Please enter the operation which will be applied to the entered numbers (+, -, *, /, #)");
            operation = O.nextLine();
            if (!validInputs.contains(operation)) {
                System.out.println("Invalid operation, please use one of the following: + - / *");
            } else {
                break;
            }
        }
        return operation;
    }

    static ArrayList<Integer> getNumbers() {
        int num1 = 0;
        int num2 = 0;
        Scanner N = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        System.out.println("Please enter the first number:");
        num1 = N.nextInt();
        numbers.add(num1);
        System.out.println("Please enter the second number:");
        num2 = N.nextInt();
        numbers.add(num2);
        return numbers;
    }

    static double calculate(double num1, double num2, String operation) {
        double answer = 0;
        if (operation.equals("+")) {
            answer = num1 + num2;
        } else if (operation.equals("-")) {
            answer = num1 - num2;
        } else if (operation.equals("*")) {
            answer = num1 * num2;
        } else if (operation.equals("/")) {
            answer = (double) num1 / num2;
        }
        return answer;
    }
}