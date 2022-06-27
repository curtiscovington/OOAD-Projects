package hw3;
public class Toy extends Supply {
    private String animal;

    public Toy(String name, double purchasePrice, int dayArrived, String animal) {
        super(name, purchasePrice, dayArrived);
        this.animal = animal;
    }

    static public Item newRandomItem(int dayArrived) {
        // an array of random dog names to choose from
        String[] names = { "NameBrand Toy", "Knockoff Toy" };
        String name = names[(int) (Math.random() * names.length)];

        // random purchase price between $10 and $20
        double purchasePrice = (Math.random() * 10) + 10;

        // random animal type
        String[] animals = { "Cat", "Dog", "Bird" };
        String animal = animals[(int) (Math.random() * animals.length)];

        return new Toy(name, purchasePrice, dayArrived, animal);
    }
}