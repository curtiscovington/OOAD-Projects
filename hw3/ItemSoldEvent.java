package hw3;

public class ItemSoldEvent extends StoreEvent {
    Item item;

    public ItemSoldEvent(Employee employee, Item item) {
        super(employee);
        this.item = item;
    }
    
    public Item getItem() {
        return item;
    }

    @Override
    public String toString() {
        String str = super.toString();
        return "ItemSoldEvent: " + str + ", item: " + item.getName();
    }
}
