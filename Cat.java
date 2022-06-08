public class Cat extends Pet {
    private String color;
    private boolean housebroken;
    private boolean purebred;
    
    public Cat(String name, double purchasePrice, double listPrice, double salePrice, int dayArrived, int daySold, String breed, int age, boolean healthy, String color, boolean housebroken, boolean purebred) {
        super(name, purchasePrice, listPrice, salePrice, dayArrived, daySold, breed, age, healthy);
        this.color = color;
        this.housebroken = housebroken;
        this.purebred = purebred;
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
