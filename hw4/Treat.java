package hw4;

public class Treat extends Supply {
    private String animal;

    public Treat(String name, double purchasePrice, int dayArrived, String animal) {
        super(name, purchasePrice, dayArrived);
        this.animal = animal;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    static public Item newRandomItem(int dayArrived) {
        // an array of random dog names to choose from
        String[] names = { "NameBrand Treat", "Knockoff Treat" };
        String name = names[(int) (Math.random() * names.length)];

        // random purchase price between $10 and $20
        double purchasePrice = (Math.random() * 10) + 10;

        // random animal type
        String[] animals = { "Cat", "Dog", "Bird", "Snake", "Ferret" };
        String animal = animals[(int) (Math.random() * animals.length)];

        return new Toy(name, purchasePrice, dayArrived, animal);
    }
    
}
