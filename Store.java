import java.util.ArrayList;


public class Store {
    CashRegister cashRegister = new CashRegister();
    ArrayList<Item> items = new ArrayList<Item>();
    ArrayList<Employee> employeesWorking = new ArrayList<Employee>();
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
            employeesWorking.add((Employee) p);
            ((Employee) p).arriveAtStore();
            String name = ((Employee) p).getName();
            String employeeType;
            if (p instanceof Clerk) {
                employeeType = "Clerk";
            } else {
                employeeType = "Trainer";
            }
            System.out.println("Employee " + name + " the " + employeeType + " has arrived at the store.");
        }
    }

    // public Person leaveStore() {
    
    // }
    public void increaseAge() {
        age++;
    }
}
