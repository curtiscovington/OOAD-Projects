package hw3;

public class DoInventoryEvent extends StoreEvent {
    private int pets;
    private int supplies;
    private double purchasePrice;

    public DoInventoryEvent(Employee employee, int pets, int supplies, double purchasePrice) {
        super(employee);
        this.pets = pets;
        this.supplies = supplies;
        this.purchasePrice = purchasePrice;
    }

    public int getPets() {
        return pets;
    }

    public int getSupplies() {
        return supplies;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    @Override
    public String toString() {
        String str = super.toString();
        return "DoInventoryEvent: " + str + ", pets: " + pets + ", supplies: " + supplies + ", purchasePrice: " + purchasePrice;
    }
}
