import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        String name;
        System.out.println("Please enter your name. (or don't, it's up to you)");
        name = S.nextLine();
        if (name.isEmpty()) {
            printGreeting();
        } else {
            printGreeting(name);
        }
        calculate();
    }

    /**
     * This function performs mathematical operations on two numbers and prints the answer
     */
    static void calculate() {
        Scanner T = new Scanner(System.in);
        String userAnswer;
        boolean tryAgain = true;
        while (tryAgain) {
            String operation = getOperation();
            double answer = 0;
            if (operation.equals("+") || operation.equals("*") || operation.equals("#")) {
                try {
                    ArrayList<Integer> numbers = getNumbers();
                    double num1 = numbers.get(0);
                    double num2 = numbers.get(1);
                    if (operation.equals("+")) {
                        answer = add((int) num1, (int) num2);
                        System.out.println(num1 + operation + num2 + "=" + answer);
                    } else if (operation.equals("*")) {
                        multiply((int) num1, (int) num2);
                    } else {
                        for (int i = 13; i < 26; i++) {
                            double answer2 = 0;
                            answer2 = (num1 * num2 + ((num2 - num1) / num1 * i));
                            if (answer2 < 6) {
                                System.out.println(num1 + " * " + num2 + " + (" + num2 + " - " + num1 + ")" + " / " + num1 + " * " + i + " = " + (double) answer2 + " < 6");
                            } else if (answer == 6) {
                                System.out.println(num1 + " * " + num2 + " + (" + num2 + " - " + num1 + ")" + " / " + num1 + " * " + i + " = " + (double) answer2 + " == 6");
                            } else if (answer2 > 6) {
                                System.out.println(num1 + " * " + num2 + " + (" + num2 + " - " + num1 + ")" + " / " + num1 + " * " + i + " = " + (double) answer2 + " > 6");
                            }
                        }
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Calculations can only be performed on numbers, please try again");
                    continue;
                }
            } else if (operation.equals("-")) {
                answer = subtract();
                System.out.println(answer);
            } else if (operation.equals("/")) {
                divide();
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

    /**
     * This functions asks the user to input operation which will be used in calculations
     * @return entered symbol (/ * + -)
     */
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

    /**
     * This function asks to input two numbers and returns them
     * @return numbers[] {num1, num2}
     */
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

    /**
     * This function asks for two numbers and subtracts them
     * @return calculated answer
     */
    static double subtract() {
        ArrayList<Integer> numbers = getNumbers();
        int num1, num2;
        double answer;
        num1 = numbers.get(0);
        num2 = numbers.get(1);
        answer = num1 - num2;
        System.out.print(num1 + "-" + num2 + "=");
        return answer;
    }

    /**
     *
     * @param num1 first number
     * @param num2 second number
     * @return answer, calulated by adding num1 and num2
     */
    static double add(int num1, int num2) {
        double answer;
        answer = num1 + num2;
        return answer;
    }

    /**
     * this function asks for two numbers, divides them and returns prints the answer
     */
    static void divide() {
        while (true) {
            try {
                ArrayList<Integer> numbers = getNumbers();
                double answer = 0;
                double num1 = numbers.get(0);
                double num2 = numbers.get(1);
                if (num2 == 0) {
                    System.out.println("Division by zero is impossible, please try again");
                    continue;
                } else {
                    answer = num1 / num2;
                    System.out.println(num1 + "/" + num2 + "=" + answer);
                }
            } catch (InputMismatchException e) {
                System.out.println("Calculations can only be performed on numbers, please try again");
                continue;
            }
            break;
        }
    }

    /**
     * This function multiplies two numbers and prints the answer
     * @param num1 first number
     * @param num2 second number
     */
    static void multiply(int num1, int num2) {
        while (true) {
            try {
                double answer = 0;
                answer = num1 * num2;
                System.out.println(num1 + "x" + num2 + "=" + answer);
            } catch (InputMismatchException e) {
                System.out.println("Calculations can only be performed on numbers, please try again");
            }
            break;
        }
    }

    /**
     * This function prints greeting message
     */
    static void printGreeting() {
        System.out.println("This is a simple calculator app");
    }

    /**
     * This function prints greeting message
     * @param name name of the user
     */
    static void printGreeting(String name) {
        System.out.println("Welcome " + name + ", this is a simple calculator app");
    }
}