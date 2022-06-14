public class Toy extends Supply {
    private String animal;

    public Toy(String name, double purchasePrice, int dayArrived, String animal) {
        super(name, purchasePrice, dayArrived);
        this.animal = animal;
    }
}