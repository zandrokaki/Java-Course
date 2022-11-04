import java.util.ArrayDeque;


public class Main {
    public static void main(String[] args) throws Exception {
        ArrayDeque<Position> path = new ArrayDeque<Position>();
        Labyrinth lab = new Labyrinth();

        path = lab.findExit();
        
       
        lab.checkLabyrinthWithPath(path);
        lab.printLabyrinth();
        System.out.print(path);
    }
}
