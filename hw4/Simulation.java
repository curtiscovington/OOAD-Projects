package hw4;
import java.util.ArrayList;
import java.util.Random;

public class Simulation {

    // https://stackoverflow.com/questions/9832919/generate-poisson-arrival-in-java
    private static int getPoissonRandom(double mean) {
        Random r = new Random();
        double L = Math.exp(-mean);
        int k = 0;
        double p = 1.0;
        do {
            p = p * r.nextDouble();
            k++;
        } while (p > L);
        return k - 1;
    }
    
    public static void main(String[] args) {
        Simulation sim = new Simulation(30);
        sim.runSimulation();
    }

    private int daysToSimulate;
    private Bank bank;
    private ArrayList<Store> stores;
    private ArrayList<Clerk> clerks = new ArrayList<Clerk>();
    private ArrayList<Trainer> trainers = new ArrayList<Trainer>();
    

    public Simulation(int daysToSimulate) {
        this.daysToSimulate = daysToSimulate;
        // Create a new bank
        bank = new Bank();
        stores = new ArrayList<Store>();
        stores.add(new Store("Northside"));
        stores.add(new Store("Southside"));

        clerks.add((Clerk)EmployeeFactory.create("clerk", bank));
        clerks.add((Clerk)EmployeeFactory.create("clerk", bank));
        clerks.add((Clerk)EmployeeFactory.create("clerk", bank));
        clerks.add((Clerk)EmployeeFactory.create("clerk", bank));
        trainers.add((Trainer)EmployeeFactory.create("trainer", null));
        trainers.add((Trainer)EmployeeFactory.create("trainer", null));
        trainers.add((Trainer)EmployeeFactory.create("trainer", null));
        trainers.add((Trainer)EmployeeFactory.create("trainer", null));
    }

    public void runSimulation() {
        for (int i = 0; i < daysToSimulate; i++) {
            runDay(i);
        }
        printResults();
    }

    public void printResults() {

        System.out.println("********************************************************");
        System.out.println("*                                                      *");
        System.out.println("*                                                      *");
        System.out.println("********************************************************");
        System.out.println("Amount Withdrawn from the bank: $" + bank.getAmountWithdrawn());

        for (Store store : stores) {
            System.out.println("********************************************************");;
            System.out.println("\t\t"+store.getLocation()+"\n");;
            System.out.println("Amount in cash register: $" + store.getCashRegister().getTotal());
            System.out.println("Amount in inventory: $" + store.getInventoryTotal());
            ArrayList<Item> items = store.getItems();
            if (items.size() > 0) {
                System.out.println("Items in inventory:");
                for (Item item : items) {
                    System.out.println("\t" + item.getName());
                }
            } else {
                System.out.println("No items left in inventory.");
            }
        
            System.out.println("Amount in sales: $" + store.getItemsSoldTotal());
            items = store.getItemsSold();
            if (items.size() > 0) {
                System.out.println("Items sold:");
                for (Item item : items) {
                    System.out.println("\t" + item.getName() + " : Sale Price ($" + item.getSalePrice() + ") : Sold on (" + item.getDaySold() + ")");
                }
            } else {
                System.out.println("No items sold.");
            }

            ArrayList<Pet> pets = store.getSickPets();
            if (pets.size() > 0) {
                System.out.println("Sick in the store: ");
                for (Pet pet : pets) {
                    System.out.println("\t" + pet.getName());
                }
            } else {
                System.out.println("No sick pets in the store.");
            }
        }
        
    }

    public void runDay(int currentDay) {
        for (Store store : stores) {
            Logger.getInstance().setFileName(store.getLocation(), currentDay);
            store.increaseAge();
            Clerk c = getClerkToWork();
            Trainer t = getTrainerToWork();
            c.setWorkingAt(store);
            t.setWorkingAt(store);


            
            // 2 plus a random variate from a Poisson distribution with mean 3 (this will result in random Poisson numbers from 1 to about 6 or 7 with a rare spike to 10 or so)
            // random variate from a Poisson distribution with mean 3
            int variate = getPoissonRandom(3);
            int numCustomers = 2 + variate;
            ArrayList<Customer> customers = new ArrayList<Customer>();
            for (int i = 0; i < numCustomers; i++) {
                customers.add(new Customer());
            }
            store.runDay(c, t, customers);
        }

        // let the employees take their day off

        for (Clerk e : clerks) {
            if (e.getWorkingAt() == null) {
                e.takeDayOff();
            } else {
                e.setWorkingAt(null);
            }
        }

        for (Trainer e : trainers) {
            if (e.getWorkingAt() == null) {
                e.takeDayOff();
            } else {
                e.setWorkingAt(null);
            }
        }
        
    }

    public Clerk getClerkToWork() {
        Clerk c;
        while (true) {
            // keep trying to get a trainer until they are not in need of a day off
            int index = (int) (Math.random() * clerks.size());
            if (!(c = clerks.get(index)).isInNeedOfDayOff()) {
                if (c.getWorkingAt() == null)
                    return c;
            }
        }
    }
    public Trainer getTrainerToWork() {
        Trainer t;
        while (true) {
            // keep trying to get a trainer until they are not in need of a day off
            int index = (int) (Math.random() * trainers.size());
            if (!(t = trainers.get(index)).isInNeedOfDayOff()) {
                if (t.getWorkingAt() == null)
                    return t;
            }
        }
    }
}
