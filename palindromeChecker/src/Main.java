import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String text;
        Scanner S = new Scanner(System.in);
        System.out.println("Please enter a sentence to check if it's a palindrome");
        while (true) {
            text = S.nextLine();
            if (!text.isEmpty()) {
                checkIfPalindrome(text);
                break;
            } else {
                System.out.println("Please enter a sentence.");
            }
        }
    }
    static void checkIfPalindrome(String text) {
        String reverseString = reverseString(text);
        if (text.equals(reverseString)) {
            System.out.println(text + " in reverse is: " + "'" + reverseString + "'" + " therefore it is a palindrome.");
        } else {
            System.out.println(text + " in reverse is: " + "'" + reverseString + "'" + " therefore it is not a palindrome.");
        }
    }
    static String reverseString(String text) {
        char[] reverse = new char[text.length()];
        int idx = 0;
        for (int i = text.length() - 1; i >= 0; i--) {
            reverse[idx] = text.charAt(i);
            idx ++;
        }
        String reverseString = new String(reverse);
        return reverseString;
    }
}