import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        ArrayList<Integer> sumlist = new ArrayList<>();
        int userIn;
        int count = 1;
        System.out.println("How many numbers would you like to add up?:");
        int intsInList = S.nextInt();
        while (count <= intsInList) {
            System.out.println("Please enter a number " + "(" + count + "/" + intsInList + "):");
            userIn = S.nextInt();
            sumlist.add(userIn);
            count ++;
        }
        int calculate = 0;
        for (int temp: sumlist) {
            calculate = calculate + temp;
        }
        System.out.println("Entered numbers are: " + sumlist + " and adding them all up equals to: " + calculate);
    }
}
