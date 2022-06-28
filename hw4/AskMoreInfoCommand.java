package hw4;

public class AskMoreInfoCommand implements Command {

    String name;
    Store store;

    public AskMoreInfoCommand(Store store) {
        this.store = store;
    }
 
    public void execute() {
        
        System.out.println(store.clerk.getName()); 
       
    }  

    public String toString() {

        return "Ask for more info in item ?";

    }  

}
