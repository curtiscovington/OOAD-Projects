package hw4;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.HashMap;

public class Store {
    CashRegister cashRegister = new CashRegister();
    ArrayList<Item> items = new ArrayList<Item>();
    ArrayList<Item> itemsSold = new ArrayList<Item>();
    ArrayList<Pet> sickPets = new ArrayList<Pet>();

    Trainer trainer;
    Clerk clerk;

    ArrayList<Order> orders = new ArrayList<Order>();

    Logger logger;
    Tracker tracker;

    Reader reader = new Reader();

    // observable pattern for employee actions
    PropertyChangeSupport employeeActionsObservable;

    int age = 0;

    public CashRegister getCashRegister() {
        return cashRegister;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Item> getItemsSold() {
        return itemsSold;
    }

    public double getInventoryTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPurchasePrice();
        }
        return total;
    }

    public double getItemsSoldTotal() {
        double total = 0;
        for (Item item : itemsSold) {
            total += item.getSalePrice();
        }
        return total;
    }

    public ArrayList<Pet> getSickPets() {
        return sickPets;
    }

    // Constructor
    public Store() {
        employeeActionsObservable = new PropertyChangeSupport(this);
        tracker = new Tracker();
        employeeActionsObservable.addPropertyChangeListener("itemSold", tracker);
        // three instances of each lowest subclass
        for (int i = 0; i < 3; i++) {
            addItem(Food.newRandomItem(0));
            addItem(Toy.newRandomItem(0));
            addItem(CatLitter.newRandomItem(0));
            addItem(Leash.newRandomItem(0));
            addItem(Cat.newRandomItem(0));
            addItem(Dog.newRandomItem(0));
            addItem(Bird.newRandomItem(0));
            addItem(Ferret.newRandomItem(0));
            addItem(Snake.newRandomItem(0));
            addItem(Treat.newRandomItem(0));
        }
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void arriveAtStore(Person p) {
        // if the person is an employee
        if (p instanceof Employee) {
            employeeActionsObservable.firePropertyChange("arriveAtStore", null, new ArriveAtStoreEvent((Employee) p ));
            ((Employee) p).arriveAtStore();
            String name = ((Employee) p).getName();
            String employeeType;
            if (p instanceof Clerk) {
                
                employeeType = "Clerk";
                clerk = (Clerk) p;
            } else {
                employeeType = "Trainer";
                trainer = (Trainer) p;
            }
            System.out.println("Employee " + name + " the " + employeeType + " has arrived at the store.");
        } else {
            System.out.println("A customer has arrived at the store.");
        }
    }

    public void leaveStore(Person p) {
        // if the person is an employee
        if (p instanceof Employee) {
            employeeActionsObservable.firePropertyChange("leaveStore", null, new LeaveStoreEvent((Employee) p ));
            String name = ((Employee) p).getName();
            String employeeType;
            if (p instanceof Clerk) {
                employeeType = "Clerk";
                clerk = null;
            } else {
                employeeType = "Trainer";
                trainer = null;
            }
            System.out.println("Employee " + name + " the " + employeeType + " has left the store for the day.");
        } else {
            System.out.println("A customer has left the store.");
        }
    }

    public void runDay(Clerk clerk, Trainer trainer, ArrayList<Customer> customers, boolean runInteractive, CommandMenu commandMenu) {
        arriveAtStore(clerk);
        arriveAtStore(trainer);

        clerkTasks();
        trainerTasks();
        
        if (runInteractive) {
            openStoreInteractive(customers, commandMenu);
        }
        else {
            openStore(customers);
        }
        cleanStore();
        closeStore();

        System.out.println("Tracker Day " + age);
        tracker.printStats();
    }

    public void closeStore() {
        System.out.println("Clerk " + clerk.getName() + " has locked the store.");
        leaveStore(clerk);
        leaveStore(trainer);
    }

    public void clerkTasks() {
        int itemsAdded = processDeliveries();
        employeeActionsObservable.firePropertyChange("processDeliveries", null, new ProcessDeliveriesEvent(clerk, itemsAdded));

        // check the register
        double amount = clerk.checkRegister(cashRegister);
        employeeActionsObservable.firePropertyChange("checkRegister", null, new CheckRegisterEvent(clerk, amount));

        System.out.println(
                "Clerk " + clerk.getName() + " has checked the register and found that the total is $" + amount);

        if (amount < 200) {
            // the clerk needs to go to the bank
            amount = clerk.goToBank(1000);
            System.out.println("Clerk " + clerk.getName() + " has gone to the bank and withdrew $" + amount);
            cashRegister.deposit(amount);
            
            employeeActionsObservable.firePropertyChange("goToBank", null, new GoToBankEvent(clerk, cashRegister.getTotal()));
        }

        HashMap<String, Number> inventory = clerk.doInventory(items);

        employeeActionsObservable.firePropertyChange("doInventory", null, new DoInventoryEvent(clerk, (int)inventory.get("pets"), (int)inventory.get("supplies"), (double)inventory.get("total")));
        
        System.out.println(
                "Clerk " + clerk.getName() + " has found the total of items in store are $" + inventory.get("total"));
        int itemsOrdered = 0;
        for (String key : inventory.keySet()) {
            if (key != "total" && inventory.get(key).intValue() == 0) {
                System.out.println("\t" + key);
                // random purchase price between 10 and 100
                double purchasePrice = (int) (Math.random() * (100 - 10)) + 10;
                cashRegister.withdraw(purchasePrice * 3);

                switch (key) {
                    case "dogs":
                        System.out.println("Clerk " + clerk.getName()
                                + " has found that there are no more " + key + " in store and has ordered 3 more for $"
                                + purchasePrice * 3);
                        orders.add(clerk.placeOrder(Dog.newRandomItem(-1)));
                        orders.add(clerk.placeOrder(Dog.newRandomItem(-1)));
                        orders.add(clerk.placeOrder(Dog.newRandomItem(-1)));
                        itemsOrdered += 3;
                        break;
                    case "cats":
                        System.out.println("Clerk " + clerk.getName()
                                + " has found that there are no more " + key + " in store and has ordered 3 more for $"
                                + purchasePrice * 3);
                        orders.add(clerk.placeOrder(Cat.newRandomItem(-1)));
                        orders.add(clerk.placeOrder(Cat.newRandomItem(-1)));
                        orders.add(clerk.placeOrder(Cat.newRandomItem(-1)));
                        itemsOrdered += 3;
                        break;
                    case "birds":
                        System.out.println("Clerk " + clerk.getName()
                                + " has found that there are no more " + key + " in store and has ordered 3 more for $"
                                + purchasePrice * 3);
                        orders.add(clerk.placeOrder(Bird.newRandomItem(-1)));
                        orders.add(clerk.placeOrder(Bird.newRandomItem(-1)));
                        orders.add(clerk.placeOrder(Bird.newRandomItem(-1)));
                        itemsOrdered += 3;
                        break;
                    case "snakes":
                        System.out.println("Clerk " + clerk.getName()
                                + " has found that there are no more " + key + " in store and has ordered 3 more for $"
                                + purchasePrice * 3);
                        orders.add(clerk.placeOrder(Snake.newRandomItem(-1)));
                        orders.add(clerk.placeOrder(Snake.newRandomItem(-1)));
                        orders.add(clerk.placeOrder(Snake.newRandomItem(-1)));
                        itemsOrdered += 3;
                        break;
                    case "ferrets":
                        System.out.println("Clerk " + clerk.getName()
                                + " has found that there are no more " + key + " in store and has ordered 3 more for $"
                                + purchasePrice * 3);
                        orders.add(clerk.placeOrder(Ferret.newRandomItem(-1)));
                        orders.add(clerk.placeOrder(Ferret.newRandomItem(-1)));
                        orders.add(clerk.placeOrder(Ferret.newRandomItem(-1)));
                        itemsOrdered += 3;
                        break;
                    case "treats":
                        System.out.println("Clerk " + clerk.getName()
                                + " has found that there are no more " + key + " in store and has ordered 3 more for $"
                                + purchasePrice * 3);
                        orders.add(clerk.placeOrder(Treat.newRandomItem(-1)));
                        orders.add(clerk.placeOrder(Treat.newRandomItem(-1)));
                        orders.add(clerk.placeOrder(Treat.newRandomItem(-1)));
                        itemsOrdered += 3;
                        break;
                    case "food":
                        System.out.println("Clerk " + clerk.getName()
                                + " has found that there are no more " + key + " in store and has ordered 3 more for $"
                                + purchasePrice * 3);
                        orders.add(clerk.placeOrder(Food.newRandomItem(-1)));
                        orders.add(clerk.placeOrder(Food.newRandomItem(-1)));
                        orders.add(clerk.placeOrder(Food.newRandomItem(-1)));
                        itemsOrdered += 3;
                        break;
                    case "toys":
                        // orders.add(clerk.placeOrder(Toy.newRandomItem(-1)));
                        // orders.add(clerk.placeOrder(Toy.newRandomItem(-1)));
                        // orders.add(clerk.placeOrder(Toy.newRandomItem(-1)));
                        break;
                    case "leashes":
                        System.out.println("Clerk " + clerk.getName()
                                + " has found that there are no more " + key + " in store and has ordered 3 more for $"
                                + purchasePrice * 3);
                        orders.add(clerk.placeOrder(Leash.newRandomItem(-1)));
                        orders.add(clerk.placeOrder(Leash.newRandomItem(-1)));
                        orders.add(clerk.placeOrder(Leash.newRandomItem(-1)));
                        itemsOrdered += 3;
                        break;
                    case "cat litter":
                        System.out.println("Clerk " + clerk.getName()
                                + " has found that there are no more " + key + " in store and has ordered 3 more for $"
                                + purchasePrice * 3);
                        orders.add(clerk.placeOrder(CatLitter.newRandomItem(-1)));
                        orders.add(clerk.placeOrder(CatLitter.newRandomItem(-1)));
                        orders.add(clerk.placeOrder(CatLitter.newRandomItem(-1)));
                        itemsOrdered += 3;
                        break;
                }
            }
        }

        if (itemsOrdered > 0) {
            employeeActionsObservable.firePropertyChange("placeAnOrder", null, new PlaceAnOrderEvent(clerk, itemsOrdered));
        }

    }

    public void trainerTasks() {
        feedAnimals();
        trainAnimals();
    }

    public void increaseAge() {
        age++;
        employeeActionsObservable.removePropertyChangeListener(logger);
        logger = new Logger(age);
        employeeActionsObservable.addPropertyChangeListener(logger);
    }

    public void openStore(ArrayList<Customer> customers) {
        System.out.println("Clerk " + clerk.getName() + " has opened the store.");

        for (Customer p : customers) {
            arriveAtStore(p);
            // browse items in store
            for (Item item : items) {
                boolean wants = p.examineItem(item);
                boolean bought = false;
                // 50% chance of buying item if customer wants it otherwise 10% chance of buying
                // item
                if (wants) {
                    if (Math.random() < 0.5) {
                        bought = true;
                        item.setSalePrice(item.getListPrice());
                    }
                } else {
                    if (Math.random() < 0.1) {
                        bought = true;
                        item.setSalePrice(item.getListPrice());
                    }
                }

                if (!bought) {
                    // trainer will offer 10% discount
                    System.out.println(
                            ("Trainer " + trainer.getName() + " has offered a 10% discount on " + item.getName()));
                    // 75 % chance of buying item
                    if (Math.random() < 0.75) {
                        bought = true;
                        item.setSalePrice(item.getListPrice() * 0.9);
                    }
                }

                if (bought) {
                    item = addOnItems(item);
                    sellItem(item);
                    break;
                }
            }
            leaveStore(p);
        }
    }

    public void openStoreInteractive(ArrayList<Customer> customers, CommandMenu commandMenu) {
        System.out.println("Clerk " + clerk.getName() + " has opened the store.");

        // Ask the employee their name (
        // Ask the clerk what time it is 
        // Ask the trainer for current store inventory 
        // Ask the trainer for information on a user selected inventory item
        // Buy a normal inventory item from the clerk
        // Offer discount if not buying anything
        System.out.println("********* Command Menu *************");
        boolean bought = false;
        while (true) {

            commandMenu.getAllCommands(); 
            System.out.println("Press Enter to Exit this menu");
            String userInput = Reader.getReader().nextLine();

            // End command index is 6. 
            if ("".equalsIgnoreCase(userInput)){ 
                if (!(bought)) {
                    AskBuyItemDiscountCommand askBuyItemDiscountCommand = new AskBuyItemDiscountCommand(this);
                    askBuyItemDiscountCommand.execute();
                }
              break;
            }else{
                int userChoice = Integer.parseInt(userInput);
                // if user buys item set
                if (userChoice == 5) {
                    bought = true;
                }
                commandMenu.executeCommand(userChoice);
            }
        } 

    }

    public void cleanStore() {
        // trainer will clean the cages
        for (Item item : items) {
            if (item instanceof Pet) {
                System.out.println("Trainer " + trainer.getName() + " is cleaning the cage for " + item.getName());
                // 5% chance of the pet will escape
                if (Math.random() < 0.05) {
                    // publish animal escaped event
                    employeeActionsObservable.firePropertyChange("animalEscaped", null, new AnimalEscapeEvent(trainer, (Pet)item));
                    System.out.println("While cleaning, " + item.getName() + " has escaped!");
                    catchAnimal();
                }
            }
        }

        for (Pet pet : sickPets) {
            System.out.println("Trainer " + trainer.getName() + " is cleaning the cage for " + pet.getName());
            // 5% chance of the pet will escape
            if (Math.random() < 0.05) {
                // publish animal escaped event
                employeeActionsObservable.firePropertyChange("animalEscaped", null, new AnimalEscapeEvent(trainer, pet));
                System.out.println("While cleaning, " + pet.getName() + " has escaped!");
                catchAnimal();
            }
        }

        // the clerk will vacuum the store
        System.out.println("Clerk " + clerk.getName() + " is vacuuming the store.");
    }

    public void catchAnimal() {
        // 50% chance the trainer will catch the animal
        if (Math.random() < 0.5) {
            System.out.println("Trainer " + trainer.getName() + " has caught the animal!");
        } else {
            System.out.println("Clerk " + clerk.getName() + " has caught the animal!");
        }
    }

    public void feedAnimals() {
        ArrayList<Pet> pets = new ArrayList<Pet>();
        System.out.println(trainer.getName() + " is feeding the animals.");
        // feed the sick pets
        for (Pet p : sickPets) {
            // 25% chance to change heathy to true
            if (Math.random() < 0.25) {
                System.out.println("The sick pet " + p.getName() + " has fully recovered.");
                p.setHealthy(true);
                // remove the pet from the sick list
                pets.add(p);
            }
        }

        // remove the sick pets from the sick list
        for (Pet p : pets) {
            sickPets.remove(p);
        }
        pets.clear();

        for (Item item : items) {
            if (item instanceof Pet) {
                // 5 % chance to change the health of the pet to false
                if (Math.random() < 0.05) {
                    ((Pet) item).setHealthy(false);
                    System.out.println("The pet " + ((Pet) item).getName() + " has become sick.");
                    // add the pet to the sick list
                    sickPets.add((Pet) item);
                    // remove the pet from the items list
                    pets.add((Pet) item);
                }
            }
        }

        for (Pet p : pets) {
            items.remove(p);
        }
    }

    public void trainAnimals() {

        System.out.println(trainer.getName() + " is training the animals.");
        trainer.trainAnimals(this.items);

    }

    // Decorator Pattern for add on itmes
    // Wrap item with add on items
    Item addOnItems(Item item) {

        if (item instanceof Pet) { //
            // 50% chance customer will be buy microchip
            if (Math.random() < 0.50) {
                item = new Microchip(item, "Microchip", 50.00, 0);
                item.setSalePrice(50.00);
            }

            // 25% chance customer will be buy pet insurance
            if (Math.random() < 0.25) {
                item = new Insurance(item, "Pet Insurance", 50.00, 0);
                item.setSalePrice(50.00);
            }

            // 25% chance customer will be buy pre paid vet visits

            if (Math.random() < 0.25) {

                int max_prepaid = 4; // max number to be bought
                int min_prepaid = 1; // min to be bought
                // get a int from min_prepaid to max_prepaid randomly
                int number_prepaid = (int) (Math.random() * (max_prepaid - min_prepaid) + min_prepaid);

                item = new PrepaidVet(item, "Prepad Vet", 25.00, 0, number_prepaid);
                item.setSalePrice(25.00);

            }

        }
        return item;
    }

    void sellItem(Item item) {
        cashRegister.deposit(item.getSalePrice());
        System.out.println("Clerk " + clerk.getName() + " has sold " + item.getName() + " for $"
                + item.getSalePrice());
        item.setDaySold(age);
        itemsSold.add(item);
        items.remove(item);

        Employee seller = clerk;
        if (item.getListPrice() != item.getSalePrice()) {
            seller = trainer;
        }

        employeeActionsObservable.firePropertyChange("itemSold", null, new ItemSoldEvent(seller, item));
    }

    // processes the deliveries and returns the number of items added to the store
    int processDeliveries() {
        ArrayList<Order> ordersToRemove = new ArrayList<Order>();
        int itemsAdded = 0;
        // process the orders
        for (Order order : orders) {
            Item item = order.checkForOrder();
            if (item != null) {
                item.setDayArrived(age);
                // add the item to the items list
                items.add(item);
                itemsAdded++;
                // remove the order from the orders list
                ordersToRemove.add(order);
            }
        }
        // remove the orders from the orders list
        for (Order order : ordersToRemove) {
            orders.remove(order);
        }

        return itemsAdded;
    }
}
