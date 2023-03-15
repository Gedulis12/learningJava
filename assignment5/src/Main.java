import com.assignment.base.ClientImpl;
import com.assignment.inherited.heating.HeatingClientImpl;
import com.assignment.inherited.internet.InternetClientImpl;
import com.assignment.inherited.phone.PhoneClientImpl;

public class Main {
    public static void main(String[] args) {

        // create 9 clients
        ClientImpl c1 = new ClientImpl("Peter", "Sherman", "Wallaby st. 42, Sydney", 200);
        ClientImpl c2 = new ClientImpl("Jammie", "McGill", "Freedom st. 69, ABQ New Mexico", 15);
        ClientImpl c3 = new ClientImpl("William", "Jones", "789 Oak St", 50.7);
        ClientImpl c4 = new ClientImpl("Oliver", "Brown", "654 Maple St", 12.3);
        ClientImpl c5 = new ClientImpl("Logan", "Wilson", "789 Oak St", 17);
        ClientImpl c6 = new ClientImpl("Harry", "Taylor", "456 Elm St", 117);
        ClientImpl c7 = new ClientImpl("Mason", "Moore", "246 Birch St", 30);
        ClientImpl c8 = new ClientImpl("George", "Clark", "123 Main St", 99.99);
        ClientImpl c9 = new ClientImpl("Jack", "Wilson", "987 Cedar St", 0);

        // create 3 clients for each inherited class using previously created objects
        // heating clients
        HeatingClientImpl h1 = new HeatingClientImpl(c1, 100);
        HeatingClientImpl h2 = new HeatingClientImpl(c2, 7);
        HeatingClientImpl h3 = new HeatingClientImpl(c3, 25);

        // internet clients
        InternetClientImpl i1 = new InternetClientImpl(c4, "78.10.50.255");
        InternetClientImpl i2 = new InternetClientImpl(c5, "78.10.50.69");
        InternetClientImpl i3 = new InternetClientImpl(c6, "14.9.0.256");

        // phone clients
        PhoneClientImpl p1 = new PhoneClientImpl(c7, "+37065498732");
        PhoneClientImpl p2 = new PhoneClientImpl(c8, "864892367");
        PhoneClientImpl p3 = new PhoneClientImpl(c9, "86712563");

        // put all clients to a list
        ClientImpl[] clients = {h1, h2, h3, i1, i2, i3, p1, p2, p3};

        // print total amount of unpaid bills for internet and phone clients
        System.out.println("________________________________________");
        printTotalAmountForPhoneAndInternet(clients);
        System.out.println("________________________________________");

        // swap min and max unpaid amounts for heating services clients
        System.out.println("________________________________________");
        System.out.println("\nheating clients before swapping min and max amounts: ");
        System.out.println(h1.toString() + "\n" + h2.toString() + "\n" + h3.toString());
        swapMinMaxHeatingBills(clients);
        System.out.println("\nheating clients after swapping min and max amounts: ");
        System.out.println(h1.toString() + "\n" + h2.toString() + "\n" + h3.toString());
        System.out.println("________________________________________");

        // change unpaid amount to 69 for internet clients that has an ip ending with 69
        System.out.println("________________________________________");
        System.out.println("\ninternet clients before changes: ");
        System.out.println(i1.toString() + "\n" + i2.toString() + "\n" + i3.toString());
        setAmountToLastIpDigits(clients, "69");
        System.out.println("\ninternet clients after changes: ");
        System.out.println(i1.toString() + "\n" + i2.toString() + "\n" + i3.toString());
        System.out.println("________________________________________");

        // print all clients just to see if everything looks right:
        System.out.println("________________________________________");
        printAllClients(clients);
        System.out.println("________________________________________");
    }

    /**
     * Prints all client objects using their toString method
     * @param clients, type ClientImpl[] - array of objects that we want to traverse
     */
    static void printAllClients(ClientImpl[] clients) {
        for (ClientImpl client : clients) {
            System.out.println(client);
        }
    }
    /**
     * Prints total amounts of outstanding bills for phone and internet services
     * @param clients, type ClientImpl[] - array of objects that we want to traverse
     */
    static void printTotalAmountForPhoneAndInternet(ClientImpl[] clients) {
        double totalPhone = 0;
        double totalInternet = 0;
        for (ClientImpl client : clients) {
            if (client instanceof PhoneClientImpl) {
                PhoneClientImpl phoneClient = (PhoneClientImpl) client;
                System.out.println("phone services client with id " + phoneClient.getClientCode() + " has unpaid amount of: " + phoneClient.getAmount());
                totalPhone += phoneClient.getAmount();
            } else if (client instanceof InternetClientImpl) {
                InternetClientImpl internetClient = (InternetClientImpl) client;
                System.out.println("internet services client with id " + internetClient.getClientCode() + " has unpaid amount of: " + internetClient.getAmount());
                totalInternet += internetClient.getAmount();
            }
        }
        System.out.println("Total unpaid phone bills: " + (double) totalPhone);
        System.out.println("Total unpaid internet bills: " + (double) totalInternet);
    }

    /**
     * Finds highest and lowest amounts on heating services clients and swaps the amounts between objects.
     * @param clients, type ClientImpl[] - array of objects that we want to traverse
     */
    static void swapMinMaxHeatingBills(ClientImpl[] clients) {
        double maxAmount = 0;
        double minAmount = 0;
        ClientImpl maxAmountClient = clients[0];
        ClientImpl minAmountClient = clients[0];

        // find first heating client and put its values to a variables
        for (ClientImpl client : clients) {
            if (client instanceof HeatingClientImpl) {
                HeatingClientImpl heatingClient = (HeatingClientImpl) client;
                minAmount = heatingClient.getAmount();
                maxAmount = heatingClient.getAmount();
                maxAmountClient = heatingClient;
                minAmountClient = heatingClient;
                break;
            }
        }
        // find min and max amounts for clients
        for (ClientImpl client : clients) {
            if (client instanceof HeatingClientImpl) {
                HeatingClientImpl heatingClient = (HeatingClientImpl) client;
                if (client.getAmount() > maxAmount) {
                    maxAmount = heatingClient.getAmount();
                    maxAmountClient = heatingClient;
                }
                if (client.getAmount() < minAmount) {
                    minAmount = heatingClient.getAmount();
                    minAmountClient = heatingClient;
                }
            }
        }
        // swap min and max amounts for clients
        maxAmountClient.setAmount(minAmount);
        minAmountClient.setAmount(maxAmount);
    }

    /**
     * Checks the lastDigits parameter with last digits of IP for internet services clients and if matches, sets those digits as clients outstanding amount.
     * @param clients, type ClientImpl[] - array of objects that we want to traverse
     * @param lastDigits, type string - last ip numbers that we want to check
     */
    static void setAmountToLastIpDigits(ClientImpl[] clients, String lastDigits) {
        String ip = null;
        String lastChars = null;
        int num = Integer.parseInt(lastDigits);
        for (ClientImpl client : clients) {
            if (client instanceof InternetClientImpl) {
                InternetClientImpl internetClient = (InternetClientImpl) client;
                ip = internetClient.getIp();
                lastChars = ip.substring(ip.length() - lastDigits.length());
                if (lastChars.equals(lastDigits)) {
                    internetClient.setAmount(num);
                }
            }
        }
    }
}