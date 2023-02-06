import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        String digits;
        System.out.println("Please enter a row of digits:");
        digits = S.nextLine();
        List<String> result = new ArrayList<String>();
        String [] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        if (digits == null | digits.length() == 0) {
            System.out.println("no numbers were entered.");
        }
        long startTime = System.nanoTime();
        generateLetterCombinations(result, digits, "", mapping, 0);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        for (String x:result) {
            System.out.println(x);
        }
        long endTime2 = System.nanoTime();
        long duration2 = (endTime2 - startTime) / 1000000;
        System.out.println("number of lines printed: " + result.size());
        System.out.println("recursion executed in " + duration + " milliseconds\n" + "printing executed in " + duration2 + "milliseconds");
    }
    static void generateLetterCombinations(List<String> result, String digits, String current, String[] mapping, int index) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        String letters = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i<letters.length(); i++) {
            generateLetterCombinations(result, digits, current + letters.charAt(i), mapping, index + 1);
        }
    }
}