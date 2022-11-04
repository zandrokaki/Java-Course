

public class Position {
    private int x;
    private int y;
    private boolean visited;
    

    public Position()
    {
        x = 0;
        y = 0;
        visited = false;
    }

    public Position (int x, int y)
    {
        this.x = x;
        this.y = y;
        visited = false;
    }

    public void setVisited(boolean visited)
    {
        this.visited = visited;
    }
    
    @Override
    public String toString()
    {
        return "[" + x + ", " + y + "]";
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public boolean isVisited() { return visited; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void set(int x, int y) { this.x = x; this.y = y; this.visited = false; }

    public boolean equals(Position other)
    {
        return other.x == this.x && other.y == this.y;
    }
}
