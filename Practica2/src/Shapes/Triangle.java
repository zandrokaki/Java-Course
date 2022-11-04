package Shapes;


public class Triangle extends Shape {
    private int base;
    private int height;

    public Triangle (int base, int height)
    {
       this.base = base;
       this.height = height;
    }

    public double calculateArea()
    {
        return (base*height)/2;
    }

    public double calculatePerimeter()
    {
        return 0;
    }
}
