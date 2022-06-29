package hw4.test;
import hw4.*;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;


public class ClerkTest {

    private CashRegister cashRegister;
    private Bank bank;
    private Clerk clerk;
    ArrayList<Item> items = new ArrayList<Item>();


    @Before
    public void setUp() throws Exception {

        cashRegister = new CashRegister(200.00);
        bank = new Bank();
        clerk = new Clerk("Mark", bank);

        for (int i = 0; i < 3; i++) {

            items.add(Food.newRandomItem(0));
            items.add(Toy.newRandomItem(0));
            items.add(CatLitter.newRandomItem(0));
            items.add(Leash.newRandomItem(0));
            items.add(Cat.newRandomItem(0));
            items.add(Dog.newRandomItem(0));
            items.add(Bird.newRandomItem(0));

        }

    }

    @Test
    public void testcheckRegister() {

        Assert.assertEquals(200, clerk.checkRegister(cashRegister), 0.00);
    }
    @Test
    public void testgoToBank() {

        Assert.assertEquals(100, clerk.goToBank(100), 0.00);
    }
    @Test
    public void doInventory() {
        
        HashMap<String, Number>  inventory = clerk.doInventory(items);

        Assert.assertEquals(3, inventory.get("dogs"));
        Assert.assertEquals(3, inventory.get("cats"));
        Assert.assertEquals(3, inventory.get("birds"));
        Assert.assertEquals(3, inventory.get("leashes"));
        Assert.assertEquals(3, inventory.get("toys"));
        Assert.assertEquals(3, inventory.get("food"));
        Assert.assertEquals(3, inventory.get("cat litter"));

    }

    @Test
    public void testplaceOrder() {

        Dog dog = new Dog("Buddy", 25, 3, "Chow", 
        2, true, 2, "Black", true, true);

        Order order = clerk.placeOrder(dog);

        Assert.assertTrue(order instanceof Order);

      }
}
