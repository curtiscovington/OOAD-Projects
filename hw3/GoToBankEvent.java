package hw3;

public class GoToBankEvent extends StoreEvent {
    private double amount;

    public GoToBankEvent(Employee employee, double amount) {
        super(employee);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        String str = super.toString();
        return "GoToBankEvent: " + str + ", amount: " + amount;
    }
    
}
