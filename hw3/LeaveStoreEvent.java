package hw3;

public class LeaveStoreEvent extends StoreEvent {
    
    LeaveStoreEvent(Employee employee) {
        super(employee);
    }

    @Override
    public String toString() {
        String str = super.toString();
        return "LeaveStoreEvent: " + str;
    }
}
