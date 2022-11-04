package Shapes;


public class Circle extends Shape{
    
    private double radius;

    public Circle (double radius)
    {
        this.radius = radius;
    }

    public double calculateArea()
    {
        area = Math.PI*Math.pow(radius, 2);
        return area;
    }

    public double calculatePerimeter()
    {
        perimeter = Math.PI*radius*2;
        return perimeter;
    }
}
