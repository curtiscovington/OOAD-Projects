package hw4;

import java.util.ArrayList;
import java.util.Scanner;

public class AskBuyItemDiscountCommand implements Command {

    String name;
    Store store;

    public AskBuyItemDiscountCommand(Store store) {
        this.store = store;
    }
 
    public void execute() {

        System.out.println("How about a 10% discount to buy item (Y/N?");
        String userInput = Reader.getReader().nextLine();
    
        if (userInput.equals("Y")) {
            System.out.println("What Item do you want to buy (enter number?");
            ArrayList<Item> items = store.getItems();
            userInput = Reader.getReader().nextLine();
            int userChoice = Integer.parseInt(userInput);
            Item item = items.get(userChoice);
            item.setSalePrice(item.getListPrice() * 0.9);   
            store.sellItem(item);
        }
        System.out.println("Okay, thanks anyway");

    }  

    public String toString() {

        return "Buy Item with discount";

    }  

}
