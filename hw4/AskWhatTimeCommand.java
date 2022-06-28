package hw4;

public class AskWhatTimeCommand implements Command {

    String name;
    Store store;

    public AskWhatTimeCommand(Store store) {
        this.store = store;
    }
 
    public void execute() {
        
        System.out.println(System.currentTimeMillis()); 
       
    }  

    public String toString() {

        return "What time is it?";

    }  

}
