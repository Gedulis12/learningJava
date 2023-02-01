import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String userIn;
        HashMap<String, String> phoneKeys = new HashMap<String, String>();
        phoneKeys.put("2", "abc");
        phoneKeys.put("3", "def");
        phoneKeys.put("4", "ghi");
        phoneKeys.put("5", "jkl");
        phoneKeys.put("6", "mno");
        phoneKeys.put("7", "pqrs");
        phoneKeys.put("8", "tuv");
        phoneKeys.put("9", "wxyz");

        Scanner S = new Scanner(System.in);
        System.out.println("Enter a row of numbers:");
        userIn = S.nextLine();
        char [] userInArray = userIn.toCharArray();
        for (char x:userInArray) {
            System.out.println(phoneKeys.get(Character.toString(x)));
        }
    }
}