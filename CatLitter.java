public class CatLitter extends Supply {
    public int size;

    public CatLitter(String name, double purchasePrice, double salePrice, int dayArrived, int daySold, int size) {
        super(name, purchasePrice, salePrice, dayArrived, daySold);
        this.size = size;
    }
}
