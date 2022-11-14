import java.time.LocalDate;
import java.util.HashMap;

public class TicketMachine {
    private static TicketMachine machine;
    private static HashMap<LocalDate, Integer> datesMap;
    private int maxTickets;
    

    private TicketMachine(){
        TicketMachine.datesMap = new HashMap<>();
        maxTickets = 10;
    }

    public Memento saveToMemento(){
        return new Memento(datesMap);
    }

    public void loadFromMemento(Memento m){
        datesMap = m.getSavedData();
    }

    /** 
     * Gets the instance of TicketMachine
     * 
     * @return TicketMachine
     */
    public static TicketMachine getInstance(){

        if(machine == null){
            machine = new TicketMachine();
        }

        return machine;
    }

    /** 
     * 
     * Sell the tickets to the customer
     * 
     * @param money : indicates money available for purchase
     * @param amountTickets : indicates the number of tickets to buy
     * @param date : indicates the date you wish to attend
     * @return double : returns 0 if the purchase was successful or all the money in the opposite case
     * @throws IllegalArgumentException : if the date is not valid
     * @throws RunOutOfTickets : if there is not enough tickets to complete the purchase or if the money is not accurate
     * @throws ArithmeticException : if the money is not accurate
     */
    public double sellTicket(double money, int amountTickets, LocalDate date) throws Exception 
    {
        int ticketsPerDay;
        LocalDate other = LocalDate.now();

        if(date.isBefore(other)){
            throw new IllegalArgumentException("Date not available: Process cancelled.");
        }

        if(!datesMap.keySet().contains(date)){
            datesMap.put(date, maxTickets);
        }
       
        ticketsPerDay = datesMap.get(date);

        if(ticketsPerDay <= 0 || amountTickets > maxTickets || ticketsPerDay-amountTickets < 0)
            throw new RunOutOfTicketsException("Not enough tickets to complete your request. Tickets remaining for that day: " + ticketsPerDay);

        if(money != 4*amountTickets)
            throw new ArithmeticException("Money not accurate: Process cancelled.");

        ticketsPerDay-=amountTickets;

        datesMap.put(date, ticketsPerDay);
        
        money-=4*amountTickets;

        return money;
    }

    
    /** 
     * ToString
     * 
     * @return String
     */
    public String toString(){
        StringBuilder result = new StringBuilder();
       
        datesMap.forEach(
            (key, value) -> {
                result.append(key.toString() + ", Tickets available: " + value);
                result.append("\n");
                
            });

        return result.toString();  
    }

    /** 
     * Gets the date's map
     * 
     * @return HashMap<LocalDate, Integer>
     */
    public HashMap<LocalDate, Integer> getDates() { 
        return datesMap;
    }
}
