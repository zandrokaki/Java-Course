package Supermarket;

import java.util.ArrayList;

public class Supermarket {
    private ArrayList<Product> inventory;

    public Supermarket()
    {
        inventory = new ArrayList<Product>();
    }

    public void addProduct(Product p)
    {
        inventory.add(p);
    }

    public Product getProduct(int index)
    {
        return inventory.get(index);
    }

    public ArrayList<Product> getInventory() { return inventory; }
    
}
