package hw4;

import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

public class Tracker implements PropertyChangeListener {


    Map<Employee, Integer> clerksItemsSold = new HashMap<Employee, Integer>();
    Map<Employee, Double> clerksPurchasePrice = new HashMap<Employee, Double>();
    Map<Employee, Integer> trainersItemsSold = new HashMap<Employee, Integer>();
    Map<Employee, Double> trainersPurchasePrice = new HashMap<Employee, Double>();
    
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
            System.out.println("\t"+employee.getName() + "\t\t" + clerksItemsSold.get(employee) + "\t$" + clerksPurchasePrice.get(employee));
        }
    }

    public void printTrainerStats() {
        System.out.println("\tTrainers\tSold\tPurchase Price");
        for (Employee employee : trainersItemsSold.keySet()) {
            System.out.println("\t"+employee.getName() + "\t\t" + trainersItemsSold.get(employee) + "\t$" + trainersPurchasePrice.get(employee));
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
