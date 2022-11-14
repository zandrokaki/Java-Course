import java.time.LocalDate;
import java.util.HashMap;

public class Memento {
    private HashMap<LocalDate, Integer> datesMap;

    public Memento(HashMap<LocalDate, Integer> datesMap){
        this.datesMap = new HashMap<>();
        this.datesMap.putAll(datesMap);
    }

    public HashMap<LocalDate, Integer> getSavedData(){
        return datesMap;
    }
}
