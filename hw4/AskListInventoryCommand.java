package hw4;

import java.util.ArrayList;

public class AskListInventoryCommand implements Command {

    String name;
    Store store;

    public AskListInventoryCommand(Store store) {
        this.store = store;
    }
 
    public void execute() {

        System.out.println("This item has many features");
                  
    }  

    public String toString() {

        return "List inventory of items for sale";

    }  

}
