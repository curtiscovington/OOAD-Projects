import java.util.ArrayList;


public class Store {
    CashRegister cashRegister = new CashRegister();
    ArrayList<Item> items = new ArrayList<Item>();
    ArrayList<Pet> sickPets = new ArrayList<Pet>();

    Trainer trainer;
    Clerk clerk;

    int age = 0;
    // Constructor
    public Store() {
        // three instances of each lowest subclass
        addItem(new Food("Food", 2.00, 0,  1, "dog", "Type"));
        addItem(new Food("Food", 4.00, 0,  2, "dog", "Type"));
        addItem(new Food("Food", 6.00, 0,  3, "cat", "Type"));

        addItem(new Toy("Toy", 3.00, 0,  "dog"));
        addItem(new Toy("Toy", 3.00, 0,  "dog"));
        addItem(new Toy("Toy", 5.00, 0,  "dog"));

        addItem(new CatLitter("CatLitter", 10.00, 0,  1));
        addItem(new CatLitter("CatLitter", 10.00, 0,  1));
        addItem(new CatLitter("CatLitter", 10.00, 0,  1));

        addItem(new Leash("Leash", 5.00, 0,  "dog"));
        addItem(new Leash("Leash", 5.00, 0,  "dog"));
        addItem(new Leash("Leash", 5.00, 0,  "dog"));

        addItem(new Cat("Bob", 50.00, 0, "cat", 1, true, "black", true, true));
        addItem(new Cat("Meowzer", 50.00, 0, "cat", 4, true, "white", true, true));
        addItem(new Cat("Meowzer Jr", 50.00, 0, "cat", 1, true, "white", true, true));

        addItem(new Dog("Fido", 50.00, 0, "husky", 1, true, 0, "black", true, true));
        addItem(new Dog("Sir Barkington", 50.00, 0, "german shepard", 4, true, 0, "black", true, true));
        addItem(new Dog("Spot", 50.00, 0, "black lab", 1, true, 0, "black", true, true));
        
        addItem(new Bird("Zera", 50.00,0, "scarlet macaw", 1, true, 3, true, true, true));
        addItem(new Bird("Birdy", 25.00,0, "crow", 1, true, 1, true, false, false));
        addItem(new Bird("Sam", 50.00,0, "blue gold macaw", 1, true, 1, true, true, true));

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

    public void runDay() {
        clerkTasks();
        trainerTasks();
    }

    public void clerkTasks() {
        // check the register
        double amount = clerk.checkRegister(cashRegister);
        System.out.println("Clerk " + clerk.getName() + " has checked the register and found that the total is $" + amount);

        if (amount < 200) {
            // the clerk needs to go to the bank
            amount = clerk.goToBank(1000);
            System.out.println("Clerk " + clerk.getName() + " has gone to the bank and withdrew $" + amount);
            cashRegister.deposit(amount);
        }

        
    }

    public void trainerTasks() {
        feedAnimals();
    }

    // public Person leaveStore() {
    
    // }
    public void increaseAge() {
        age++;
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
}
