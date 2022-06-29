package hw4;

import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

// lazy initialization
public class Tracker implements PropertyChangeListener {

    private static Tracker instance = null;

    Map<Employee, Integer> clerksItemsSold = new HashMap<Employee, Integer>();
    Map<Employee, Double> clerksPurchasePrice = new HashMap<Employee, Double>();
    Map<Employee, Integer> trainersItemsSold = new HashMap<Employee, Integer>();
    Map<Employee, Double> trainersPurchasePrice = new HashMap<Employee, Double>();
    
    private Tracker() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    @Override
    public void propertyChange(java.beans.PropertyChangeEvent evt) {
        ItemSoldEvent event = (ItemSoldEvent) evt.getNewValue();
        Employee employee = event.getEmployee();

        if (employee instanceof Clerk) {
            if (clerksItemsSold.containsKey(employee)) {
                clerksItemsSold.put(employee, clerksItemsSold.get(employee) + 1);
            } else {
                clerksItemsSold.put(employee, 1);
            }

            if (clerksPurchasePrice.containsKey(employee)) {
                clerksPurchasePrice.put(employee, clerksPurchasePrice.get(employee) + event.getItem().getPurchasePrice());
            } else {
                clerksPurchasePrice.put(employee, event.getItem().getPurchasePrice());
            }
        } else {
            if (trainersItemsSold.containsKey(employee)) {
                trainersItemsSold.put(employee, trainersItemsSold.get(employee) + 1);
            } else {
                trainersItemsSold.put(employee, 1);
            }

            if (trainersPurchasePrice.containsKey(employee)) {
                trainersPurchasePrice.put(employee, trainersPurchasePrice.get(employee) + event.getItem().getPurchasePrice());
            } else {
                trainersPurchasePrice.put(employee, event.getItem().getPurchasePrice());
            }
        }
    }


    // pretty print the results
    public void printClerkStats() {
        System.out.println("\tClerks\t\tSold\tPurchase Price");
        for (Employee employee : clerksItemsSold.keySet()) {
            // format money into $###.##

            System.out.println("\t"+employee.getName() + "\t" + clerksItemsSold.get(employee) + "\t$" + String.format("%.2f", clerksPurchasePrice.get(employee)));
        }
    }

    public void printTrainerStats() {
        System.out.println("\tTrainers\tSold\tPurchase Price");
        for (Employee employee : trainersItemsSold.keySet()) {
            // format money into $###.##
            System.out.println("\t"+employee.getName() + "\t" + trainersItemsSold.get(employee) + "\t$" + String.format("%.2f", trainersPurchasePrice.get(employee)));
        }
    }

    public void printStats() {
        System.out.println();
        System.out.println("********************************************************");
        System.out.println("*                                                      *");
        System.out.println("*                                                      *");
        printClerkStats();
        System.out.println();
        printTrainerStats();
        System.out.println("*                                                      *");
        System.out.println("*                                                      *");
        System.out.println("********************************************************");
        System.out.println();
    }
    
}
