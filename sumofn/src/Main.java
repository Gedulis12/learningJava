import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int sum;
        ArrayList<Integer> numbers = getNumbers();
        sum = getSumOfN(numbers);
        System.out.println("Entered numbers are: " + numbers + " and adding them all up equals to: " + sum);
    }
    static int getSumOfN(ArrayList<Integer> numbers) {
        int sum = 0;
        for (int number: numbers) {
            sum = sum + number;
        }
        return sum;
    }
    static ArrayList<Integer> getNumbers() {
        Scanner S = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        int userIn;
        int count = 1;
        System.out.println("How many numbers would you like to add up?:");
        int intsInList = S.nextInt();
        while (count <= intsInList) {
            System.out.println("Please enter a number " + "(" + count + "/" + intsInList + "):");
            userIn = S.nextInt();
            numbers.add(userIn);
            count ++;
        }
       return numbers;
    }
}
