package hw2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Clerk extends Employee {
    // TODO: change this to a location directory that has all the world locations
    private Bank bank;
    public Clerk(String name, Bank bank) {
        super(name);
        this.bank = bank;
    }

    public double checkRegister(CashRegister register) {
        return register.getTotal();
        
    }

    public double goToBank(double requestedAmount) {
        return bank.withdraw(requestedAmount);
    }

    public HashMap<String, Number>  doInventory(ArrayList<Item> items) {
        int dogCount = 0;
        int catCount = 0;
        int birdCount = 0;
        int leashCount = 0;
        int toyCount = 0;
        int foodCount = 0;
        int catLitterCount = 0;

        double total = 0;
        for (Item item : items) {
            total += item.getPurchasePrice();
            if (item instanceof Dog) {
                dogCount++;
            } else if (item instanceof Cat) {
                catCount++;
            } else if (item instanceof Bird) {
                birdCount++;
            } else if (item instanceof Leash) {
                leashCount++;
            } else if (item instanceof Toy) {
                toyCount++;
            } else if (item instanceof Food) {
                foodCount++;
            } else if (item instanceof CatLitter) {
                catLitterCount++;
            }
        }

        HashMap<String, Number> inventory = new HashMap<String, Number>();
        inventory.put("dogs", dogCount);
        inventory.put("cats", catCount);
        inventory.put("birds", birdCount);
        inventory.put("leashes", leashCount);
        inventory.put("toys", toyCount);
        inventory.put("food", foodCount);
        inventory.put("cat litter", catLitterCount);
        inventory.put("total", total);

        return inventory;
    }

    public Order placeOrder(Item item) {
        return new Order(item);
    }
}
