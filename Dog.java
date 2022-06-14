public class Dog extends Pet {
    private int size;
    private String color;
    private boolean housebroken;
    private boolean purebred;

    public Dog(String name, double purchasePrice, int dayArrived, String breed, int age, boolean healthy, int size, String color, boolean housebroken, boolean purebred) {
        super(name, purchasePrice, dayArrived, breed, age, healthy);
        this.size = size;
        this.color = color;
        this.housebroken = housebroken;
        this.purebred = purebred;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public boolean isHousebroken() {
        return housebroken;
    }

    public boolean isPurebred() {
        return purebred;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setHousebroken(boolean housebroken) {
        this.housebroken = housebroken;
    }

    public void setPurebred(boolean purebred) {
        this.purebred = purebred;
    }
}
