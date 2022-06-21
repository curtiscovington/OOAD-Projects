package hw3.test;
import hw3.Bank;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;


public class BankTest {

    private Bank bank;

    @Before
    public void setUp() throws Exception {
        bank = new Bank();
    }

    @Test
    public void testwithdraw() {
        bank.withdraw(100.00);
        bank.withdraw(100.00);
        bank.withdraw(100.00);
        Assert.assertEquals(300, bank.getAmountWithdrawn(), 0.00);
        bank.withdraw(500.00);
        Assert.assertEquals(800, bank.getAmountWithdrawn(), 0.00);
    }
}
