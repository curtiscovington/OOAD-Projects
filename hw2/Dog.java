package hw2;
import java.util.ArrayList;

public class Dog extends Pet {
    private int size;
    private String color;
    private boolean housebroken;
    private boolean purebred;

    public Dog(String name, double purchasePrice, int dayArrived, String breed, int age, boolean healthy, int size,
            String color, boolean housebroken, boolean purebred) {
        super(name, purchasePrice, dayArrived, breed, age, healthy);
        this.size = size;
        this.color = color;
        this.housebroken = housebroken;
        this.purebred = purebred;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public boolean isHousebroken() {
        return housebroken;
    }

    public boolean isPurebred() {
        return purebred;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHousebroken(boolean housebroken) {
        this.housebroken = housebroken;
    }

    public void setPurebred(boolean purebred) {
        this.purebred = purebred;
    }

    static public Item newRandomItem(int dayArrived) {
        // an array of random dog names to choose from
        String[] dogNames = { "Fido", "Buddy", "Bod", "Joy" };
        // choose a random name
        String name = dogNames[(int) (Math.random() * dogNames.length)];
        // random purchase price between $25 and $100.00
        double purchasePrice = (Math.random() * 75) + 25;

        String[] dogBreed = { "Lab", "German Shepard", "Chow", "Boxer", "Poodle" };
        String breed = dogBreed[(int) (Math.random() * dogBreed.length)];

        // random age between 1 and 10
        int age = (int) (Math.random() * 10) + 1;

        // random size between 1 and 5
        int size = (int) (Math.random() * 5) + 1;

        // random color
        String[] colors = { "Black", "White", "Brown", "Gray", "Yellow" };
        String color = colors[(int) (Math.random() * colors.length)];

        return new Dog(
                name,
                purchasePrice,
                dayArrived,
                breed,
                age,
                true,
                size,
                color,
                Math.random() < 0.5,
                Math.random() < 0.5);
    }
}
