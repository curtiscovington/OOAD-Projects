public class Food extends Supply {
    private int size;
    private String animal;
    private String type;

    public Food(String name, double purchasePrice, double salePrice, int dayArrived, int daySold, int size, String animal, String type) {
        super(name, purchasePrice, salePrice, dayArrived, daySold);
        this.size = size;
        this.animal = animal;
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public String getAnimal() {
        return animal;
    }

    public String getType() {
        return type;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }

    public void setType(String type) {
        this.type = type;
    }
}
