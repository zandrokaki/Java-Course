
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Labyrinth {
    private char[][] labyrinth;
    private int files, cols;
    private ArrayDeque<Position> path;
    private Position currentPosition, finalPosition;

    public Labyrinth()
    {
        try{
            File myObj = new File("C:\\Users\\ssanch15\\Desktop\\Java-Course\\Labyrinth\\lab5.txt");
            Scanner myReader = new Scanner(myObj);
            path = new ArrayDeque<Position>();
            currentPosition = new Position();
            finalPosition = new Position();
            labyrinth = new char[20][80];
            files = 0;

            while (myReader.hasNextLine()) {
                
                String data = myReader.nextLine();
                cols = data.length();

                for(int i = 0; i<data.length(); ++i)
                {
                    labyrinth[files][i] = data.charAt(i);

                    if(data.charAt(i) == 'E')
                    {
                        currentPosition.set(files, i);
                    }

                    if(data.charAt(i) == 'S')
                        finalPosition.set(files, i);     
                }
                
                ++files;
            }

            myReader.close();
        
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }

    public void move(Position p)
    {
        int pX = p.getX();
        int pY = p.getY();

        labyrinth[pX][pY] = '.';
        p.setVisited(true);
        currentPosition.set(pX, pY);
    }

    public boolean checkValidPosition(Position p)
    {
        return labyrinth[p.getX()][p.getY()] == ' ' || labyrinth[p.getX()][p.getY()] == 'S';
    }

    public ArrayDeque<Position> findExit() {

        while (currentPosition.getY() != finalPosition.getY() || currentPosition.getX() != finalPosition.getX())
        {
            Position moveTo = new Position(currentPosition.getX(), currentPosition.getY());
            Position downSide = new Position(currentPosition.getX() + 1, currentPosition.getY());
            Position leftSide = new Position(currentPosition.getX(), currentPosition.getY() - 1);
            Position upSide = new Position(currentPosition.getX() - 1, currentPosition.getY());
            Position rightSide = new Position(currentPosition.getX(), currentPosition.getY() + 1);

            if (checkValidPosition(downSide) && !downSide.isVisited()) // Down
            {
                moveTo = downSide;
                path.push(downSide);

            } else if (checkValidPosition(leftSide) && !leftSide.isVisited()) // Left
            {
                moveTo = leftSide;
                path.push(leftSide);
            } else if (checkValidPosition(upSide) && !upSide.isVisited()) { // Up

                moveTo = upSide;
                path.push(upSide);
            } else if (checkValidPosition(rightSide) && !rightSide.isVisited()) // Right
            {
                moveTo = rightSide;
                path.push(rightSide);

            } else {
                path.pop();
                moveTo = path.peek();
            }

            move(moveTo);
        }

        return path;
    }

    public void printLabyrinth()
    {
        for(int i = 0; i<files; ++i)
        {
            for(int j = 0; j<cols; ++j)
            {
                System.out.print(labyrinth[i][j]);
            }
    
            System.out.print("\n");
        }

        System.out.println("\n");
    }

    public void checkLabyrinthWithPath(ArrayDeque<Position> path)
    {
        for(Position p : path){
            labyrinth[p.getX()][p.getY()] = '-';
        }
    }

    public Position getCurrentPosition() { return currentPosition; }
    public Position getFinalPosition() { return finalPosition; }






    

}
