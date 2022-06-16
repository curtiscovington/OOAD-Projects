package hw2;
public class Food extends Supply {
    private int size;
    private String animal;
    private String type;

    public Food(String name, double purchasePrice, int dayArrived, int size, String animal, String type) {
        super(name, purchasePrice, dayArrived);
        this.size = size;
        this.animal = animal;
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public String getAnimal() {
        return animal;
    }

    public String getType() {
        return type;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setType(String type) {
        this.type = type;
    }

    static public Item newRandomItem(int dayArrived) {
        // an array of random dog names to choose from
        String[] names = { "Petkit food", "Knockoff food" };
        String name = names[(int) (Math.random() * names.length)];

        // random purchase price between $10 and $5
        double purchasePrice = (Math.random() * 10) + 5;
        // random animal type
        String[] animals = { "Cat", "Dog", "Bird" };
        String animal = animals[(int) (Math.random() * animals.length)];

        // random type of food
        String[] types = { "Wet", "Dry" };
        String type = types[(int) (Math.random() * types.length)];

        // random size between 1 and 10
        int size = (int) (Math.random() * 10) + 1;

        return new Food(name, purchasePrice, dayArrived, size, animal, type);
    }
}
