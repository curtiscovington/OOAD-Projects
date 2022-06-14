public class CatLitter extends Supply {
    public int size;

    public CatLitter(String name, double purchasePrice, int dayArrived, int size) {
        super(name, purchasePrice, dayArrived);
        this.size = size;
    }
}
