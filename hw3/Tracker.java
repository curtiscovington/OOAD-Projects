package hw3;

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
        }
    }


    // pretty print the results
    public void printClerkStats() {
        System.out.println("Clerks\tItems Sold\tPurchase Price");
        for (Employee employee : clerksItemsSold.keySet()) {
            System.out.println(employee.getName() + "\t" + clerksItemsSold.get(employee) + "\t$" + clerksPurchasePrice.get(employee));
        }
    }

    public void printTrainerStats() {
        System.out.println("Trainers\tItems Sold\tPurchase Price");
        for (Employee employee : trainersItemsSold.keySet()) {
            System.out.println(employee.getName() + "\t" + trainersItemsSold.get(employee) + "\t$" + trainersPurchasePrice.get(employee));
        }
    }

    public void printStats() {
        printClerkStats();
        printTrainerStats();
    }
    
}
