package hw4;

import java.util.ArrayList;

public class AskListInventoryCommand implements Command {

    String name;
    Store store;

    public AskListInventoryCommand(Store store) {
        this.store = store;
    }
 
    public void execute() {

        ArrayList<Item> items = store.getItems();
        if (items.size() > 0) {
            System.out.println("Items in inventory:");
            for (int i = 0; i < items.size(); i++) {

                System.out.println("Item ID " + i + " " + items.get(i).getName());
            }
            
        } else {
            System.out.println("No items left in inventory.");
        }
       
                  
    }  

    public String toString() {

        return "List inventory of items for sale";

    }  

}
