public class Leash extends Supply {
    private String animal;

    public Leash(String name, double purchasePrice, int dayArrived, String animal) {
        super(name, purchasePrice, dayArrived);
        this.animal = animal;
    }

    static public Item newRandomItem(int dayArrived) {
        // an array of random dog names to choose from
        String[] names = { "Fancy Leash", "Knockoff Leash" };
        String name = names[(int) (Math.random() * names.length)];

        // random purchase price between $10 and $20
        double purchasePrice = (Math.random() * 10) + 1;


        return new Leash(name, purchasePrice, dayArrived, "Dog");
    }
}
