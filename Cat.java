public class Cat extends Pet {
    private String color;
    private boolean housebroken;
    private boolean purebred;
    
    public Cat(String name, double purchasePrice, int dayArrived, String breed, int age, boolean healthy, String color, boolean housebroken, boolean purebred) {
        super(name, purchasePrice, dayArrived, breed, age, healthy);
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
