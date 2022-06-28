package hw4;

public class ProcessDeliveriesEvent extends StoreEvent {
    private int itemsAdded;
    public ProcessDeliveriesEvent(Employee employee, int itemsAdded) {
        super(employee);
        this.itemsAdded = itemsAdded;
    }

    public int getItemsAdded() {
        return itemsAdded;
    }

    @Override
    public String toString() {
        String str = super.toString();
        return "ProcessDeliveriesEvent: " + str + ", itemsAdded: " + itemsAdded;
    }
}
