package hw4;

public class AskMoreInfoCommand implements Command {

    String name;
    Store store;

    public AskMoreInfoCommand(Store store) {
        this.store = store;
    }
 
    public void execute() {
        
        System.out.println("This item is very rare");
       
    }  

    public String toString() {

        return "Ask for more info in item?";

    }  

}
