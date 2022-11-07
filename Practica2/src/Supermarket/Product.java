package Supermarket;

public class Product {
    private String name;
    private String brand;
    private double price;

    public Product()
    {
        name = "Unknown";
        brand = "Unknown";
        price = 0.0;
    }

    public Product(String name, String brand, double price)
    {
        this.name = name;
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String toString()
    {
        return name + " " + brand + " " + price;
    }
}
