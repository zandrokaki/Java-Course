package Shapes;


public class Rectangle extends Shape {

    private double base;
    private double height;

    public Rectangle(double base, double height)
    {
        this.base = base;
        this.height = height;
    }

    public double calculateArea()
    {
        area = base*height;
        return area;
    }

    public double calculatePerimeter()
    {
        perimeter =  base*2 + height*2;
        return perimeter;
    }
}
