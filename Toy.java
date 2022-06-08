public class Toy extends Supply {
    private String animal;

    public Toy(String name, double purchasePrice, double salePrice, int dayArrived, int daySold, String animal) {
        super(name, purchasePrice, salePrice, dayArrived, daySold);
        this.animal = animal;
    }
}