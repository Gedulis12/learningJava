import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        System.out.println("Please enter a number:");
        int sk = S.nextInt();
        int answer = 0;
        int i = 0;
        while (answer < 100) {
            answer = sk * i;
            if (answer < 100) {
                System.out.println(sk + " x " + i + " = " + answer);
            }
            i ++;
        }
    }
}