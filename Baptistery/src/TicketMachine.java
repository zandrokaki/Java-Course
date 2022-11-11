import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class TicketMachine {
    private static HashMap<LocalDate, Integer> datesMap;
    private int maxTickets;
    

    public TicketMachine(ArrayList<LocalDate> dates)
    {
        TicketMachine.datesMap = new HashMap<>();
        maxTickets = 10;


        for(LocalDate d : dates)
            datesMap.put(d, maxTickets);
       
    } 

    /*
     * TicketsMachine constructor 
     * 
     * @param maxTickets: set the number of tickets available per day
     */
    public TicketMachine(int maxTickets, ArrayList<LocalDate> dates)
    {
       TicketMachine.datesMap = new HashMap<>();
        this.maxTickets = maxTickets;
        
        for(LocalDate d : dates)
            datesMap.put(d, maxTickets);
    }

    public double sellTicket(double money, int amountTickets, LocalDate date) throws Exception 
    {
        int ticketsPerDay;

        if(!datesMap.keySet().contains(date)){
            //datesMap.put(date, maxTickets);
            throw new Exception("Date not available.");
        }

        ticketsPerDay = datesMap.get(date);

        if(ticketsPerDay <= 0 || amountTickets > maxTickets || ticketsPerDay-amountTickets < 0)
            throw new Exception("Not enough tickets to complete your request. Tickets remaining for that day: " + ticketsPerDay);

        if(money != 4*amountTickets)
            throw new Exception("Money not accurate");

        ticketsPerDay-=amountTickets;

        datesMap.put(date, ticketsPerDay);
        
        money-=4*amountTickets;

        return money;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
       
        datesMap.forEach(
            (key, value) -> {
                result.append(key.toString() + ", Tickets available: " + value);
                result.append("\n");
                
            });

        return result.toString();  
    }

    public HashMap<LocalDate, Integer> getDates() { return datesMap; }
}
