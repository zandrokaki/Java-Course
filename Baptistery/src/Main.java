import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void printMenu() {
        System.out.println("1 - Buy Tickets");
        System.out.println("2 - Cancel Ticket");
        System.out.println("3 - Exit");
    }

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        CareTaker ct = new CareTaker();
        TicketMachine machine;
        LocalDate dateToBuy = null;
        String dateToBuyS;
        Scanner sc = new Scanner(System.in);
        int option = -1;
        int amountTickets;
        double money;
        Memento m1;

        machine = TicketMachine.getInstance();

        ct.addMemento(machine.saveToMemento());

        System.out.println("Welcome to Tickets Machine");

        do {

            printMenu();

            option = sc.nextInt();

            switch (option) {
                case 1 -> {

                    System.out.println("Enter the date you want (yyyy-mm-dd)");
                    System.out.println(machine.toString());

                    dateToBuyS = sc.next();

                    try{
                        dateToBuy = LocalDate.parse(dateToBuyS, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    }catch(IllegalArgumentException e){
                        System.out.println("Date format not valid, try again");
                        break;
                    }

                    System.out.println("Insert money:");
                    money = sc.nextDouble();

                    System.out.println("How many tickets do you want to buy?");
                    amountTickets = sc.nextInt();

                    try{
                        money = machine.sellTicket(money, amountTickets, dateToBuy);
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }

                    if (money == 0){
                        System.out.println("You bought " + amountTickets + " tickets.");
                        ct.addMemento(machine.saveToMemento());
                    }

                    //m1 = ct.getMemento(0);
                    
                    //System.out.println("Datos antiguos " + m1.getSavedData().toString());
                }

                case 2 -> {
                    m1 = ct.getMemento(ct.getMementos().size()-2);
                    machine.loadFromMemento(m1);
                    //System.out.println("New Map: " + machine.getDates().toString());
                }

                default -> {
                    if (option != 3)
                        System.out.println("Enter a correct number");
                }
            }

        } while (option != 3);

        sc.close();
    }
}
