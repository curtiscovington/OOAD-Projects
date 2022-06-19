package hw3;
public class CashRegister {
    private double total;

    public CashRegister() {
        total = 0;
    }

    public CashRegister(double total) {
        this.total = total;
    }

    public void deposit(double amount) {
        total += amount;
    }

    public double withdraw(double requestedAmount) {
        double amountToWithdraw = requestedAmount;
        // if the requested amount is greater than the total return the total
        if (requestedAmount > total) {
            amountToWithdraw = total;
            total = 0;
        } else {
            total -= requestedAmount;
        }

        return amountToWithdraw;
    }

    public double getTotal() {
        return total;
    }
    
}
