package hw4;

import java.util.ArrayList;

public class AskWhatStoreCommand implements Command {

    String name;
    Store store;
    Simulation simulation;

    public AskWhatStoreCommand(Simulation simulatiom) {
        this.simulation = simulatiom;
    }
 
    public void execute() {

        ArrayList<Store> stores = simulation.getStores();
        // get list of stores
        for (int i = 0; i < stores.size(); i++) {

            System.out.println("Store ID " + i + " " + stores.get(i).getLocation());

        }
        String userInput = Reader.getReader().nextLine();
        int userChoice = Integer.parseInt(userInput);
        this.store = stores.get(userChoice);
        
    } 
    public Store getStore() {
        
       return this.store;
       
    } 


    public String toString() {

        return "Select a store to issue commands to";

    }  

}
