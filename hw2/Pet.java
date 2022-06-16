package hw2;
// Pet is a child class of Item
public abstract class Pet extends Item {
    private String breed;
    private int age;
    private boolean healthy;

    public Pet(String name, double purchasePrice, int dayArrived, String breed, int age, boolean healthy) {
        super(name, purchasePrice, dayArrived);
        this.breed = breed;
        this.age = age;
        this.healthy = healthy;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    public boolean isHealthy() {
        return healthy;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHealthy(boolean healthy) {
        this.healthy = healthy;
    }
}
