package hw3;

public class PlaceAnOrderEvent extends StoreEvent {
    private int numOrdered;
    
    public PlaceAnOrderEvent(Employee employee, int numOrdered) {
        super(employee);
        this.numOrdered = numOrdered;
    }

    public int getNumOrdered() {
        return numOrdered;
    }
}
