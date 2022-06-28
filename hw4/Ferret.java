package hw4;

public class Ferret extends Pet {
    private String color;
    private boolean housebroken;

    public Ferret(String name, double purchasePrice, int dayArrived, String breed, int age, boolean healthy, String color, boolean housebroken) {
        super(name, purchasePrice, dayArrived, breed, age, healthy);
        this.color = color;
        this.housebroken = housebroken;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isHousebroken() {
        return housebroken;
    }

    public void setHousebroken(boolean housebroken) {
        this.housebroken = housebroken;
    }
    
    static public Item newRandomItem(int dayArrived) {
        // an array of random dog names to choose from
        String[] names = { "Fido", "Buddy", "Bod", "Joy", "Lucas", "Adams", "Coco" };
        // choose a random name
        String name = names[(int) (Math.random() * names.length)];
        // random purchase price between $25 and $100.00
        double purchasePrice = (Math.random() * 75) + 25;

        String[] petBreed = { "Ferret" };
        String breed = petBreed[(int) (Math.random() * petBreed.length)];

        // random age between 1 and 10
        int age = (int) (Math.random() * 10) + 1;

        // random color
        String[] colors = { "Black", "White", "Brown", "Gray", "Yellow" };
        String color = colors[(int) (Math.random() * colors.length)];

        return new Ferret(name, purchasePrice, dayArrived, breed, age, true, color, false);
    }
    
}
