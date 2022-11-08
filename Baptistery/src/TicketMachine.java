import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TicketMachine {

    private int maxTickets;
    private int ticketsSold;
    private LocalDateTime today;

    public TicketMachine()
    {
        this.maxTickets = 10;
        this.ticketsSold = 0;
        LocalDateTime now = LocalDateTime.now();  
    } 

    public TicketMachine(int maxTickets)
    {
        this.maxTickets = maxTickets;
        this.ticketsSold = 0;
        LocalDateTime now = LocalDateTime.now();  
    }

    public double sellTicket(double money)
    {
        if(!checkDate())
            ticketsSold = 0;
            
        if(money > 4 && ticketsSold < maxTickets)
        {
           money-=4;
           ++ticketsSold;
        }

        return money;
    }

    public boolean checkDate()
    {
        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
        LocalDateTime now = LocalDateTime.now();  
        //System.out.println(dtf.format(today));

        return now.equals(today);

    }

    
    
}
