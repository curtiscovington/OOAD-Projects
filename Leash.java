public class Leash extends Supply {
    private String animal;

    public Leash(String name, double purchasePrice, int dayArrived, String animal) {
        super(name, purchasePrice, dayArrived);
        this.animal = animal;
    }
}
