package hw4;

public class CheckRegisterEvent extends StoreEvent {
    private double amount;
    
    public CheckRegisterEvent(Employee employee, double amount) {
        super(employee);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        String str = super.toString();
        return "CheckRegisterEvent: " + str + ", amount: " + amount;
    }
}
