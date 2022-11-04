package Supermarket;

public class Product {
    private String name;
    private String brand;
    private double prize;

    public Product()
    {
        name = "Unknown";
        brand = "Unknown";
        prize = 0.0;
    }

    public Product(String name, String brand, double prize)
    {
        this.name = name;
        this.brand = brand;
        this.prize = prize;
    }

    @Override
    public String toString()
    {
        return name + " " + brand + " " + prize;
    }
}
