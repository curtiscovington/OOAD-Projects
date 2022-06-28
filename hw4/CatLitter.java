package hw4;
public class CatLitter extends Supply {
    public int size;

    public CatLitter(String name, double purchasePrice, int dayArrived, int size) {
        super(name, purchasePrice, dayArrived);
        this.size = size;
    }

    static public Item newRandomItem(int dayArrived) {
        // an array of random dog names to choose from
        String[] names = { "NameBrand Litter", "Knockoff Litter" };
        String name = names[(int) (Math.random() * names.length)];

        // random purchase price between $10 and $20
        double purchasePrice = (Math.random() * 10) + 10;

        // random size between 1 and 10
        int size = (int) (Math.random() * 10) + 1;

        return new CatLitter(name, purchasePrice, dayArrived, size);
    }
}
