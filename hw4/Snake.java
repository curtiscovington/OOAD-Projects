package hw4;

public class Snake extends Pet {
    private int size;

    public Snake(String name, double purchasePrice, int dayArrived, String breed, int age, boolean healthy, int size) {
        super(name, purchasePrice, dayArrived, breed, age, healthy);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    static public Item newRandomItem(int dayArrived) {
        // an array of random dog names to choose from
        String[] names = { "NOPE", "Noperino", "NoooooooooOOo", "Snek", "SnAKEEEEEEEE" };
        // choose a random name
        String name = names[(int) (Math.random() * names.length)];
        // random purchase price between $25 and $100.00
        double purchasePrice = (Math.random() * 75) + 25;

        String[] petBreed = { "Black Mamba", "Python", "Rattlesnake" };
        String breed = petBreed[(int) (Math.random() * petBreed.length)];

        // random age between 1 and 10
        int age = (int) (Math.random() * 10) + 1;

        // random age between 1 and 10
        int size = (int) (Math.random() * 10) + 1;

        return new Snake(name, purchasePrice, dayArrived, breed, age, true, size);
    }
    
}
