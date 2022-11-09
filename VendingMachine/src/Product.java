public class Product {
    private String name;
    private double price;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public Product(Product p){
        this.name = p.name;
        this.price = p.price;
    }

    @Override
    public String toString(){
        return "[" + name + ", " + price + "]";
    }

    public double getPrice() { return price; }
    public String getName() { return name; }
}
