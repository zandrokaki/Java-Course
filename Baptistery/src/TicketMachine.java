import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TicketMachine {

    private int maxTickets;
    private int ticketsSold;
    private LocalDateTime today;
    private String errorMessage;

    public TicketMachine()
    {
        this.maxTickets = 10;
        this.ticketsSold = 0;
        this.today = LocalDateTime.now();  
        this.errorMessage = "";
    } 

    public TicketMachine(int maxTickets)
    {
        this.maxTickets = maxTickets;
        this.ticketsSold = 0;
        this.today = LocalDateTime.now();
        this.errorMessage = ""; 
    }

    public double sellTicket(double money, int amountTickets)
    {
        
        if(isDifferentDay()){
            ticketsSold = 0;
            today = LocalDateTime.now();
        }

        if(amountTickets > maxTickets-ticketsSold ){
            errorMessage = "Run out of tickets.";
            return money;
        }
           
            
        if(money == 4*amountTickets)
        {
           ticketsSold+=amountTickets;
           return 0;
        }

        errorMessage= "Money not accurate.";
        return money;
    }



    public boolean isDifferentDay()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        LocalDateTime now = LocalDateTime.now();  

        return !(dtf.format(now).equals(dtf.format(today)));
    }

    public String getErrorMessage(){
        return errorMessage;
    }
    
    
}
