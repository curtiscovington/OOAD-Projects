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

        int minDaysToSimulate = 10;
        int maxDaysToSimulate = 30;
        int daysToSimulate = (int) ((Math.random() * (maxDaysToSimulate - minDaysToSimulate)) + minDaysToSimulate);

        Simulation sim = new Simulation(daysToSimulate);
        sim.runSimulation();
    }

    private int daysToSimulate;
    private Bank bank;
    private ArrayList<Store> stores;
    private ArrayList<Clerk> clerks = new ArrayList<Clerk>();
    private ArrayList<Trainer> trainers = new ArrayList<Trainer>();
    private CommandMenu commandMenu = new CommandMenu();
    

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


        // Ask a user what store they should run commands on
        AskWhatStoreCommand askWhatStoreCommand = new AskWhatStoreCommand(this);
        System.out.println(askWhatStoreCommand);
        askWhatStoreCommand.execute();

        // Use command pattern to create a set of commands and bind it 
        // to a particular store
        createCommandMenu(askWhatStoreCommand.getStore()); 
        for (int i = 0; i < daysToSimulate; i++) {
            runDay(i, commandMenu, askWhatStoreCommand.getStore());
        }
        printResults();
    }


    public ArrayList<Store> getStores() {
        return stores;
    }
    // Creating the command menu prompt 
    // by using the command design pattern
    // A store is passed in and binded to the each command
    private void createCommandMenu(Store store) {
        // Commands to add to the menu
        AskNameCommand askNameCommand = new AskNameCommand(store);
        commandMenu.addCommand(1,askNameCommand);

         AskMoreInfoCommand askMoreInfoCommand = new AskMoreInfoCommand(store);
         commandMenu.addCommand(2,askMoreInfoCommand);

         AskWhatTimeCommand askWhatTimeCommand = new AskWhatTimeCommand(store);
         commandMenu.addCommand(3,askWhatTimeCommand);

         AskListInventoryCommand askListInventoryCommand = new AskListInventoryCommand(store);
         commandMenu.addCommand(4,askListInventoryCommand);

         BuyItemCommand buyItemCommand = new BuyItemCommand(store);
         commandMenu.addCommand(5,buyItemCommand);

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

    public void runDay(int currentDay, CommandMenu commandMenu, Store storeToIssueCommand ) {
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
            boolean runInteractive = false;
            if (currentDay == (daysToSimulate - 1) && store.equals(storeToIssueCommand)  ){ //last day
                System.out.println("Last Day. Run Interactive");
                runInteractive = true;
            }
            store.runDay(c, t, customers, runInteractive, commandMenu );
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
