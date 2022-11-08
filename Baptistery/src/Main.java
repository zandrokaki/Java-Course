import java.util.Scanner;

public class Main {
    public static void printMenu()
    {
       
        System.out.println("1 - Buy Tickets");
        System.out.println("2 - Exit");
    }
    public static void main(String[] args) throws Exception {
        TicketMachine machine = new TicketMachine();

        Scanner sc = new Scanner(System.in);
        int option;
        double money;

        

        System.out.println("Welcome to Tickets Machine");

        do
        {
            printMenu();
            option = sc.nextInt();

            switch(option)
            {
                case 1:
                    System.out.println("How many tickets do you want to buy?");

                    money = sc.nextDouble();

                    try{
                        machine.sellTicket(money);
                    }catch(Exception e){
                        System.out.println("Error: tickets number not valid");
                    }


                    break;
            }

        }while(option != 2);

    }
}
