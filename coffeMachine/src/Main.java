import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int priceLatte = 3;
        double priceBlack = 1.5;
        int priceWhite = 2;
        double priceTea = 1.2;
        double moneyIn;
        String selection;
        Scanner P = new Scanner(System.in); // scanner for product
        Scanner M = new Scanner(System.in); //scanner for money
        Scanner A = new Scanner(System.in); // scanner for tryagain
        Scanner T = new Scanner(System.in); // scanner for tea
        String again = "y";
        while (again.equals("y")) {
            System.out.println("Hello, this is a coffee machine, please select a product from the list");
            System.out.println("1. latte (3 eur)");
            System.out.println("2. black coffee (1.5 eur)");
            System.out.println("3. white coffee (2 eur)");
            System.out.println("4. tea (1.2 eur)");
            selection = P.nextLine();
            if (selection.equals("1") | selection.equals("2") | selection.equals("3") | selection.equals("4")) {
                if (selection.equals("1")) {
                    System.out.println("price of latte is " + priceLatte + " eur, please enter the money");
                    moneyIn = M.nextDouble();
                    while (true) {
                        if (moneyIn < priceLatte) {
                            System.out.println("entered amount does not cover the price of selected product, please enter the right amount:`");
                            moneyIn = M.nextDouble();
                        } else if (moneyIn > priceLatte) {
                            System.out.println("Thank you for purchasing latte, your change is " + (moneyIn - priceLatte) + " eur.");
                            break;
                        } else if (moneyIn == priceLatte) {
                            System.out.println("Thank you for purchasing latte");
                            break;
                        }
                    }
                } else if (selection.equals("2")) {
                    System.out.println("price of black coffee is " + priceBlack + " eur, please enter the money");
                    moneyIn = M.nextDouble();
                    while (true) {
                        if (moneyIn < priceBlack) {
                            System.out.println("entered amount does not cover the price of selected product, please enter the right amount:`");
                            moneyIn = M.nextDouble();
                        } else if (moneyIn > priceBlack) {
                            System.out.println("Thank you for purchasing black coffee, your change is " + (moneyIn - priceBlack) + " eur.");
                            break;
                        } else if (moneyIn == priceBlack) {
                            System.out.println("Thank you for purchasing black coffee");
                            break;
                        }
                    }
                } else if (selection.equals("3")) {
                    System.out.println("price of white coffee is " + priceWhite + " eur, please enter the money");
                    moneyIn = M.nextDouble();
                    while (true) {
                        if (moneyIn < priceWhite) {
                            System.out.println("entered amount does not cover the price of selected product, please enter the right amount:`");
                            moneyIn = M.nextDouble();
                        } else if (moneyIn > priceWhite) {
                            System.out.println("Thank you for purchasing white coffee, your change is " + (moneyIn - priceWhite) + " eur.");
                            break;
                        } else if (moneyIn == priceWhite) {
                            System.out.println("Thank you for purchasing white coffee");
                            break;
                        }
                    }
                } else if (selection.equals("4")) {
                    System.out.println("Please select the type of tea:");
                    System.out.println("1. Green tea");
                    System.out.println("2. Black tea");
                    System.out.println("3. Fruit tea");
                    int tea = T.nextInt();
                    if (tea != 1 && tea != 2 && tea != 3) {
                        System.out.println("Invalid selection, please try again.");
                        continue;
                    } else {
                        System.out.println("price of tea is " + priceTea + " eur, please enter the money");
                        moneyIn = M.nextDouble();
                        while (true) {
                            if (moneyIn < priceTea) {
                                System.out.println("entered amount does not cover the price of selected product, please enter the right amount:`");
                                moneyIn = M.nextDouble();
                            } else if (moneyIn > priceTea) {
                                System.out.println("Thank you for purchasing tea, your change is " + (moneyIn - priceTea) + " eur.");
                                break;
                            } else if (moneyIn == priceTea) {
                                System.out.println("Thank you for purchasing tea");
                                break;
                            }
                        }
                    }
                } else {
                    System.out.println("Invalid selection, please try again.");
                    continue;
                }
            }
            System.out.println("Would you like to use the machine again? (enter y for yes, anything else for no):");
            again = A.nextLine();
        }
        System.out.println("Thank you for using our coffee machine, have a nice day!");
    }
}