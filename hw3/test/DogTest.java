package hw3.test;
import hw3.Dog;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;


public class DogTest {

    private Dog dog;

    @Before
    public void setUp() throws Exception {
        dog = new Dog("Buddy", 25, 3, "Chow", 
        2, true, 2, "Black", true, true);
    }

    @Test
    public void testgetName() {
   
        Assert.assertEquals("Buddy",dog.getName());
    }
    @Test
    public void testgetPurchasePrice() {
   
        Assert.assertEquals(25.00, dog.getPurchasePrice(), 0.00);
    }
    @Test
    public void testgetDayArrived() {
   
        Assert.assertEquals(3,dog.getDayArrived());
    }
    @Test
    public void testgetBreed() {
   
        Assert.assertEquals("Chow", dog.getBreed());
    }
    @Test
    public void testgetAge() {
   
        Assert.assertEquals(2,dog.getAge());
    }
    @Test
    public void testgetColor() {
   
        Assert.assertEquals("Black",dog.getColor());
    }
    @Test
    public void testisHousebroken() {
   
        Assert.assertTrue(dog.isHousebroken());
    }
    @Test
    public void testisPurebred() {
   
        Assert.assertTrue(dog.isPurebred());
    }

}
