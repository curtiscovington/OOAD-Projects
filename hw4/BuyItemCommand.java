package hw4;

import java.util.ArrayList;

public class BuyItemCommand implements Command {

    String name;
    Store store;

    public BuyItemCommand(Store store) {
        this.store = store;
    }
 
    public void execute() {

        ArrayList<Item> items = store.getItems();
        System.out.println("What Item do you want to buy (enter number?");
        String userInput = Reader.getUserInputString();
        int userChoice = Integer.parseInt(userInput);   
        Item item = items.get(userChoice);
        item.setSalePrice(item.getListPrice());   
        store.sellItem(item);
    }  

    public String toString() {

        return "Buy Item";

    }  

}
