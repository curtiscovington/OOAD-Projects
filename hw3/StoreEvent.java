package hw3;

// Used in the observer pattern for events from the store
public class StoreEvent {
    Employee employee;

    public StoreEvent(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "( " +employee.getName() + " the " + employee.getEmployeeType() + " )";
    }
}
