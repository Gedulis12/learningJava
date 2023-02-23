import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int userInp; //user input
        int answer;
        Scanner S = new Scanner(System.in); //scanner object
        System.out.println("Enter the number:");
        userInp = S.nextInt();

        // Hard coded
        System.out.println("Hard Coded Variant:\n_______________");
        answer = userInp * 1;
        System.out.println(userInp + "x" + 1 + "=" + answer);
        answer = userInp * 2;
        System.out.println(userInp + "x" + 2 + "=" + answer);
        answer = userInp * 3;
        System.out.println(userInp + "x" + 3 + "=" + answer);
        answer = userInp * 4;
        System.out.println(userInp + "x" + 4 + "=" + answer);
        answer = userInp * 5;
        System.out.println(userInp + "x" + 5 + "=" + answer);
        answer = userInp * 6;
        System.out.println(userInp + "x" + 6 + "=" + answer);
        answer = userInp * 7;
        System.out.println(userInp + "x" + 7 + "=" + answer);
        answer = userInp * 8;
        System.out.println(userInp + "x" + 8 + "=" + answer);
        answer = userInp * 9;
        System.out.println(userInp + "x" + 9 + "=" + answer);

        // For loop
        System.out.println("For Loop Variant:\n_______________");
        for (int i = 1; i <= 9; i++) { // loop over range 1-9 and print answers
            answer = userInp * i;
            System.out.println(userInp + "x" + i + "=" + answer);
        }

        // While loop
        System.out.println("While Loop Variant:\n_______________");
        int i = 1;
        while (i <= 9) { // while loop, continues while i <= 9
            answer = userInp * i;
            System.out.println(userInp + "x" + i + "=" + answer);
            i ++;
        }
    }
}