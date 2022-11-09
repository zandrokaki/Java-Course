import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.events.MouseEvent;

public class Main {
    private static void printMenu(ArrayList<Product> products){
        System.out.println(products.toString());

        System.out.println("Insert coins ");
    }
    public static void main(String[] args) throws Exception {
        Machine machine = new Machine();
        Scanner sc = new Scanner(System.in);
        String option;
        Product pToBuy = null;
        Product myProduct = null;
        double money = 0;

        printMenu(machine.getProducts());

        money = Double.parseDouble(sc.nextLine());

        do{
           
            System.out.println("Write the name of the product you want:");
            option = sc.nextLine();
            option = option.toUpperCase();

            switch(option){
                case "PLUMBU":
                    pToBuy = new Product("Plumbu", 2.0);
                    break;

                case "WUMPA":
                    pToBuy = new Product("Wumpa", 3.0);
                    break;
      
            }

            myProduct = machine.sellProduct(money, pToBuy);
            
            if(myProduct != null){
                money -= myProduct.getPrice();
                System.out.println("Here is your " + myProduct.getName());
                System.out.println("Money: " + money);
            }

            System.out.println("Press E if you want exit or press Enter to keep buying");
            option = sc.nextLine();
            option = option.toUpperCase();

        }while(!option.equals("E") && money > 0);

        System.out.println("Have a good day!");
    }
}
