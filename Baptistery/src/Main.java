import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void printMenu() {
        System.out.println("1 - Buy Tickets");
        System.out.println("2 - Exit");
    }

    public static void main(String[] args) {
        ArrayList<LocalDate> dates = new ArrayList<>();

        TicketMachine machine;
        LocalDate dateToBuy;
        String dateToBuyS;
        Scanner sc = new Scanner(System.in);
        int option = -1;
        int amountTickets;
        double money;

        dates.add(LocalDate.parse("21-09-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        dates.add(LocalDate.parse("22-09-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        dates.add(LocalDate.parse("23-09-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        dates.add(LocalDate.parse("24-09-2022", DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        machine = new TicketMachine(dates);

        System.out.println("Welcome to Tickets Machine");

        do {

            printMenu();

            option = sc.nextInt();

            switch (option) {
                case 1 -> {

                    System.out.println("Enter the date you want (yyyy-mm-dd)");
                    System.out.println(machine.toString());

                    dateToBuyS = sc.next();


                    System.out.println("Insert money:");
                    money = sc.nextDouble();

                    System.out.println("How many tickets do you want to buy?");
                    amountTickets = sc.nextInt();

                    dateToBuy = LocalDate.parse(dateToBuyS, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

                    try{
                        money = machine.sellTicket(money, amountTickets, dateToBuy);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }

                    if (money == 0)
                        System.out.println("You bought " + amountTickets + " tickets.");
                }

                default -> {
                    if (option != 2)
                        System.out.println("Enter a correct number");
                }
            }
           

        } while (option != 2);

        sc.close();
    }
}
