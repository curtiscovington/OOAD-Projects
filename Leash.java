public class Leash extends Supply {
    private String animal;

    public Leash(String name, double purchasePrice, double salePrice, int dayArrived, int daySold, String animal) {
        super(name, purchasePrice, salePrice, dayArrived, daySold);
        this.animal = animal;
    }
}
