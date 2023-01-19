import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sk;
        String instructions = "enter a number:";
        String action;
        Scanner S = new Scanner(System.in);
        Scanner S2 = new Scanner(System.in);
        System.out.println("Enter * for multiplication, anything else for division:");
        action = S2.nextLine();
        System.out.println(instructions);
        sk = S.nextInt();
        int answer = 0;
        for (int i = 1; i < 10; i++) { // For loop
            if (action.equals("*")) { // If
                answer = sk * i;
                if (answer < 50) {
                    System.out.println(sk + "*" + i + "=" + answer + " < 50");
                } else if (answer == 50) { // 2 lygu zenklai
                    System.out.println(sk + "*" + i + "=" + answer + " == 50");
                } else { // `else` - Visais kitais atvejais, `else if` - kitu atveju
                    System.out.println(sk + "*" + i + "=" + answer + " > 50");
                }
            } else {
                answer = sk / i;
                if (answer < 50) {
                    System.out.println(sk + "/" + i + "=" + answer + " < 50");
                } else if (answer == 50) { // 2 lygu zenklai
                    System.out.println(sk + "/" + i + "=" + answer + " == 50");
                } else { // `else` - Visais kitais atvejais, `else if` - kitu atveju
                    System.out.println(sk + "/" + i + "=" + answer + " > 50");
                }
            }
        }
    }
}