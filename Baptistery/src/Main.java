import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void printMenu() {
        System.out.println("1 - Buy Tickets");
        System.out.println("2 - Exit");
    }

    public static void main(String[] args) throws Exception {
        TicketMachine machine = new TicketMachine();

        Scanner sc = new Scanner(System.in);
        int option = -1;
        int amountTickets;
        double money;

        System.out.println("Welcome to Tickets Machine");

        do {

            printMenu();
            try {

                option = sc.nextInt();

                switch (option) {
                    case 1 -> {

                        System.out.println("Insert money:");
                        money = sc.nextDouble();

                        System.out.println("How many tickets do you want to buy?");
                        amountTickets = sc.nextInt();

                        money = machine.sellTicket(money, amountTickets);

                        if (money == 0)
                            System.out.println("You bought " + amountTickets + " tickets.");
                        else
                            System.out.println(machine.getErrorMessage());
                    }

                    default -> {
                        if (option != 2)
                            System.out.println("Enter a correct number");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter a number");
                sc.next();
            }

        } while (option != 2);

        sc.close();
    }
}
