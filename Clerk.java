public class Clerk extends Employee {
    // TODO: change this to a location directory that has all the world locations
    private Bank bank;
    public Clerk(String name, Bank bank) {
        super(name);
        this.bank = bank;
    }

    public double checkRegister(CashRegister register) {
        return register.getTotal();
        
    }

    public double goToBank(double requestedAmount) {
        return bank.withdraw(requestedAmount);
    }

    public void doInventory() {
        
    }

    public void placeOrder() {

    }

}
