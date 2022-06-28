package hw4;

public class EndCommand implements Command {

    String name;
    Store store;

    public EndCommand(Store store) {
        this.store = store;
    }
 
    public void execute() {
        
        System.out.println("Ending"); 
       
    }  

    public String toString() {

        return "Hit enter to exit command prompt";

    }  

}
