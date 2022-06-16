package hw2;
public class Cat extends Pet {
    private String color;
    private boolean housebroken;
    private boolean purebred;
    
    public Cat(String name, double purchasePrice, int dayArrived, String breed, int age, boolean healthy, String color, boolean housebroken, boolean purebred) {
        super(name, purchasePrice, dayArrived, breed, age, healthy);
        this.color = color;
        this.housebroken = housebroken;
        this.purebred = purebred;
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
        String[] names = { "Watson", "Bob", "Kitty", "Sir Purrington" };
        // choose a random name
        String name = names[(int) (Math.random() * names.length)];
        // random purchase price between $25 and $100.00
        double purchasePrice = (Math.random() * 75) + 25;

        String[] breeds = { "Persian", "Siamese", "Ragdoll" };
        String breed = breeds[(int) (Math.random() * breeds.length)];

        // random age between 1 and 10
        int age = (int) (Math.random() * 10) + 1;

        // random color
        String[] colors = { "Black", "White", "Brown", "Gray", "Yellow" };
        String color = colors[(int) (Math.random() * colors.length)];

        return new Cat(name, purchasePrice, dayArrived, breed, age, true, color, Math.random() < 0.5, Math.random() < 0.5);
    }
}
