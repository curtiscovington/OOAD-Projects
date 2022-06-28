package hw4;

public class AskNameCommand implements Command {

    String name;
    Store store;

    public AskNameCommand(Store store) {
        this.store = store;
    }
 
    public void execute() {
        
        System.out.println(store.clerk.getName()); 
       
    }  

    public String toString() {

        return "What is your name?";

    }  

}
