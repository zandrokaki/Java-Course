package Shapes;
public class Square extends Shape {
    private int side;

    public Square (int side)
    {
        this.side = side;
    }

    public double calculateArea()
    {
        area = Math.pow(side, 2);
        return area;
    }

    public double calculatePerimeter()
    {
        perimeter = side*4;
        return perimeter;
    }
}
