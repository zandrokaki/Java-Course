import java.util.ArrayList;

public class Machine {
    private ArrayList<Product> products;

    public Machine() {
        products = new ArrayList<>();
        products.add(new Product("Plumbu", 2.0));
        products.add(new Product("Wumpa", 3));
        products.add(new Product("Plumbu", 3));
    }

    public Product sellProduct(double money, Product p) {

        Product productToBuy = null;

        try{
            if (findProduct(p) > 0 && p.getPrice() <= money) {

                for (Product pro : products) {

                    if (pro.getName().equals(p.getName())) {
                        productToBuy = new Product(pro);
                        products.remove(pro);
                        break;
                    }

                }

            } else if (p.getPrice() > money) {
                System.out.println("Not enough money.");
            } else {
                
            }
        }catch(Exception e){
            System.out.println("Run out of this product, choose another product.");
            e.printStackTrace();
        }

        return productToBuy;
    }

    // Ok
    public int findProduct(Product p) throws Exception {

        int stock = 0;

        for (Product pro : products) {
            if (pro.getName().equals(p.getName())){
                stock++;
            }
        }

        if(stock == 0)
            throw new Exception();

        return stock;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
