package hw4;

public class ArriveAtStoreEvent extends StoreEvent {
    
    ArriveAtStoreEvent(Employee employee) {
        super(employee);
    }

    @Override
    public String toString() {
        String str = super.toString();
        return "ArriveAtStoreEvent: " + str;
    }
}
