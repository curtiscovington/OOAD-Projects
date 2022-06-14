public class Bank {

    double amountWithdrawn = 0;
    public Bank() {
    }

    public double withdraw(double requestedAmount) {
        this.amountWithdrawn += requestedAmount;
        return requestedAmount;
    }
}
